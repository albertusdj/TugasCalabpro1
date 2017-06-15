package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah follower minimum
 * @author albert
 *
 */
public class UserNameSearcherFilterFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterFollowerMin(String userName, int followersMin){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+followers:%3E"+followersMin+"&type=Users";
	}
}
