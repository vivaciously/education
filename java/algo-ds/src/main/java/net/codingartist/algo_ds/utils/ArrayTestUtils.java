package net.codingartist.algo_ds.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTestUtils {

	private ArrayTestUtils() {
		throw new AssertionError("no instantiability");
	}
	
	
	public static int[] strToIntArray(String str) {
		if(str == null) {
			throw new NullPointerException("Given str is null.");
		}
		str = str.replaceAll("\\s+", "");
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
			if(!(Character.isDigit(c) ||  c == ',' || c == '-')) {
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
	
	public static Integer[] strToIntegerArray(String str) {
		return Arrays.stream(strToIntArray(str)).boxed().toArray(Integer[]::new);
	}
	
	public static Integer[] intToIntegerArray(int[] array) {
		return Arrays.stream(array).boxed().toArray(Integer[]::new);
	}
	
	public static int[] integerToIntArray(Integer[] array) {
		return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
	}
	
	public static List<Integer> strToIntegerList(String str) {
		return Arrays.stream(strToIntegerArray(str)).collect(Collectors.toList());
	}
	
	public static List<Integer> toIntegerList(int[] array) {
		return Arrays.stream(intToIntegerArray(array)).collect(Collectors.toList());
	}
	
	public static List<Integer> toIntegerList(Integer[] array) {
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	
	public static char[] strToCharArray(String str) {
		if(str == null) {
			throw new NullPointerException("Given str is null.");
		}
		str = str.replaceAll("\\s+", "");
		if(str.length() < 2) {
			throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
					+ "and 'a' 'b' 'c' are char values and separated by a comma.");
		}
		if(!(str.startsWith("[") && str.endsWith("]"))) {
			throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
					+ "and 'a' 'b' 'c' are char values and separated by a comma.");
		}
		str = str.substring(1, str.length()-1);
		if(str.length() == 0) {
			return new char[] {};
		}
		for(char c : str.toCharArray()) {
			if(!(Character.isLetter(c) ||  c == ',' || c == '\'')) {
				throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
						+ "and 'a' 'b' 'c' are char values and separated by a comma.");
			}
		}
		String[] data = str.split(",");
		char[] results = new char[data.length];
		int index = 0;
		for(String s : data) {
			char c = s.charAt(0);
			if(c =='\'') {
				results[index++] = ' ';
			} else {
				results[index++] = c;
			}
			
		}
		return results;
	}
	
	public static Character[] strToCharacterArray(String str) {
		char[] chars = strToCharArray(str);
		Character[] results = new Character[chars.length];
		int index = 0;
		for(char c : chars) {
			results[index++] = Character.valueOf(c);
		}
		chars = null;
		return results;
	}
	
	public static List<Character> strToCharacterList(String str) {
		return Arrays.stream(strToCharacterArray(str)).collect(Collectors.toList());
	}
	
	public static List<Character> toCharacterList(Character[] array) {
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
	public static String[] strToStringArray(String str) {
		if(str == null) {
			throw new NullPointerException("Given str is null.");
		}
		str = str.replaceAll("\\s+", "");
		if(str.length() < 2) {
			throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
					+ "and 'a' 'b' 'c' are String values and separated by a comma.");
		}
		if(!(str.startsWith("[") && str.endsWith("]"))) {
			throw new IllegalArgumentException("The format of str is '[a,b,c]' where it starts with '[' and ends with ']'"
					+ "and 'a' 'b' 'c' are String values and separated by a comma.");
		}
		str = str.substring(1, str.length()-1);
		if(str.length() == 0) {
			return new String[] {};
		}
		str = str.replace("''", "'");
		String[] data = str.split(",");
		String[] results = new String [data.length];
		int index = 0;
		for(String s : data) {
			char c = s.charAt(0);
			if(s.length() == 1 && c =='\'') {
				results[index++] = "";
			} else if(s.contains("'")){
				results[index++] = s.replace('\'', ' ');
			} else {
				results[index++] = s;
			}
			
		}
		return results;
	}
	
	public static List<String> strToStringList(String str) {
		return Arrays.stream(strToStringArray(str)).collect(Collectors.toList());
	}
	
	public static List<String> toStringList(String[] array) {
		return Arrays.stream(array).collect(Collectors.toList());
	}
	
}
