package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class UserNameSearcherFilterRepo {
	private String dataUser;
	
	public UserNameSearcherFilterRepo(String userName, int repos) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3E"+repos+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
