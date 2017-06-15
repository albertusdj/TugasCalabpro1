package searcher;
/**
 * Kelas abstrak untuk mencari user
 * @author albert
 *
 */
public abstract class Searcher {
	/**
	 * String url untuk query
	 */
	protected String url;
	
	/**
	 * Fungsi untuk mengembalikan String alamat url 
	 * @return url
	 */
	public String getUrl(){
		return url;
	}

}
