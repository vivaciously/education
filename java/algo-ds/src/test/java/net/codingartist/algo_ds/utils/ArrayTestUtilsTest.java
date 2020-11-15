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
}
