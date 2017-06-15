package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter jumlah follower dalam rentang tertentu
 * @author albert
 *
 */
public class EmailSearcherFilterFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jummlah follower maksimum
	 * @throws MalformedURLException 
	 * @throws IOException
	 */
	public EmailSearcherFilterFollowerMinMax(String email, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
