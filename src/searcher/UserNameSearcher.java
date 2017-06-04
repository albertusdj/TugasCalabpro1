package searcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UserNameSearcher{
	private String dataUser;
	
	public UserNameSearcher(String userName) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+userName+"in%3Alogin&type=Users";
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

