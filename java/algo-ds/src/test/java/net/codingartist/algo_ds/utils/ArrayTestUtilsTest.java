package net.codingartist.algo_ds.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ArrayTestUtilsTest {

	@Test
	public void testStrToIntArray() {
		String input ="[0, 1, 2]";
		int[] result = ArrayTestUtils.strToIntArray(input);
		for(int i=0; i<result.length; i++) {
			assertEquals(result[i], i);
		}
		input = " []";
		result = ArrayTestUtils.strToIntArray(input);
		assertTrue(result.length == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("(1,2,3)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("[1,2,3)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("(1,2,3]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntArray("[a,b,c]");
		});
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToIntArray(null);
		});
	}
	
	@Test
	public void testStrToIntegerArray() {
		String input ="[0, 1, 2]";
		Integer[] result = ArrayTestUtils.strToIntegerArray(input);
		for(int i=0; i<result.length; i++) {
			assertEquals(result[i], i);
		}
		input = " []";
		result = ArrayTestUtils.strToIntegerArray(input);
		assertTrue(result.length == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("(1,2,3)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("[1,2,3)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("(1,2,3]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("[a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerArray("['']");
		});
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToIntegerArray(null);
		});
	}
	
	@Test
	public void testIntToIntegerArray() {
		int[] original = new int[]{1,2,3,4,5};
		Integer[] results = ArrayTestUtils.intToIntegerArray(original);
		for(int i=0; i<original.length; i++) {
			assertEquals(original[i], results[i]);
		}
	}
	
	@Test
	public void testIntegerToIntArray() {
		Integer[] original = new Integer[] {1,2,3};
		int[] results = ArrayTestUtils.integerToIntArray(original);
		for(int i=0; i<original.length; i++) {
			assertEquals(original[i], results[i]);
		}
	}
	
	@Test
	public void testStrToCharArray() {
		String input ="[A, B, C, ' ', D]";
		char[] result = ArrayTestUtils.strToCharArray(input);
		char[] test = {'A','B','C', ' ', 'D'};//' ' is a space
		for(int i=0; i<result.length; i++) {
			assertEquals(result[i], test[i]);
		}
		input = " []";
		result = ArrayTestUtils.strToCharArray(input);
		assertTrue(result.length == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("(a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("[a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("(a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharArray("[1,2,4]");
		});
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToCharArray(null);
		});
	}
	
	@Test
	public void testStrToCharacterArray() {
		String input ="[A, B, C, ' ', D]";
		Character[] result = ArrayTestUtils.strToCharacterArray(input);
		char[] test = {'A','B','C', ' ', 'D'};//' ' is a space
		for(int i=0; i<result.length; i++) {
			assertEquals(result[i], test[i]);
		}
		input = " []";
		result = ArrayTestUtils.strToCharacterArray(input);
		assertTrue(result.length == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("(a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("[a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("(a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("[1,2,4]");
		});
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToCharacterArray(null);
		});
	}
	
	@Test
	public void testStrToStringArray() {
		String input = "[AB, a, b, c, A, ' ', D]";
		String[] results = ArrayTestUtils.strToStringArray(input);
		String[] expected = new String[] {"AB", "a", "b", "c", "A", "", "D"};
		for(int i=0; i<results.length; i++) {
			assertEquals(results[i], expected[i]);
		}
		results = ArrayTestUtils.strToStringArray("[] ");
		assertTrue(results.length == 0);
		expected = new String[] {"1", "2", "@", "+", "ABCDEFG", "CD 67" , " Abc f"};
		results = ArrayTestUtils.strToStringArray("[1,2,@,+, ABCDEFG, CD' '67, ' 'Abc' 'f]");
		for(int i=0; i<results.length; i++) {
			assertEquals(results[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToStringArray(null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterArray("(a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringArray("[a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringArray("(a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringArray("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringArray("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringArray("");
		});
		
	}
	
}
