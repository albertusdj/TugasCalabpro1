package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter jumlah repository maksimum dan jumlah follower maksimum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMaxFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param email email user yang ingin dicari
	 * @param reposMax jumlah repository maksimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMaxFollowerMax(String email, int reposMax, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3C"+reposMax+"+followers:%3C"+followersMax+"&type=Users";
	}
}
