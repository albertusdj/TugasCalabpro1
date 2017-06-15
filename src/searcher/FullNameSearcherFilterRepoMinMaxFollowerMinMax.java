package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository dan jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinMaxFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName user
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinMaxFollowerMinMax(String fullName, int reposMin, int reposMax, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos%3A"+reposMin+".."+reposMax+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
