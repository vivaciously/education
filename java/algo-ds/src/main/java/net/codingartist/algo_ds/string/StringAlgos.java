package net.codingartist.algo_ds.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringAlgos {

	//uninstantiability
	private StringAlgos(){
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
		if(str == null || str.length() == 0) {
			return Collections.emptyList();
		}
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
}
