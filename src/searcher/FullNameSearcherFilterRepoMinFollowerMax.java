package searcher;

/**
 * Kelas untuk mencai user berdasarkan nama lengkap dengan filter jumlah repository minimum dan jumlah follower maksimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMin jumlah repository minimum
	 * @param followersMax jumlah repository maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinFollowerMax(String fullName, int reposMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3E"+reposMin+"+followers:%3C"+followersMax+"&type=Users";
	}
}
