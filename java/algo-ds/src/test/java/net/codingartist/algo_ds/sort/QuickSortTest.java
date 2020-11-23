package net.codingartist.algo_ds.sort;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class QuickSortTest {

	@Test
	public void testQuickSortIntArray() {
		int[] array = ArrayTestUtils.strToIntArray("[7,1,3,1,6,9,3,0,-1,5]");
		QuickSort.quickSort(array, 0, array.length -1);
		int[] expected = ArrayTestUtils.strToIntArray("[7,1,3,1,6,9,3,0,-1,5]");
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntArray("[1,2,3,4,5]");
		expected = ArrayTestUtils.strToIntArray("[1,2,3,4,5]");
		QuickSort.quickSort(array, 0, array.length -1);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntArray("[3,2,1]");
		expected = ArrayTestUtils.strToIntArray("[3,2,1]");
		QuickSort.quickSort(array, 0, array.length -1);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntArray("[1]");
		expected = ArrayTestUtils.strToIntArray("[1]");
		QuickSort.quickSort(array, 0, array.length -1);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			QuickSort.quickSort(null, 0, 5);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			QuickSort.quickSort(new int[] {}, 0, 0);
		});
	}
	
	@Test
	public void testQuickSort() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[7,1,3,1,6,9,3,0,-1,5]");
		QuickSort.quickSort(array, 0, array.length -1, Integer::compare);
		int[] expected = ArrayTestUtils.strToIntArray("[7,1,3,1,6,9,3,0,-1,5]");
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntegerArray("[1,2,3,4,5]");
		expected = ArrayTestUtils.strToIntArray("[1,2,3,4,5]");
		QuickSort.quickSort(array, 0, array.length -1, Integer::compare);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntegerArray("[3,2,1]");
		expected = ArrayTestUtils.strToIntArray("[3,2,1]");
		QuickSort.quickSort(array, 0, array.length -1, Integer::compare);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntegerArray("[1]");
		expected = ArrayTestUtils.strToIntArray("[1]");
		QuickSort.quickSort(array, 0, array.length -1, Integer::compare);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			QuickSort.quickSort(null, 0, 5);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			QuickSort.quickSort(new int[] {}, 0, 0);
		});
	}
}
