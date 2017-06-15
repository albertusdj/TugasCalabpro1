package searcher;

/**
 * Kelas untuk mencari user berdasarkan user login dengan filter jumlah repository antara nilai tertentu
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @throws MalformedURLException 
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinMax(String userName, int reposMin, int reposMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos%3A"+reposMin+".."+reposMax+"&type=Users";
	}
}
