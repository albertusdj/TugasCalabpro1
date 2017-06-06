package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class UserNameSearcherFilterRepoFollower {
	private String dataUser;
	
	public UserNameSearcherFilterRepoFollower(String userName, int repo, int followers) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repo:%3E"+repo+"+followers:%3E"+followers+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
