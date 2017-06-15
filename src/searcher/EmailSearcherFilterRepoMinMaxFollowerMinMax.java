package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter jumlah repository dan follower antara nilai tertentu
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMinMaxFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum 
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinMaxFollowerMinMax(String email, int reposMin, int reposMax, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos%3A"+reposMin+".."+reposMax+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
