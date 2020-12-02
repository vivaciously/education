package net.codingartist.algo_ds.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.utils.ArrayTestUtils;


public class QuickSelectTest {

	@Test
	public void testQuickSelectIntArray() {
		int[] array = ArrayTestUtils.strToIntArray("[7,1,3,1,6,9,3,0,-1,5]");
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, array.length -1), 9);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 0), -1);
		array = ArrayTestUtils.strToIntArray("[1,1,1]");
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, array.length -1), 1);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 0), 1);
		
		array = ArrayTestUtils.strToIntArray("[1,2,3]");
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 0), 1);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 1), 2);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 2), 3);
		
		assertThrows(NullPointerException.class, () -> {
			QuickSelect.quickSelect(null, 0, 0, 0);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			int[] nums = ArrayTestUtils.strToIntArray("[1,1,1]");
			QuickSelect.quickSelect(nums, 0, nums.length, 0);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			int[] nums = ArrayTestUtils.strToIntArray("[1,1,1]");
			QuickSelect.quickSelect(nums, -1, nums.length-1, 0);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			int[] nums = ArrayTestUtils.strToIntArray("[1,1,1]");
			QuickSelect.quickSelect(nums, 0, nums.length-1, -1);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			int[] nums = ArrayTestUtils.strToIntArray("[1,1,1]");
			QuickSelect.quickSelect(nums, 0, nums.length-1, nums.length);
		});
	}
	
	@Test
	public void testQuickSelect() {
		Integer[] array = ArrayTestUtils.strToIntegerArray("[7,1,3,1,6,9,3,0,-1,5]");
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, array.length -1, Integer::compare), 9);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 0, Integer::compare), -1);
		array = ArrayTestUtils.strToIntegerArray("[1,1,1]");
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, array.length -1, Integer::compare), 1);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 0, Integer::compare), 1);
		
		array = ArrayTestUtils.strToIntegerArray("[1,2,3]");
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 0,Integer::compare), 1);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 1,Integer::compare), 2);
		assertEquals(QuickSelect.quickSelect(array, 0, array.length-1, 2,Integer::compare), 3);
		
		assertThrows(NullPointerException.class, () -> {
			QuickSelect.quickSelect(null, 0, 0, 0);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Integer[] nums = ArrayTestUtils.strToIntegerArray("[1,1,1]");
			QuickSelect.quickSelect(nums, 0, nums.length, 0, Integer::compare);
		});
		
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			Integer[] nums = ArrayTestUtils.strToIntegerArray("[1,1,1]");
			QuickSelect.quickSelect(nums, -1, nums.length-1, 0, Integer::compare);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Integer[] nums = ArrayTestUtils.strToIntegerArray("[1,1,1]");
			QuickSelect.quickSelect(nums, 0, nums.length-1, -1, Integer::compare);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			Integer[] nums = ArrayTestUtils.strToIntegerArray("[1,1,1]");
			QuickSelect.quickSelect(nums, 0, nums.length-1, nums.length, Integer::compare);
		});
	}
}
