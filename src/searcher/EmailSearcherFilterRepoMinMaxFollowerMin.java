package searcher;

/**
 * Kelas untuk mencari user berdasarkan email dengan filter jumlah repository antara nilai tertenty dan jumlah follower minimum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMinMaxFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinMaxFollowerMin(String email, int reposMin, int reposMax, int followersMin){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos%3A"+reposMin+".."+reposMax+"+followers:%3E"+followersMin+"&type=Users";
	}
}
