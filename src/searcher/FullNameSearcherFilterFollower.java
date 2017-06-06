package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class FullNameSearcherFilterFollower {
	private String dataUser;
	
	public FullNameSearcherFilterFollower(String fullName, int followers) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+followers:%3E"+followers+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
