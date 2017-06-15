package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan nama lengkap dengan filter jumlah follower maksimum
 * @author albert
 *
 */
public class FullNameSearcherFilterFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterFollowerMax(String fullName, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+followers:%3C"+followersMax+"&type=Users";
	}
}
