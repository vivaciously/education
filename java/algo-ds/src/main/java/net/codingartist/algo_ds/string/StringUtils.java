package net.codingartist.algo_ds.string;

public class StringUtils {

	//uninstantiability
	private StringUtils(){
		throw new AssertionError();
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
	
	public static String leftJustify(String str, int maxLen, char c) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<maxLen - str.length(); i++) {
			sb.append(c);
		}
		sb.append(str);
		return sb.toString();
	}
	
	public static String rightJustify(String str, int maxLen, char c) {
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		for(int i=0; i<maxLen - str.length(); i++) {
			sb.append(c);
		}
		return sb.toString();
	}
	
	public static String leftPad(String str, int n, char c) {
		if(str == null) {
			throw new NullPointerException("Given str is null");
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(c);
		}
		sb.append(str);
		return sb.toString();
	}
	
	public static String rightPad(String str, int n, char c) {
		if(str == null) {
			throw new NullPointerException("Given str is null");
		}
		StringBuilder sb = new StringBuilder();
		sb.append(str);
		for(int i=0; i<n; i++) {
			sb.append(c);
		}
		return sb.toString();
	}
}
