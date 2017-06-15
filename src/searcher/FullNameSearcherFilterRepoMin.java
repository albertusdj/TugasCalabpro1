package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository minimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMin extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama lengkap
	 * @param reposMin jumlah repository minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMin(String fullName, int reposMin){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3E"+reposMin+"&type=Users";
	}
}
