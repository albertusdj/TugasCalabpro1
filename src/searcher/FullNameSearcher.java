package searcher;

import java.io.IOException;
import java.net.MalformedURLException;


public class FullNameSearcher {
	private String dataUser;
	
	public FullNameSearcher(String fullName) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
