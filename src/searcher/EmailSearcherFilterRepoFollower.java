package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class EmailSearcherFilterRepoFollower {
	private String dataUser;
	
	public EmailSearcherFilterRepoFollower(String email, int repos, int followers) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3E"+repos+"+followers:%3E"+followers+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
