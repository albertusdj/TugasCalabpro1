package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository minimum dan jumlah follower maksimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jumlah repository minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinFollowerMax(String userName, int reposMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repo:%3E"+reposMin+"+followers:%3C"+followersMax+"&type=Users";
	}
}
