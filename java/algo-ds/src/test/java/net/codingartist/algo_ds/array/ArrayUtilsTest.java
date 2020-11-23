package net.codingartist.algo_ds.array;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class ArrayUtilsTest {

	@Test
	public void testSwapIntArray() {
		int[] array = ArrayTestUtils.strToIntArray("[1,7,24,0]");
		ArrayUtils.swap(array, 0, array.length -1);
		int[] expected = ArrayTestUtils.strToIntArray("[0,7,24,1]");
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntArray("[1,7,3]");
		expected = ArrayTestUtils.strToIntArray("[1,7,3]");
		ArrayUtils.swap(array, 1, 1);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntArray("[1]");
		expected = ArrayTestUtils.strToIntArray("[1]");
		ArrayUtils.swap(array, 0, array.length -1);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			int[] test = null;
			ArrayUtils.swap(test, 0, 5);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ArrayUtils.swap(new int[] {}, 0, 0);
		});
	}
	
	@Test
	public void testSwap() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[1,7,24,0]");
		ArrayUtils.swap(array, 0, array.length -1);
		Integer[] expected = ArrayTestUtils.strToIntegerArray("[0,7,24,1]");
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntegerArray("[1,7,3]");
		expected = ArrayTestUtils.strToIntegerArray("[1,7,3]");
		ArrayUtils.swap(array, 1, 1);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntegerArray("[1]");
		expected = ArrayTestUtils.strToIntegerArray("[1]");
		ArrayUtils.swap(array, 0, array.length -1);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			int[] test = null;
			ArrayUtils.swap(test, 0, 5);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ArrayUtils.swap(new int[] {}, 0, 0);
		});
	}
	
	@Test
	public void testSliceIntArray() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[1,7,24,0]");
		Integer[] result = ArrayUtils.slice(array, 0, 3);
		Integer[] expected = ArrayTestUtils.strToIntegerArray("[1,7]");
		for(int i=0; i<expected.length; i++) {
			assertEquals(result[i], expected[i]);
		}
		assertDoesNotThrow(() -> {
			assertTrue(ArrayUtils.slice(array, 0, 0).length == 0);
		});
		
		result = ArrayUtils.slice(array, 0, array.length);
		expected = ArrayTestUtils.strToIntegerArray("[1,7,24,0]");
		for(int i=0; i<expected.length; i++) {
			assertEquals(result[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			int[] test = null;
			ArrayUtils.slice(test, 0, 5);
		});
		
		assertDoesNotThrow(() -> {
			assertTrue(ArrayUtils.slice(new int[] {}, 0, 0).length == 0);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ArrayUtils.swap(new int[] {}, 0, 1);
		});
	}
	
	@Test
	public void testSlice() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[1,7,24,0]");
		Integer[] result = ArrayUtils.slice(array, 0, 3);
		Integer[] expected = ArrayTestUtils.strToIntegerArray("[1,7]");
		for(int i=0; i<expected.length; i++) {
			assertEquals(result[i], expected[i]);
		}
		assertDoesNotThrow(() -> {
			assertTrue(ArrayUtils.slice(array, 0, 0).length == 0);
		});
		
		result = ArrayUtils.slice(array, 0, array.length);
		expected = ArrayTestUtils.strToIntegerArray("[1,7,24,0]");
		for(int i=0; i<expected.length; i++) {
			assertEquals(result[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			int[] test = null;
			ArrayUtils.slice(test, 0, 5);
		});
		
		assertDoesNotThrow(() -> {
			assertTrue(ArrayUtils.slice(new int[] {}, 0, 0).length == 0);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			ArrayUtils.swap(new int[] {}, 0, 1);
		});
	}
	
	@Test
	public void testReverseIntArray() {
		int[] array = ArrayTestUtils.strToIntArray("[1,7,24,0]");
		ArrayUtils.reverse(array);
		int[] expected = ArrayTestUtils.strToIntArray("[0,24,7,1]");
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntArray("[1,7,3]");
		expected = ArrayTestUtils.strToIntArray("[3,7,1]");
		ArrayUtils.reverse(array);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntArray("[1]");
		expected = ArrayTestUtils.strToIntArray("[1]");
		ArrayUtils.reverse(array);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			int[] test = null;
			ArrayUtils.reverse(test);
		});
		
		assertDoesNotThrow(() -> {
			ArrayUtils.reverse(new int[] {});
		});
	}
	
	@Test
	public void testReverse() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[1,7,24,0]");
		ArrayUtils.reverse(array);
		Integer[] expected = ArrayTestUtils.strToIntegerArray("[0,24,7,1]");
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntegerArray("[1,7,3]");
		expected = ArrayTestUtils.strToIntegerArray("[3,7,1]");
		ArrayUtils.reverse(array);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntegerArray("[1]");
		expected = ArrayTestUtils.strToIntegerArray("[1]");
		ArrayUtils.reverse(array);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			int[] test = null;
			ArrayUtils.reverse(test);
		});
		
		assertDoesNotThrow(() -> {
			ArrayUtils.reverse(new int[] {});
		});
	}
}
