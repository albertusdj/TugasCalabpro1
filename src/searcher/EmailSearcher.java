package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class EmailSearcher {
	private String dataUser;
	
	public EmailSearcher(String email) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+email+"+in%3Aemail&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}

