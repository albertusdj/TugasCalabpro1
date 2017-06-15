package view;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
/**
 * Kelas yang mengatur tampilan dari menu utama
 * @author albert
 *
 */
public class MainView{
	/**
	 * Frame yang menampung tampilan utama
	 */
	JFrame mainFrame;
	/**
	 * tempat user mengisi kata kunci
	 */
	JTextField searchKey;
	/**
	 * judul dari bagian kotak pencari
	 */
	JLabel searchBox;
	/**
	 * keterangan bagi user untuk mengisi kotak pencari
	 */
	JLabel searchBoxHint;
	
	/**
	 * judul dari bagian kategori pencarian
	 */
	JLabel searchCategory;
	/**
	 * opsi untuk mencari dengan user name
	 */
	JRadioButton userNameOption;
	/**
	 * opsi untuk mencari dengan email
	 */
	JRadioButton emailOption;
	/**
	 * opsi untuk mencari dengan nama lengkap
	 */
	JRadioButton fullNameOption;
	/**
	 * grup dari opsi pencarian
	 */
	ButtonGroup searchOption;
	
	/*
	 * judul dari filter pencarian
	 */
	JLabel searchFilter;
	/**
	 * kotak untuk mengisi filter pencarian jumlah repository minimum
	 */
	JTextField filterRepoMin;
	/**
	 * kotak untuk mengisi filter pencarian jumlah repository maksimum
	 */
	JTextField filterRepoMax;
	/**
	 * judul untuk bagian filter jumlah repository
	 */
	JLabel filterRepoLabel;
	/**
	 * label antara
	 */
	JLabel until1;
	/**
	 * kotak untuk mengisi filter pencarian jumlah follower maksimum
	 */
	JTextField filterFollowerMin;
	/**
	 * kotak untuk mengisi filter pencarian jumlah follower maksimum
	 */
	JTextField filterFollowerMax;
	/**
	 * judul untuk bagian filter jumlah follower
	 */
	JLabel filterFollowerLabel;
	/**
	 * label antara
	 */
	JLabel until2;
	
	/*
	 * Tombol untuk melakukan pencarian
	 */
	JButton searchButton;
	/*
	 * Tombol untuk keluar dari aplikasi
	 */
	JButton cancelButton;
	
	/*
	 * tinggi jendela utama
	 */
	int mainHeight;
	/*
	 * lebar jendela utama
	 */
	int mainWidth;
	
	/**
	 * Constructor
	 */
	public MainView(){
		mainFrame = new JFrame("GitSearch");
		mainHeight = 500;
		mainWidth = 500;
		
		//search box group
		TitledBorder titleSearchBox = BorderFactory.createTitledBorder("Search Box");
		titleSearchBox.setTitleFont(new Font("Segoe UI", Font.PLAIN, 12));
		searchBox = new JLabel();
		searchBox.setBorder(titleSearchBox);
		searchBox.setBounds(10, 10, mainWidth-40, 90);
		
		searchKey = new JTextField();
		searchKey.setBounds(20, 20, 100, 30);
		searchBox.add(searchKey);
		
		searchBoxHint = new JLabel("Input search key");
		searchBoxHint.setBounds(20, 50, 100, 30);
		searchBoxHint.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		searchBox.add(searchBoxHint);
		
		mainFrame.add(searchBox);
		
		//Search Category group
		TitledBorder titleSearchCategory = BorderFactory.createTitledBorder("Search Category");
		titleSearchCategory.setTitleFont(new Font("Segoe UI", Font.PLAIN, 12));
		searchCategory = new JLabel();
		searchCategory.setBorder(titleSearchCategory);
		searchCategory.setBounds(10, 110, mainWidth-40, 140);
		
		userNameOption = new JRadioButton("Search using user name");
		userNameOption.setBounds(10, 20, 200, 30);
		userNameOption.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		userNameOption.setBackground(Color.WHITE);
		
		emailOption = new JRadioButton("Search using email");
		emailOption.setBounds(10, 60, 200, 30);
		emailOption.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		emailOption.setBackground(Color.WHITE);
		
		fullNameOption = new JRadioButton("Search using full name");
		fullNameOption.setBounds(10, 100, 200, 30);
		fullNameOption.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fullNameOption.setBackground(Color.WHITE);
		
		searchOption = new ButtonGroup();
		searchOption.add(userNameOption);
		searchOption.add(emailOption);
		searchOption.add(fullNameOption);
		
		searchCategory.add(userNameOption);
		searchCategory.add(emailOption);
		searchCategory.add(fullNameOption);
		
		mainFrame.add(searchCategory);
		
		//Search Filter
		TitledBorder titleFilterSearch = BorderFactory.createTitledBorder("Search Filter");
		titleFilterSearch.setTitleFont(new Font("Segoe UI", Font.PLAIN, 12));
		searchFilter = new JLabel();
		searchFilter.setBorder(titleFilterSearch);
		searchFilter.setBounds(10, 260, mainWidth-40, 130);
		
		filterRepoLabel = new JLabel("Number of Repository :");
		filterRepoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		filterRepoLabel.setBounds(10, 20, 150, 30);
		
		filterRepoMin = new JTextField();
		filterRepoMin.setBounds(160, 20, 50, 30);
		
		until1 = new JLabel("until");
		until1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		until1.setBounds(220, 20, 100, 30);
		
		filterRepoMax = new JTextField();
		filterRepoMax.setBounds(260, 20, 50, 30);
		
		filterFollowerLabel = new JLabel("Number of Follower :");
		filterFollowerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		filterFollowerLabel.setBounds(10, 60, 150, 30);
		
		filterFollowerMin = new JTextField();
		filterFollowerMin.setBounds(160, 60, 50, 30);
		
		until2 = new JLabel("until");
		until2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		until2.setBounds(220, 60, 100, 30);
		
		filterFollowerMax = new JTextField();
		filterFollowerMax.setBounds(260, 60, 50, 30);
		
		searchFilter.add(filterRepoMin);
		searchFilter.add(until1);
		searchFilter.add(filterRepoMax);
		searchFilter.add(filterRepoLabel);
		searchFilter.add(filterFollowerMin);
		searchFilter.add(until2);
		searchFilter.add(filterFollowerMax);
		searchFilter.add(filterFollowerLabel);
		
		mainFrame.add(searchFilter);
		
		//search button
		searchButton = new JButton("Ok");
		searchButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		searchButton.setBackground(Color.WHITE);
		searchButton.setBounds(310, 400, 70, 30);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setBounds(400, 400, 70, 30);
		
		mainFrame.add(searchButton);
		mainFrame.add(cancelButton);
		
		//mainFrame set up
		mainFrame.setSize(mainWidth, mainHeight);
		mainFrame.setLocation(0,0);
		mainFrame.getContentPane().setBackground(Color.WHITE);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setLayout(null);
	}
	
	/**
	 * Fungsi untuk menampilkan mainView
	 */
	public void view(){
		mainFrame.setVisible(true);
	}
	
	/**
	 * Fungsi untuk menyembunyikan mainView
	 */
	public void hide(){
		mainFrame.setVisible(false);
	}
}
