package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository antara nilai tertentu dan jumlah follower maksimum
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinMaxFollowerMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMin jumlah repository minimum
	 * @param reposMax jumlah repository maksimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinMaxFollowerMax(String fullName, int reposMin, int reposMax, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos%3A"+reposMin+".."+reposMax+"+followers:%3C"+followersMax+"&type=Users";
	}
}
