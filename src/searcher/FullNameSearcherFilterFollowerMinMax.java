package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class FullNameSearcherFilterFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterFollowerMinMax(String fullName, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
