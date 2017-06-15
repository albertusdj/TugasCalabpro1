package view;

import jsonProcessor.*;
import searcher.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import java.util.*;
/**
 * Kelas yang mengontrol alur tampilan GUI
 * @author albert
 *
 */
public class viewController {
	
	
	/**
	 * String yang berisi data json dari url hasil pencarian
	 */
	String urlQuery;
	
	
	/**
	 * array yang berisi daftar user hasil pencarian sesuai kata kunci
	 */
	ArrayList<String> listOfUser;
	
	
	/**
	 * Objek yang menyimpan hasil terjemahan string dalam format json
	 */
	StringConverterToJson converter;
	
	
	/**
	 * halaman web daftar user saat ini
	 */
	int currentPageUser;
	
	
	/**
	 * halaman web repository user saat ini
	 */
	int currentPageRepo;
	
	
	/**
	 * Objek yang menampilkan tampilan utama
	 */
	MainView mainView;
	
	
	/**
	 * Objek yang menampilkan tampilan daftar user
	 */
	UserList userListView;
	
	
	/**
	 * Objek yang menampilkan tampilan daftar repository
	 */
	UserRepo repoViewer;
	
	
	/**
	 * Constructor
	 */
	public viewController() {
		mainView = new MainView();
		mainView.view();
		
		mainView.searchButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String keyWord = mainView.searchKey.getText();
				boolean isKeyWordFilled = true;
				boolean isSearchOptionSelected = true;
				if(keyWord.equals("")){
					JOptionPane.showMessageDialog(mainView.mainFrame, "Search box musn't empty");
					isKeyWordFilled = false;
				}
				
				if(!mainView.userNameOption.isSelected() && !mainView.emailOption.isSelected() && !mainView.fullNameOption.isSelected()){
					JOptionPane.showMessageDialog(mainView.mainFrame, "Choose one of the search option");
					isSearchOptionSelected = false;
				}
				
				if(isKeyWordFilled && isSearchOptionSelected){
					currentPageUser = 1;
					SearcherCaseOrganizer(currentPageUser);

					mainView.hide();
					userListView = new UserList(listOfUser);
					userListView.view();
					
					userListView.prevButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							if(currentPageUser==1){
								JOptionPane.showMessageDialog(userListView.userListFrame, "Current page is first page");
							}
							else{
								currentPageUser--;
								
								SearcherCaseOrganizer(currentPageUser);
								userListView.setListOfUser(listOfUser);
							}
						}
					});
					
					userListView.nextButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							if(currentPageUser == converter.getMaxPage()){
								JOptionPane.showMessageDialog(userListView.userListFrame, "Current page is last page");
							}
							else{
								currentPageUser++;
								
								SearcherCaseOrganizer(currentPageUser);
								userListView.setListOfUser(listOfUser);
								
							}
						}
					});
					
					userListView.okButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							ArrayList<Repository> userRepo = new ArrayList<Repository>();
							currentPageRepo = 1;
							if(userListView.listForView.getSelectedIndex()==-1){
								JOptionPane.showMessageDialog(userListView.userListFrame, "Please select one of the user");
							}
							else{
								try {
									
									converter = new StringConverterToJson(urlQuery, currentPageUser);
									userRepo = converter.getUserRepo(userListView.listForView.getSelectedValue(), currentPageRepo);
									
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								
								repoViewer = new UserRepo(userRepo);
								userListView.hide();
								repoViewer.view();
								
								repoViewer.prevButton.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										if(currentPageRepo==1){
											JOptionPane.showMessageDialog(repoViewer.repoFrame, "Current page is first page");
										}
										else{
											if(currentPageRepo == 1){
												JOptionPane.showMessageDialog(repoViewer.repoFrame, "Current page is first page");
											}
											currentPageRepo--;
											try {
												repoViewer.setTable(converter.getUserRepo(userListView.listForView.getSelectedValue(), currentPageRepo));
											} catch (IOException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										}
									}
								});
								
								repoViewer.nextButton.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										currentPageRepo++;
										try {
											ArrayList<Repository> temp = converter.getUserRepo(userListView.listForView.getSelectedValue(), currentPageRepo);
											if(temp.isEmpty()){
												currentPageRepo--;
												JOptionPane.showMessageDialog(repoViewer.repoFrame, "Current page is last page");
											}
											else{
												repoViewer.setTable(converter.getUserRepo(userListView.listForView.getSelectedValue(), currentPageRepo));
											}
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								});
								
								repoViewer.cancelButton.addActionListener(new ActionListener(){
									public void actionPerformed(ActionEvent e){
										repoViewer.hide();
										userListView.view();
									}
								});
							}
						}
					});
					
					userListView.cancelButton.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							userListView.hide();
							mainView.view();
						}
					});
				}
			}
		});
		
		mainView.cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev){
				System.exit(0);
			}
		});
		
		
		
		
	}
	
	/**
	 * Fungsi untuk mendapatkan data daru halaman url tertentu
	 * @param _currentPageUser halaman saat ini
	 */
	public void SearcherCaseOrganizer(int _currentPageUser){
		String filterRepoMin = mainView.filterRepoMin.getText();
		String filterRepoMax = mainView.filterRepoMax.getText();
		String filterFollowerMin = mainView.filterFollowerMin.getText();
		String filterFollowerMax = mainView.filterFollowerMax.getText();
		currentPageUser = _currentPageUser;
		
		if(filterRepoMin.equals("") && filterRepoMax.equals("") && filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //keempat kotak filter kosong
			if(mainView.userNameOption.isSelected()){
				UserNameSearcher searcher = new UserNameSearcher(mainView.searchKey.getText());
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcher searcher = new EmailSearcher(mainView.searchKey.getText());
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcher searcher  = new FullNameSearcher(mainView.searchKey.getText());
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && filterRepoMax.equals("") && filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterRepoMin diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMin searcher = new UserNameSearcherFilterRepoMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMin searcher = new EmailSearcherFilterRepoMin(mainView.searchKey.getText(),Integer.parseInt(mainView.filterRepoMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMin searcher =  new FullNameSearcherFilterRepoMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && !filterRepoMax.equals("") && filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterRepoMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMax searcher = new UserNameSearcherFilterRepoMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMax searcher = new EmailSearcherFilterRepoMax(mainView.searchKey.getText(),Integer.parseInt(mainView.filterRepoMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMax searcher = new FullNameSearcherFilterRepoMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && !filterRepoMax.equals("") && filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterRepoMin dan filterRepoMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinMax searcher = new UserNameSearcherFilterRepoMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()),Integer.parseInt(mainView.filterRepoMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinMax searcher = new EmailSearcherFilterRepoMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()),Integer.parseInt(mainView.filterRepoMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinMax searcher = new FullNameSearcherFilterRepoMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()),Integer.parseInt(mainView.filterRepoMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && filterRepoMax.equals("") && !filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterFollowerMin diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterFollowerMin searcher = new UserNameSearcherFilterFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterFollowerMin searcher = new EmailSearcherFilterFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterFollowerMin searcher = new FullNameSearcherFilterFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && filterRepoMax.equals("") && filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterFollowerMax searcher = new UserNameSearcherFilterFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterFollowerMax searcher = new EmailSearcherFilterFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterFollowerMax searcher = new FullNameSearcherFilterFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && filterRepoMax.equals("") && !filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterFollowerMin dan filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterFollowerMinMax searcher = new UserNameSearcherFilterFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterFollowerMinMax searcher = new EmailSearcherFilterFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterFollowerMinMax searcher = new FullNameSearcherFilterFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && filterRepoMax.equals("") && !filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterRepoMin dan filterFollowerMin diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinFollowerMin searcher = new UserNameSearcherFilterRepoMinFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinFollowerMin searcher = new EmailSearcherFilterRepoMinFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()),Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinFollowerMin searcher = new FullNameSearcherFilterRepoMinFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && !filterRepoMax.equals("") && filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterRepoMax dan filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMaxFollowerMax searcher = new UserNameSearcherFilterRepoMaxFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMaxFollowerMax searcher = new EmailSearcherFilterRepoMaxFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMaxFollowerMax searcher = new FullNameSearcherFilterRepoMaxFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && filterRepoMax.equals("") && filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterRepoMin dan filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinFollowerMax searcher = new UserNameSearcherFilterRepoMinFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinFollowerMax searcher = new EmailSearcherFilterRepoMinFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinFollowerMax searcher = new FullNameSearcherFilterRepoMinFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && !filterRepoMax.equals("") && !filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterRepoMax dan filterFollowerMin diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMaxFollowerMin searcher = new UserNameSearcherFilterRepoMaxFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMaxFollowerMin searcher = new EmailSearcherFilterRepoMaxFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMaxFollowerMin searcher = new FullNameSearcherFilterRepoMaxFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && !filterRepoMax.equals("") && !filterFollowerMin.equals("") && filterFollowerMax.equals("")){ //filterRepoMin, filterRepoMax, dan filterFollowerMin diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinMaxFollowerMin searcher = new UserNameSearcherFilterRepoMinMaxFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinMaxFollowerMin searcher = new EmailSearcherFilterRepoMinMaxFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinMaxFollowerMin searcher = new FullNameSearcherFilterRepoMinMaxFollowerMin(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && !filterRepoMax.equals("") && filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterRepoMin, filterRepoMax, dan filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinMaxFollowerMax searcher = new UserNameSearcherFilterRepoMinMaxFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinMaxFollowerMax searcher = new EmailSearcherFilterRepoMinMaxFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinMaxFollowerMax searcher = new FullNameSearcherFilterRepoMinMaxFollowerMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && filterRepoMax.equals("") && !filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterRepoMin, filterFollowerMin, dan filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinFollowerMinMax searcher = new UserNameSearcherFilterRepoMinFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinFollowerMinMax searcher = new EmailSearcherFilterRepoMinFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinFollowerMinMax searcher = new FullNameSearcherFilterRepoMinFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(filterRepoMin.equals("") && !filterRepoMax.equals("") && !filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //filterRepoMax, filterFollowerMin, dan filterFollowerMax diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMaxFollowerMinMax searcher = new UserNameSearcherFilterRepoMaxFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMaxFollowerMinMax searcher = new EmailSearcherFilterRepoMaxFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMaxFollowerMinMax searcher = new FullNameSearcherFilterRepoMaxFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
		else if(!filterRepoMin.equals("") && !filterRepoMax.equals("") && !filterFollowerMin.equals("") && !filterFollowerMax.equals("")){ //keempat kotak filter diisi
			if(mainView.userNameOption.isSelected()){
				UserNameSearcherFilterRepoMinMaxFollowerMinMax searcher = new UserNameSearcherFilterRepoMinMaxFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else if(mainView.emailOption.isSelected()){
				EmailSearcherFilterRepoMinMaxFollowerMinMax searcher = new EmailSearcherFilterRepoMinMaxFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			else{
				FullNameSearcherFilterRepoMinMaxFollowerMinMax searcher = new FullNameSearcherFilterRepoMinMaxFollowerMinMax(mainView.searchKey.getText(), Integer.parseInt(mainView.filterRepoMin.getText()), Integer.parseInt(mainView.filterRepoMax.getText()), Integer.parseInt(mainView.filterFollowerMin.getText()), Integer.parseInt(mainView.filterFollowerMax.getText()));
				
				urlQuery = searcher.getUrl();
			}
			
			converter = null;
			try {
				converter = new StringConverterToJson(urlQuery, currentPageUser);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listOfUser = converter.getListOfUser();
		}
	}
}
