package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah follower minimum
 * @author albert
 *
 */

public class FullNameSearcherFilterFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterFollowerMin(String fullName, int followersMin){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+followers:%3E"+followersMin+"&type=Users";
	}
}
