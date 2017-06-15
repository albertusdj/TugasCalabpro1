package jsonProcessor;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
/**
 * Kelas yang mengkonversi json string untuk diekstrak datanya
 * @author albert
 *
 */
public class StringConverterToJson {
	/**
	 * objek json yang menyimpan data dari string input
	 */
	JSONObject obj;
	/**
	 * objek array json yang menyimpan daftar user beserta datanya
	 */
	JSONArray arrayOfUser;
	/**
	 * array yang menyimpan daftar user name dalam bentuk string
	 */
	ArrayList<String> listOfUserName;
	
	/**
	 * halaman url daftar user yang diakses saat ini
	 */
	int currentPageUser;
	/**
	 * halaman url repository yang diakses saat ini
	 */
	int currentPageRepo;
	/**
	 * halaman maksimum
	 */
	int maxPage;
	
	/**
	 * Constructor
	 * @param inputUrl String yang merupakan data json dari url
	 * @param _currentPageUser halaman url saat ini
	 * @throws IOException 
	 * @throws MalformedURLException 
	 */
	public StringConverterToJson(String inputUrl, int _currentPageUser) throws MalformedURLException, IOException{
		currentPageUser = _currentPageUser;
		String inputUrlCurrentPage = inputUrl + "&page=" + currentPageUser;
		Connector connector = new Connector(inputUrlCurrentPage);
		String data = connector.getString();
			
		obj = new JSONObject(data);
		arrayOfUser = obj.getJSONArray("items");
		
		int numberOfUser = obj.getInt("total_count");
		
		if(numberOfUser > 1000){
			maxPage = 1000%30 + 1;
		}
		else if(numberOfUser%30 == 0){
			maxPage = numberOfUser/30;
		}
		else{
			maxPage = numberOfUser/30 + 1;
		}
		
		listOfUserName = new ArrayList<String>();
		for(int i=0; i<arrayOfUser.length(); i++){
			JSONObject temp = arrayOfUser.getJSONObject(i);
			String user = temp.getString("login");
			listOfUserName.add(user);
		}
	}

	/**
	 * Fungsi yang mengembalikan array yang berisi user name
	 * @return listOfUserName
	 */
	public ArrayList<String> getListOfUser(){
		return listOfUserName;
	}
	/**
	 * Fungsi yang mengembalikan repository user
	 * @param userName nama user yang ingin dicari repository nya
	 * @return reposArray yaitu array berisi repository user
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public ArrayList<Repository> getUserRepo(String userName, int _currentPageRepo) throws MalformedURLException, IOException{
		boolean found = false;
		
		int i = 0;
		while(!found && i<listOfUserName.size()){
			if(userName.equals(listOfUserName.get(i))){
				found = true;
			}
			else{
				i++;
			}
		}
		
		JSONObject wantedUser = arrayOfUser.getJSONObject(i);
		String reposUrl = wantedUser.getString("repos_url");
		
		currentPageRepo = _currentPageRepo;
		String reposUrlCurrentPage = reposUrl + "?page=" + currentPageRepo;
		Connector connector = new Connector(reposUrlCurrentPage);
			
		String repos = connector.getString();
		
		ArrayList<Repository> reposArray = new ArrayList<Repository>();
		if(!repos.equals("[]")){
			JSONArray reposArrayJson = new JSONArray(repos);
				
			for(int index=0; index<reposArrayJson.length(); index++){
				JSONObject tempJsonObject = reposArrayJson.getJSONObject(index);
				Repository tempRepository = new Repository();
				tempRepository.nama = tempJsonObject.getString("name");
				if(tempJsonObject.isNull("description")){
					tempRepository.deskripsi = "";
				}
				else{
					tempRepository.deskripsi = tempJsonObject.getString("description");
				}
							
				tempRepository.url = tempJsonObject.getString("url");
							
				reposArray.add(tempRepository);
			}
		}	
				
		return reposArray;
	}
	
	/**
	 * Fungsi untuk mengembalikan halaman maksimum
	 * @return maxPage
	 */
	public int getMaxPage(){
		return maxPage; 
	}
}
