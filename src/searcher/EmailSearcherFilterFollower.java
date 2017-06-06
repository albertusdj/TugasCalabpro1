package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class EmailSearcherFilterFollower {
private String dataUser;
	
	public EmailSearcherFilterFollower(String email, int followers) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+followers:%3E"+followers+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
