package searcher;

/**
 * Kelas untuk mencari user berdasarkan username login dengan filter jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class UserNameSearcherFilterFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterFollowerMinMax(String userName, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
