package searcher;

/**
 * Kelas untuk mencari user berdasarkan email dengan filter jumlah repository maksimum dan jumlah follower dalam rentang tertentu
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMaxFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang akan dicari
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follwoer maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMaxFollowerMinMax(String email, int reposMax, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3C"+reposMax+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
