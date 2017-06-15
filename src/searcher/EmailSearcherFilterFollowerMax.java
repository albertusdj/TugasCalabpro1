package searcher;

/**
 * Kelas untuk mencari user berdasarkan email dengan follower maksimum tertentu
 * @author albert
 *
 */
public class EmailSearcherFilterFollowerMax extends Searcher{
	/**
	 * Contructor
	 * @param email email dari user yang ingin dicari
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterFollowerMax(String email, int followersMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+followers:%3C"+followersMax+"&type=Users";
	}
}
