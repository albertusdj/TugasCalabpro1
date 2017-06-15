package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository maksimum dan jumlah follower maksimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMaxFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMax jumlah repository maksimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMaxFollowerMax(String fullName, int reposMax, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3C"+reposMax+"+followers:%3C"+followersMax+"&type=Users";
	}
}
