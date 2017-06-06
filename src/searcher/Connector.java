package searcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Connector {
	private String dataUser;
	
	public Connector(String url) throws MalformedURLException, IOException{
		URL web = new URL(url);
        
	    URLConnection connection = web.openConnection();
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
	
	public String getString(){
		return dataUser;
	}
	
}
