package jsonProcessor;
/**
 * Kelas yang mewakili repository user
 * @author albert
 *
 */
public class Repository {
	/**
	 * Nama repository
	 */
	String nama;
	/**
	 * Deskripsi repository
	 */
	String deskripsi;
	/**
	 * url repository
	 */
	String url;
	/**
	 * Constructor tanpa parameter
	 */
	public Repository(){
		nama = null;
		deskripsi = null;
		url = null;
	}
	/**
	 * Contructor dengan parameter
	 * @param _nama nama repository
	 * @param _deskripsi deskripsi repository
	 * @param _url url repository
	 */
	public Repository(String _nama, String _deskripsi, String _url){
		nama = _nama;
		deskripsi = _deskripsi;
		url = _url;
	}
	/**
	 * Fungsi yang mengembalikan nama repository
	 * @return nama
	 */
	public String getNama(){
		return nama;
	}
	/**
	 * Fungsi yang mengembalikan deskripsi repository
	 * @return deskripsi
	 */
	public String getDeskripsi(){
		return deskripsi;
	}
	/**
	 * Fungsi yang mengembalikan url repository
	 * @return url
	 */
	public String getUrl(){
		return url;
	}
}
