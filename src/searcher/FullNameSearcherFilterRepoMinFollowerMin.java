package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository minimum dan jumlah follower minimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMin jumlah repository minimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinFollowerMin(String fullName, int reposMin, int followersMin){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3E"+reposMin+"+followers:%3E"+followersMin+"&type=Users";
	}
}
