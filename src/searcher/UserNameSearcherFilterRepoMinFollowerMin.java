package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository minimum dan jumlah follower minimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jumlah repository minimum
	 * @param followersMin jumlah follower minimun
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinFollowerMin(String userName, int reposMin, int followersMin){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3E"+reposMin+"+followers:%3E"+followersMin+"&type=Users";
	}
}
