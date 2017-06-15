package view;

import jsonProcessor.Repository;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;
/**
 * Kelas yang mengatur tampilan repository user
 * @author albert
 *
 */
public class UserRepo {
	
	/**
	 * frame untuk menampung repository user yang ditampilkan
	 */
	JFrame repoFrame;
	
	/**
	 * Label untuk menampilkan jumlah repository user
	 */
	JLabel title;
	
	/**
	 * tabel repository
	 */
	JTable tableOfRepo;
	
	/**
	 * tombol cancel
	 */
	JButton cancelButton;
	
	/**
	 * tombol untuk ke halaman berikutnya
	 */
	JButton nextButton;
	
	/**
	 * tombol untuk ke halaman sebelumnya
	 */
	JButton prevButton;
	
	/**
	 * scroll pane untuk menampung tabel repository
	 */
	JScrollPane scrollPane;
	
	/**
	 * Constructor
	 * @param input tabel reposotory input yang akan ditampilkan
	 */
	public UserRepo(ArrayList<Repository> input){
		repoFrame = new JFrame("User Repository");
		
		//title
		title = new JLabel("Number of Repositories in this page : " + input.size());
		title.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		title.setBounds(10, 10, 250, 30);
		repoFrame.add(title);
		
		//content
		String[] colomn = new String[3];
		colomn[0] = "Name";
		colomn[1] = "Description";
		colomn[2] = "url";
		
		String[][] data = new String[input.size()][3];
		for(int i=0; i<input.size(); i++){
			data[i][0] = input.get(i).getNama();
			data[i][1] = input.get(i).getDeskripsi();
			data[i][2] = input.get(i).getUrl();
		}
		
		tableOfRepo = new JTable(data, colomn);
		tableOfRepo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		tableOfRepo.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		 
		for (int column = 0; column < tableOfRepo.getColumnCount(); column++){
		    TableColumn tableColumn = tableOfRepo.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
		 
		    for (int row = 0; row < tableOfRepo.getRowCount(); row++){
		        TableCellRenderer cellRenderer = tableOfRepo.getCellRenderer(row, column);
		        Component c = tableOfRepo.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + tableOfRepo.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		 
		 
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		 
		    tableColumn.setPreferredWidth( preferredWidth );
		}
		
		scrollPane = new JScrollPane(tableOfRepo);
		scrollPane.setBounds(10, 50, 960, 410);
		repoFrame.add(scrollPane);
		
		//cancel button
		cancelButton = new JButton("cancel");
		cancelButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		cancelButton.setBackground(Color.WHITE);
		cancelButton.setBounds(900, 500, 70, 30);
		repoFrame.add(cancelButton);
		
		//next button
		nextButton = new JButton("next");
		nextButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		nextButton.setBackground(Color.WHITE);
		nextButton.setBounds(100, 500, 70, 30);
		repoFrame.add(nextButton);
		
		//prev button
		prevButton = new JButton("prev");
		prevButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		prevButton.setBackground(Color.WHITE);
		prevButton.setBounds(10, 500, 70, 30);
		repoFrame.add(prevButton);
		
		//set up frame
		repoFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		repoFrame.setLayout(null);
		repoFrame.setSize(1000, 600);
		repoFrame.getContentPane().setBackground(Color.WHITE);
		repoFrame.setResizable(false);
	}
	
	/**
	 * Fungsi untuk menampillkan userRepo
	 */
	public void view(){
		repoFrame.setVisible(true);
	}
	/**
	 * Fungsi untuk menyembunyikan userRepo
	 */
	public void hide(){
		repoFrame.setVisible(false);
	}
	
	/**
	 * Fungsi untuk mengganti nilai tabel dan menampilkan ulang scroll pane
	 * @param input array yang berisi data tabel yang akan diganti
	 */
	public void setTable(ArrayList<Repository> input){
		repoFrame.remove(scrollPane);
		
		String[] colomn = new String[3];
		colomn[0] = "Name";
		colomn[1] = "Description";
		colomn[2] = "url";
		
		String[][] data = new String[input.size()][3];
		for(int i=0; i<input.size(); i++){
			data[i][0] = input.get(i).getNama();
			data[i][1] = input.get(i).getDeskripsi();
			data[i][2] = input.get(i).getUrl();
		}
		
		tableOfRepo = new JTable(data, colomn);
		tableOfRepo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		
		tableOfRepo.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
		 
		for (int column = 0; column < tableOfRepo.getColumnCount(); column++){
		    TableColumn tableColumn = tableOfRepo.getColumnModel().getColumn(column);
		    int preferredWidth = tableColumn.getMinWidth();
		    int maxWidth = tableColumn.getMaxWidth();
		 
		    for (int row = 0; row < tableOfRepo.getRowCount(); row++){
		        TableCellRenderer cellRenderer = tableOfRepo.getCellRenderer(row, column);
		        Component c = tableOfRepo.prepareRenderer(cellRenderer, row, column);
		        int width = c.getPreferredSize().width + tableOfRepo.getIntercellSpacing().width;
		        preferredWidth = Math.max(preferredWidth, width);
		 
		 
		        if (preferredWidth >= maxWidth)
		        {
		            preferredWidth = maxWidth;
		            break;
		        }
		    }
		 
		    tableColumn.setPreferredWidth( preferredWidth );
		}
		
		scrollPane = new JScrollPane(tableOfRepo);
		scrollPane.setBounds(10, 50, 960, 410);
		repoFrame.add(scrollPane);
		
		repoFrame.revalidate();
		repoFrame.repaint();
	}
}
