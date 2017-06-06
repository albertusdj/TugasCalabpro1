package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class FullNameSearcherFilterRepoFollower {
	private String dataUser;
	
	public FullNameSearcherFilterRepoFollower(String fullName, int repos, int followers) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3E"+repos+"+followers:%3E"+followers+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
