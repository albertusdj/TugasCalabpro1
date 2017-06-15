package searcher;

/**
 * Kelas yang melakukan pencarian user berdasarkan email dengan filter jumlah repository minimum dan jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMinFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param email email user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinFollowerMinMax(String email, int reposMin, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3E"+reposMin+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
