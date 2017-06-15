package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository minimum dan jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jumlah repository minimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinFollowerMinMax(String userName, int reposMin, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3E"+reposMin+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
