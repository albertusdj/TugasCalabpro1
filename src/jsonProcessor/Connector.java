package jsonProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Kelas untuk menghubungkan ke url dan mengambil data json
 * @author albert
 *
 */
public class Connector {
	/**
	 * data json dalam bentuk string
	 */
	private String dataUser;
	
	/**
	 * Constructor
	 * @param url String url yang ingin diakses
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Connector(String url) throws MalformedURLException, IOException{
		URL web = new URL(url);
        
	    URLConnection connection = web.openConnection();
	    connection.addRequestProperty("User-Agent", "Mozilla/4.76");
	    BufferedReader in;
	    in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	    String inputLine;
	        
	    dataUser = "";
	    
	    while((inputLine = in.readLine())!=null){
	        byte data[] = inputLine.getBytes();
	        dataUser += new String(data);
	    }
	        
	    in.close();
	}
	
	/**
	 * Fungsi yang mengembalikan String hasil pencarian
	 * @return dataUser
	 */
	public String getString(){
		return dataUser;
	}
	
}
