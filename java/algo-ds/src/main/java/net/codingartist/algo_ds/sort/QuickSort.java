package net.codingartist.algo_ds.sort;

import java.util.Comparator;

import net.codingartist.algo_ds.array.ArrayUtils;

public class QuickSort {

	private QuickSort() {
		throw new AssertionError();
	}
	
	public static void quickSort(int[] array, int left, int right) {
		int index = partition(array, left, right);
		if(left < index -1) {
			quickSort(array, left, index -1);
		}
		if(index < right) {
			quickSort(array, index, right);
		}
	}
	
	private static int partition(int[] array, int left, int right) {
		int pivot = array[left + (right - left) / 2];
		while(left <= right) {
			while(array[left] < pivot) {
				left++;
			}
			while(array[right] > pivot) {
				right--;
			}
			
			if(left <= right) {
				ArrayUtils.swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static <T> void quickSort(T[] array, int left, int right, Comparator<T> c) {
		int index = partition(array, left, right, c);
		if(left < index -1) {
			quickSort(array, left, index -1, c);
		}
		if(index < right) {
			quickSort(array, index, right, c);
		}
	}
	
	public static <T> int partition(T[] array, int left, int right, Comparator<T> c) {
		T pivot = array[left + (right - left) / 2];
		while(left <= right) {
			while(c.compare(array[left], pivot) < 0) {
				left++;
			}
			while(c.compare(array[right], pivot) > 0) {
				right--;
			}
			if(left <= right) {
				ArrayUtils.swap(array, left, right);
				left++;
				right--;
			}
		}
		return left;
	}
	
	
}
