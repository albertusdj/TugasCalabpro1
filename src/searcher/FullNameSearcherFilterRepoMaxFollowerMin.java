package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository maksimum dan jumlah follower minimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMaxFollowerMin extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMaxFollowerMin(String fullName, int reposMax, int followersMin){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3C"+reposMax+"+followers:%3E"+followersMin+"&type=Users";
	}
}
