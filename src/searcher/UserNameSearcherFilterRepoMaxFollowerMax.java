package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository maksimum dan jumlah follower maksimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMaxFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMax jumlah repository maksimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMaxFollowerMax(String userName, int reposMax, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repo:%3C"+reposMax+"+followers:%3C"+followersMax+"&type=Users";
	}
}
