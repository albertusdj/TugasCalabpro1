package searcher;

/**
 * Kelas untuk mencari user berdasarkan email dengan filter pencarian jumlah follower minimum
 * @author albert
 *
 */
public class EmailSearcherFilterFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang akan dicari
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterFollowerMin(String email, int followersMin){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+followers:%3E"+followersMin+"&type=Users";
	}
}
