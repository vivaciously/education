package net.codingartist.algo_ds.sort;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class MergeSortTest {

	@Test
	public void testMergeSortIntArray() {
		int[] array = ArrayTestUtils.strToIntArray("[7,1,3,1,6,9,3,0,-1,5]");
		MergeSort.mergeSort(array, array.length);
		int[] expected = ArrayTestUtils.strToIntArray("[7,1,3,1,6,9,3,0,-1,5]");
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntArray("[1,2,3,4,5]");
		expected = ArrayTestUtils.strToIntArray("[1,2,3,4,5]");
		MergeSort.mergeSort(array, array.length);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntArray("[3,2,1]");
		expected = ArrayTestUtils.strToIntArray("[3,2,1]");
		MergeSort.mergeSort(array, array.length);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntArray("[1]");
		expected = ArrayTestUtils.strToIntArray("[1]");
		MergeSort.mergeSort(array, array.length);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			MergeSort.mergeSort(null, 5);
		});
		
		assertDoesNotThrow(() -> {
			MergeSort.mergeSort(new int[] {}, 0);
		});
	}
	
	@Test
	public void testMergeSort() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[7,1,3,1,6,9,3,0,-1,5]");
		MergeSort.mergeSort(array, array.length, Integer::compare);
		Integer[] expected = ArrayTestUtils.strToIntegerArray("[7,1,3,1,6,9,3,0,-1,5]");
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		array = ArrayTestUtils.strToIntegerArray("[1,2,3,4,5]");
		expected = ArrayTestUtils.strToIntegerArray("[1,2,3,4,5]");
		MergeSort.mergeSort(array, array.length, Integer::compare);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntegerArray("[3,2,1]");
		expected = ArrayTestUtils.strToIntegerArray("[3,2,1]");
		MergeSort.mergeSort(array, array.length, Integer::compare);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		array = ArrayTestUtils.strToIntegerArray("[1]");
		expected = ArrayTestUtils.strToIntegerArray("[1]");
		MergeSort.mergeSort(array, array.length, Integer::compare);
		Arrays.sort(expected);
		for(int i=0; i<array.length; i++) {
			assertEquals(array[i], expected[i]);
		}
		
		assertThrows(NullPointerException.class, () -> {
			MergeSort.mergeSort(null, 5);
		});
		
		assertDoesNotThrow(() -> {
			MergeSort.mergeSort(new int[] {}, 0);
		});
	}
}
