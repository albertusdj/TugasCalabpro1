package searcher;
/**
 * Kelas untuk mencari user berdasarkan email dengan filter pencarian jumlah repository minimum dan jumlah follower minimum
 */


public class EmailSearcherFilterRepoMinFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param email email user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinFollowerMin(String email, int reposMin, int followersMin){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3E"+reposMin+"+followers:%3E"+followersMin+"&type=Users";
	}
}
