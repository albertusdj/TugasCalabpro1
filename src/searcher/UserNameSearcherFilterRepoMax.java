package searcher;

/**
 * Kelas untuk mencari user berdasarkan username dengan filter jumlah repository maksimum
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMax jumlah repository maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMax(String userName, int reposMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos:%3C"+reposMax+"&type=Users";
	}
}
