package net.codingartist.algo_ds.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

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
		
		input = "[-1,-1,-1]";
		result = ArrayTestUtils.strToIntArray(input);
		for(int i=0; i<result.length; i++) {
			assertTrue(result[i] == -1);
		}
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
	public void testStrToIntegerList() {
		String input ="[0, 1, 2]";
		List<Integer> result = ArrayTestUtils.strToIntegerList(input);
		for(int i=0; i<result.size(); i++) {
			assertEquals(result.get(i), i);
		}
		input = " []";
		result = ArrayTestUtils.strToIntegerList(input);
		assertTrue(result.size() == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("(1,2,3)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("[1,2,3)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("(1,2,3]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("[a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToIntegerList("['']");
		});
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToIntegerList(null);
		});
	}
	
	@Test
	public void testToIntegerListFromIntArray() {
		int[] original = new int[]{1,2,3,4,5};
		List<Integer> results = ArrayTestUtils.toIntegerList(original);
		for(int i=0; i<original.length; i++) {
			assertEquals(original[i], results.get(i));
		}
	}
	
	@Test
	public void testToIntegerListFromIntegerArray() {
		Integer[] original = new Integer[] {1,2,3};
		List<Integer> results = ArrayTestUtils.toIntegerList(original);
		for(int i=0; i<original.length; i++) {
			assertEquals(original[i], results.get(i));
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
	public void testStrToCharacterList() {
		String input ="[A, B, C, ' ', D]";
		List<Character> results = ArrayTestUtils.strToCharacterList(input);
		char[] test = {'A','B','C', ' ', 'D'};//' ' is a space
		for(int i=0; i<results.size(); i++) {
			assertEquals(results.get(i), test[i]);
		}
		input = " []";
		results = ArrayTestUtils.strToCharacterList(input);
		assertTrue(results.size() == 0);
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("(a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("[a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("(a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToCharacterList("[1,2,4]");
		});
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToCharacterList(null);
		});
	}
	
	@Test
	public void testToCharacterList() {
		String input ="[A, B, C, ' ', D]";
		List<Character> results = ArrayTestUtils.toCharacterList(ArrayTestUtils.strToCharacterArray(input));
		char[] test = {'A','B','C', ' ', 'D'};//' ' is a space
		for(int i=0; i<results.size(); i++) {
			assertEquals(results.get(i), test[i]);
		}
		input = " []";
		results = ArrayTestUtils.toCharacterList(ArrayTestUtils.strToCharacterArray(input));
		assertTrue(results.size() == 0);
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
	
	@Test
	public void testStrToStringList() {
		String input = "[AB, a, b, c, A, ' ', D]";
		List<String> results = ArrayTestUtils.strToStringList(input);
		String[] expected = new String[] {"AB", "a", "b", "c", "A", "", "D"};
		for(int i=0; i<results.size(); i++) {
			assertEquals(results.get(i), expected[i]);
		}
		results = ArrayTestUtils.strToStringList("[] ");
		assertTrue(results.size() == 0);
		expected = new String[] {"1", "2", "@", "+", "ABCDEFG", "CD 67" , " Abc f"};
		results = ArrayTestUtils.strToStringList("[1,2,@,+, ABCDEFG, CD' '67, ' 'Abc' 'f]");
		for(int i=0; i<results.size(); i++) {
			assertEquals(results.get(i), expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			ArrayTestUtils.strToStringList(null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringList("(a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringList("[a,b,c)");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringList("(a,b,c]");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringList("abc");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringList("ab");
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			ArrayTestUtils.strToStringList("");
		});
	}
	
	@Test
	public void testToStringList() {
		String input = "[AB, a, b, c, A, ' ', D]";
		List<String> results = ArrayTestUtils.toStringList(ArrayTestUtils.strToStringArray(input));
		String[] expected = new String[] {"AB", "a", "b", "c", "A", "", "D"};
		for(int i=0; i<results.size(); i++) {
			assertEquals(results.get(i), expected[i]);
		}
		results = ArrayTestUtils.toStringList(ArrayTestUtils.strToStringArray("[] "));
		assertTrue(results.size() == 0);
		expected = new String[] {"1", "2", "@", "+", "ABCDEFG", "CD 67" , " Abc f"};
		results = ArrayTestUtils.toStringList(ArrayTestUtils.strToStringArray("[1,2,@,+, ABCDEFG, CD' '67, ' 'Abc' 'f]"));
		for(int i=0; i<results.size(); i++) {
			assertEquals(results.get(i), expected[i]);
		}
	}
	
}
