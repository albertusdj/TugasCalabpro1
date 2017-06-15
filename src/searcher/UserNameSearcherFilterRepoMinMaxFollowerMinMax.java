package searcher;

/**
 * Kelas untuk mencari user berdasarkan jumlah repository dan jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class UserNameSearcherFilterRepoMinMaxFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param userName username login
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public UserNameSearcherFilterRepoMinMaxFollowerMinMax(String userName, int reposMin, int reposMax,int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+userName+"+in%3Alogin+repos%3A"+reposMin+".."+reposMax+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
