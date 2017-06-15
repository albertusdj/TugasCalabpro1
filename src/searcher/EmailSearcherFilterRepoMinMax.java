package searcher;

/**
 * Kelas yang melakukan pencarian user berdasarkan email dengan filter jumlah repository antara nilai tertentu
 * @author albert
 *
 */
public class EmailSearcherFilterRepoMinMax extends Searcher{
	/**
	 * Constructor
	 * @param email email user yang ingin dicari
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public EmailSearcherFilterRepoMinMax(String email, int reposMin, int reposMax){
	    url = "https://api.github.com/search/users?q="+email+"+in%3Aemail+repos%3A"+reposMin+".."+reposMax+"&type=Users";
	}
}
