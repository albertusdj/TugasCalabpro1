package searcher;

/**
 * Kelas untuk melakukan pencarian user berdasarkan email dengan filter pencarian jumlah repository maksimum
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMax extends Searcher{
	/**
	 * Constructor
	 * @param email email dari user yang ingin dicari
	 * @param reposMax jumlah repository maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMax(String email, int reposMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos:%3C"+reposMax+"&type=Users";
	}
}
