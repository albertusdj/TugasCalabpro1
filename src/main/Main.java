package main;

import javax.swing.SwingUtilities;

import view.viewController;
/**
 * Kelas utama untuk menjalankan aplikasi
 * @author albert
 *
 */
public class Main {
	public static void main(String arg[]){
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                viewController view = new viewController();
            }
        });
	}
}
