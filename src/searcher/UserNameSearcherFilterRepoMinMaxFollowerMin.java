package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository antara nilai tertentu dan jumlah follower minimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinMaxFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param userName username lofin
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksmimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinMaxFollowerMin(String userName, int reposMin, int reposMax, int followersMin){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos%3A"+reposMin+".."+reposMax+"+followers:%3E"+followersMin+"&type=Users";
	}
}
