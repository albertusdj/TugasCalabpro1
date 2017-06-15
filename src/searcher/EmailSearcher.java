package searcher;

/**
 * Kelas untuk mencari user berdasarkan email
 * @author albert
 *
 */
public class EmailSearcher extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @throws MalformedURLException 
	 * @throws IOException
	 */
	public EmailSearcher(String email){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail&type=Users";
	}
}
