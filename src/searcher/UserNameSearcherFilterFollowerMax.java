package searcher;

/**
 * Kelas untuk mencari user berdasarkan user name login dengan filter jumlah follower maksimum
 * @author albert
 *
 */
public class UserNameSearcherFilterFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterFollowerMax(String userName, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+followers:%3C"+followersMax+"&type=Users";
	}
}
