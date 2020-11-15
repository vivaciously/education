package net.codingartist.algo_ds.utils;

public class ArrayTestUtils {

	private ArrayTestUtils() {
		throw new AssertionError("no instantiability");
	}
	
	public static int[] strToIntArray(String str) {
		if(str == null) {
			throw new NullPointerException("Given str is null.");
		}
		str = str.replaceAll("\s+", "");
		if(str.length() < 2) {
			throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
					+ "and 'a' 'b' 'c' are int values and separated by a comma.");
		}
		if(!(str.startsWith("[") && str.endsWith("]"))) {
			throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
					+ "and 'a' 'b' 'c' are int values and separated by a comma.");
		}
		str = str.substring(1, str.length()-1);
		if(str.length() == 0) {
			return new int[] {};
		}
		for(char c : str.toCharArray()) {
			if(!(Character.isDigit(c) ||  c == ',')) {
				throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
						+ "and 'a' 'b' 'c' are int values and separated by a comma.");
			}
		}
		String[] data = str.split(",");
		int[] results = new int[data.length];
		int index = 0;
		for(String s : data) {
			results[index++] = Integer.valueOf(s);
		}
		return results;
	}
	
}
