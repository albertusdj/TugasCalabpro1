package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login
 * @author albert
 *
 */
public class UserNameSearcher extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcher(String userName){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin&type=Users";
	}
}

