package searcher;

/**
 * Kelas untuk mencari user berdasarkan nama lengkap dengan filter jumlah repository maksimum dan jummlah follower antara nilai tertentu
 * @author albert
 *
 */
public class FullNameSearcherFilterRepoMaxFollowerMinMax extends Searcher{
	/**
	 * Constructor
	 * @param fullName nama user
	 * @param reposMax jumlah repository maksimum
	 * @param followersMin jumlah follower minimum
	 * @param followersMax jumlah follower maksimum
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public FullNameSearcherFilterRepoMaxFollowerMinMax(String fullName, int reposMax, int followersMin, int followersMax){
	    url = "https://api.github.com/search/users?q="+fullName+"+in%3AfullName+repos:%3C"+reposMax+"+followers%3A"+followersMin+".."+followersMax+"&type=Users";
	}
}
