package view;

import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Kelas yang mengatur tampilan daftar user name hasil pencarian
 * @author albert
 *
 */
public class UserList {
	/**
	 * array yang berisi daftar user name hasil pencarian
	 */
	ArrayList<String> listOfUser;
	/**
	 * daftar user name yang akan ditampilkan
	 */
	JList<String> listForView;
	/**
	 * frame untuk tampilan list of user
	 */
	JFrame userListFrame;
	/**
	 * Judul dari frame
	 */
	JLabel title;
	
	/**
	 * tombol ok
	 */
	JButton okButton;
	/**
	 * tombol cancel untuk kembali ke menu sebelumnya
	 */
	JButton cancelButton;
	/**
	 * tombol prev
	 */
	JButton prevButton;
	/**
	 * tombol next
	 */
	JButton nextButton;
	/**
	 * container yang menampung daftar user name agar dapat dicroll
	 */
	JScrollPane scrollPane;
	/**
	 * Constructor
	 * @param listOfUser array yang berisi user name
	 */
	public UserList(ArrayList<String> listOfUser){
		userListFrame = new JFrame("List of User");
		
		//title
		title = new JLabel("Search Result");
		title.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		title.setBounds(10, 10, 100, 30);
		userListFrame.add(title);
		
		//List of user
		DefaultListModel<String> tempList = new DefaultListModel<>();
		
		for(int i=0; i<listOfUser.size(); i++){
			tempList.addElement(listOfUser.get(i));
		}
		
		listForView = new JList<>(tempList);
		listForView.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane(listForView);
		scrollPane.setBounds(10, 50, 460, 320);
		userListFrame.add(scrollPane);
		
		//ok button
		okButton = new JButton("ok");
		okButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		okButton.setBackground(Color.WHITE);
		okButton.setBounds(310, 400, 70, 30);
		userListFrame.add(okButton);
		
		//cancel button
		cancelButton = new JButton("cancel");
		cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setBounds(400, 400, 70, 30);
		userListFrame.add(cancelButton);
		
		//prev button
		prevButton = new JButton("prev");
		prevButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		prevButton.setBackground(Color.WHITE);
	    prevButton.setBounds(10, 400, 70, 30);
		userListFrame.add(prevButton);
		
		//next button
		nextButton = new JButton("next");
		nextButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		nextButton.setBackground(Color.WHITE);
	    nextButton.setBounds(100, 400, 70, 30);
		userListFrame.add(nextButton);
		
		//set up the frame
		userListFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		userListFrame.setSize(500, 500);
		userListFrame.setLayout(null);
		userListFrame.getContentPane().setBackground(Color.WHITE);
		userListFrame.setResizable(false);
	}
	
	/**
	 * Fungsi untuk menampilkan user list
	 */
	public void view(){
		userListFrame.setVisible(true);
	}
	/**
	 * Fungsi untuk menyembunyikan user list
	 */
	public void hide(){
		userListFrame.setVisible(false);
	}
	
	/**
	 * Fungsi untuk mengubah userList dan menampilkan ulang scroll pane
	 * @param inputList daftar user baru yang akan ditampilkan
	 */
	public void setListOfUser(ArrayList<String> inputList){
		userListFrame.remove(scrollPane);
		
		listOfUser = inputList;
		DefaultListModel<String> tempList = new DefaultListModel<>();
		
		for(int i=0; i<listOfUser.size(); i++){
			tempList.addElement(listOfUser.get(i));
		}
		
		listForView = new JList<>(tempList);
		listForView.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		scrollPane = new JScrollPane(listForView);
		scrollPane.setBounds(10, 50, 460, 320);
		userListFrame.add(scrollPane);
		userListFrame.revalidate();
		userListFrame.repaint();
	}
}
