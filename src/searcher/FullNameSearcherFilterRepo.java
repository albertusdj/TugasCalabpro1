package searcher;

import java.io.IOException;
import java.net.MalformedURLException;

public class FullNameSearcherFilterRepo {
	private String dataUser;
	
	public FullNameSearcherFilterRepo(String fullName, int repos) throws MalformedURLException, IOException{
	    String url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3E"+repos+"&type=Users";
	    
	    Connector connector = new Connector(url);
	    dataUser = connector.getString();
	}
	
	public String getString(){
		return dataUser;
	}
}
