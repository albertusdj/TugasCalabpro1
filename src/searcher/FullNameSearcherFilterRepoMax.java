package searcher;

/**
 * Kelas untuk mencari user berdasarkan jumlah repository maksimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama lengkap
	 * @param reposMax jumlah repository maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMax(String fullName, int reposMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3C"+reposMax+"&type=Users";
	}
}
