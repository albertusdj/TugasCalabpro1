package jsonProcessor;


import org.json.JSONArray;
import org.json.JSONObject;
import java.util.*;

public class StringConverterToJson {
	JSONObject obj;
	JSONArray arrayOfUser;
	
	public StringConverterToJson(String input){
		obj = new JSONObject(input);
		arrayOfUser = obj.getJSONArray("items");
	}
	
	public ArrayList<String> getListOfUser(){
		ArrayList<String> res = new ArrayList<String>();
		for(int i=0; i<arrayOfUser.length(); i++){
			JSONObject temp = arrayOfUser.getJSONObject(i);
			String user = temp.getString("login");
			res.add(user);
		}
		
		return res;
	}
}
