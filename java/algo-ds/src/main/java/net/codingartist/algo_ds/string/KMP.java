package net.codingartist.algo_ds.string;

public class KMP {

	//Knuth–Morris–Pratt algorithm
	private KMP() {
		throw new AssertionError("No instantiability");
	}
	
	public static int[] lps(String p) {//longest proper prefix which is also suffix
		int[] lps = new int[p.length()];//stores index to go back upon mismatch
		int matchingLen = 0;
		for(int i=1; i<p.length(); i++) {
			if(p.charAt(i) == p.charAt(matchingLen)) {
				lps[i] = matchingLen + 1;
				matchingLen++;
			} else {
				if(matchingLen == 0) {
				  lps[i] = 0;
				} else {
					matchingLen = lps[matchingLen -1];
					i--;
				}
			}
		}
		return lps;
	}
	
	public static boolean kmp(String s, String p) {
		int[] lps = lps(p);
		int i =0;
		int j = 0;
		while(i < s.length() && j < p.length()) {
			if(s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				if(j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}
		if(j == p.length()) {
			return true;
		}
		return false;
	}
	
	public static int kmpIndex(String s, String p) {
		int[] lps = lps(p);
		int i =0; 
		int j = 0;
		while(i < s.length() && j < p.length()) {
			if(s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				if(j != 0) {
					j = lps[j-1];
				} else {
					i++;
				}
			}
		}
		if(j == p.length()) {
			return i - p.length();//matched therefore, starting index should be i - p.length()
		}
		return -1;
	}
}
