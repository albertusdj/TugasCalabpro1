package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository minimum dan jumlah follower antara nilai tertentu
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMinFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMin jumlah repository minimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMinFollowerMinMax(String fullName, int reposMin, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3E"+reposMin+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
