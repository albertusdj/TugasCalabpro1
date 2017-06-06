package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class EmailSearcherFilterRepo {
	private String dataUser;
	
	public EmailSearcherFilterRepo(String email, int repos) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3E"+repos+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
