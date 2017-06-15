package searcher;
/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter jumlah repository minimum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMin extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMin(String email, int reposMin){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3E"+reposMin+"&type=Users";
	}
}
