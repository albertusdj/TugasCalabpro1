package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter jumlah repository antara nilai tertentu dan jumlah follower maksimum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMinMaxFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinMaxFollowerMax(String email, int reposMin, int reposMax, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos%3A"+reposMin+".."+reposMax+"+followers:%3C"+followersMax+"&type=Users";
	}
}
