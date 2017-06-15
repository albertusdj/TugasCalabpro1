package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap
 * @author albert
 *
 */
public class FullNameSearcher extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama dari user yang ingin dicari
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcher(String fullName){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName&type=Users";
	}
}
