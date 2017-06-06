package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class UserNameSearcher{
	private String dataUser;
	
	public UserNameSearcher(String userName) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}

