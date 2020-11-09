package net.codingartist.algo_ds.string;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

	//uninstantiability
	private StringUtils(){
		throw new AssertionError();
	}
	
	public static boolean isPermutation(String s1, String s2){
		if(s1 == null || s2 == null){
			return false;
		}
		if(s1.length() != s2.length()){
			return false;
		}
		char [] content = s1.toCharArray();
		int[] buffer = new int[256];
		for(int i=0; i<content.length; i++){
			buffer[content[i]]++;
		}
		
		content = s2.toCharArray();
		for(int i=0; i<content.length; i++){
			if(--buffer[content[i]] < 0){
				return false;
			}
		}
		buffer = null;
		return true;
	}
	
	public static List<String> permutate(String str){
		var results = new ArrayList<String>();
		permutate("", str, results);
		return results;
	}
	
	private static void permutate(String prefix, String str, List<String> results){
		if(str.length() == 0){
			//System.out.println(prefix);
			results.add(prefix);
		}
		for(int i=0; i<str.length(); i++){
			permutate(prefix +str.charAt(i),str.substring(0,i) + str.substring(i+1), results);
		}
	}
	
	public static boolean isNullOrEmpty(String str){
		return str == null || str.length() == 0;
	}
	
	public static String reverse(String str){
		StringBuffer sb = new StringBuffer();
		for(int i=str.length()-1; i>=0; i--){
			sb.append(str.charAt(i));
		}
		return sb.toString();
	}
}
