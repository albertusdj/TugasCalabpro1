package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository antara nilai tertentu dan jumlah follower minimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinMaxFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user 
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinMaxFollowerMin(String fullName, int reposMin, int reposMax, int followersMin){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos%3A"+reposMin+".."+reposMax+"+followers:%3E"+followersMin+"&type=Users";
	}
}
