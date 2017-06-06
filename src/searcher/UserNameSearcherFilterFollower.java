package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class UserNameSearcherFilterFollower {
	private String dataUser;
	
	public UserNameSearcherFilterFollower(String userName, int followers) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+followers:%3E"+followers+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
