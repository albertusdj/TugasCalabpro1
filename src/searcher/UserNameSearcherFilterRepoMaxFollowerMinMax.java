package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah repository maksimum dan jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMaxFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMaxFollowerMinMax(String userName, int reposMax, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3C"+reposMax+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
