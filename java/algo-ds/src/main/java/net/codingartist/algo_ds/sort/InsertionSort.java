package net.codingartist.algo_ds.sort;

import java.util.Comparator;

public class InsertionSort {
	
	private InsertionSort() {
		throw new AssertionError();
	}

	public static void insertionSort(int[] array) {
		int n = array.length;
		if(n < 2) {
			return;
		}
		
		for(int right=1; right<n; right++) {
			int rightValue = array[right];
			int left = right -1;
			
			while(left >= 0 && array[left] > rightValue) {
				array[left + 1] = array[left];
				left--;
			}
			array[left + 1] = rightValue;
		}
	}
	
	public static <T> void insertionSort(T[] array, Comparator<T> c) {
		int n = array.length;
		if(n < 2) {
			return;
		}
		for(int right=1; right<n; right++) {
			T rightValue = array[right];
			int left = right -1;
			while(left >=0 && c.compare(array[left], rightValue) > 0) {
				array[left + 1] = array[left];
				left--;
			}
			array[left + 1] = rightValue;
		}
	}
}
