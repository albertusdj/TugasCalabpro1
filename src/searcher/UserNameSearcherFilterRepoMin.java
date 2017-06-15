package searcher;

/**
 * Kelas untuk mecari user berdasarkan username login dengan filter jumlah repository minimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMin extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jummlah repository minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMin(String userName, int reposMin){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3E"+reposMin+"&type=Users";
	}
}
