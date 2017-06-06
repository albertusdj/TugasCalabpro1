package jsonProcessor;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import searcher.Connector;

public class StringConverterToJson {
	JSONObject obj;
	JSONArray arrayOfUser;
	ArrayList<String> listOfUserName;
	
	public StringConverterToJson(String input){
		obj = new JSONObject(input);
		arrayOfUser = obj.getJSONArray("items");
		
		listOfUserName = new ArrayList<String>();
		for(int i=0; i<arrayOfUser.length(); i++){
			JSONObject temp = arrayOfUser.getJSONObject(i);
			String user = temp.getString("login");
			listOfUserName.add(user);
		}
	}
	
	public ArrayList<String> getListOfUser(){
		return listOfUserName;
	}
	
	public ArrayList<Repository> getUserRepo(String userName) throws MalformedURLException, IOException{
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
		Connector connector = new Connector(reposUrl);
		
		String repos = connector.getString();
		JSONArray reposArrayJson = new JSONArray(repos);
		ArrayList<Repository> reposArray = new ArrayList<Repository>();
		for(int index=0; index<reposArrayJson.length(); index++){
			JSONObject tempJsonObject = reposArrayJson.getJSONObject(index);
			Repository tempRepository = new Repository();
			System.out.println("tes");
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
		
		return reposArray;
	}
}
