package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository maksimum dan jumlah follower minimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMaxFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMaxFollowerMin(String userName, int reposMax, int followersMin){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3C"+reposMax+"+followers:%3E"+followersMin+"&type=Users";
	}
}
