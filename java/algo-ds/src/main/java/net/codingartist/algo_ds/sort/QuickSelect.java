package net.codingartist.algo_ds.sort;

import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;
import net.codingartist.algo_ds.array.ArrayUtils;

public class QuickSelect {

	private QuickSelect() {
		throw new AssertionError("No instantiability");
	}
	
	public static int quickSelect(int[] array, int left, int right, int k) {
		if(k <0 || k >= array.length) {
			throw new IllegalArgumentException("Given k: " + k + " is out of range [0 -" + (array.length -1) + "]");
		}
		if(left < 0 || right >= array.length) {
			throw new ArrayIndexOutOfBoundsException("Given Index left: " + left + " right: " + right + " is invalid.");
		}
		if(left == right) {
			return array[left];
		}
		int pivotIndex = ThreadLocalRandom.current().nextInt(left, right);
		int partitionedIndex = partition(array, left, right, pivotIndex);
		if(partitionedIndex == k) {
			return array[partitionedIndex];
		} else if(partitionedIndex < k) {
			return quickSelect(array, partitionedIndex + 1, right, k);
		} else {
			return quickSelect(array, left, partitionedIndex -1, k);
		}
	}
	
	private static int partition(int[] array, int left, int right, int pivotIndex) {
		int pivot = array[pivotIndex];
		ArrayUtils.swap(array, pivotIndex, right);
		int partitionedIndex = left;
		for(int i=left; i<=right; i++) {
			if(array[i] < pivot) {
				ArrayUtils.swap(array, i, partitionedIndex);
				partitionedIndex++;
			}
		}
		ArrayUtils.swap(array, right, partitionedIndex);
		return partitionedIndex;
	}
	
	public static <T> T quickSelect(T[] array, int left, int right, int k, Comparator<T> c) {
		if(k <0 || k >= array.length) {
			throw new IllegalArgumentException("Given k: " + k + " is out of range [0 -" + (array.length -1) + "]");
		}
		if(left < 0 || right >= array.length) {
			throw new ArrayIndexOutOfBoundsException("Given Index left: " + left + " right: " + right + " is invalid.");
		}
		if(left == right) {
			return array[left];
		}
		int pivotIndex = ThreadLocalRandom.current().nextInt(left, right);
		int partitionedIndex = partition(array, left, right, pivotIndex, c);
		if(partitionedIndex == k) {
			return array[partitionedIndex];
		} else if(partitionedIndex < k) {
			return quickSelect(array, partitionedIndex + 1, right, k, c);
		} else {
			return quickSelect(array, left, partitionedIndex -1, k, c);
		}
	}
	
	private static <T> int partition(T[] array, int left, int right, int pivotIndex, Comparator<T> c) {
		T pivot = array[pivotIndex];
		ArrayUtils.swap(array, right, pivotIndex);
		int partitionedIndex = left;
		for(int i=left; i<=right; i++) {
			if(c.compare(array[i], pivot) < 0) {
				ArrayUtils.swap(array, partitionedIndex, i);
				partitionedIndex++;
			}
		}
		ArrayUtils.swap(array, right, partitionedIndex);
		return partitionedIndex;
	}
}
