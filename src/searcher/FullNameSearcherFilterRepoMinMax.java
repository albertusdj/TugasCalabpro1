package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository antara nilai tertentu
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinMax(String fullName, int reposMin, int reposMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos%3A"+reposMin+".."+reposMax+"&type=Users";
	}
}
