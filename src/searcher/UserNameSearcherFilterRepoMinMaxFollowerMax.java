package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository antara nilai tertentu dan jumlah follower maksimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinMaxFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinMaxFollowerMax(String userName, int reposMin, int reposMax, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos%3A"+reposMin+".."+reposMax+"+followers:%3C"+followersMax+"&type=Users";
	}
}
