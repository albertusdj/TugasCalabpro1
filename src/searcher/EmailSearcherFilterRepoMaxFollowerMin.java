package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter jumlah repository maksimum dan jumlah follower minimum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMaxFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMaxFollowerMin(String email, int reposMax, int followersMin){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3C"+reposMax+"+followers:%3E"+followersMin+"&type=Users";
	}
}
