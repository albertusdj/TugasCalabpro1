package searcher;

/**
 * Kelas yang melakukan pencarian user beredasarkan email dengan filter jumlah repository minimum dan jumlah follower maksimmum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMinFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang akan dicari
	 * @param reposMin jumlah repository minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinFollowerMax(String email, int reposMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3E"+reposMin+"+followers:%3C"+followersMax+"&type=Users";
	}
}
