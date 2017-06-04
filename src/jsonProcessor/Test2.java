package jsonProcessor;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import searcher.*;

public class Test2 {
	public static void main(String arg[]) throws MalformedURLException, IOException{
		Scanner in = new Scanner(System.in);
		
		String userName = in.nextLine();
	
		UserNameSearcher res = new UserNameSearcher(userName);
		
		StringConverterToJson json = new StringConverterToJson(res.getString());
		
		System.out.println(json.getListOfUser());
	}
}
