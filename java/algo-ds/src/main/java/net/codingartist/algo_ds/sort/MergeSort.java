package net.codingartist.algo_ds.sort;
import java.util.Comparator;

public class MergeSort {

	private MergeSort() {
		throw new AssertionError();
	}
	
	public static void mergeSort(int[] array, int n) {
		if(n < 2) {
			return;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		for(int i=0; i<mid; i++) {
			left[i] = array[i];
		}
		for(int i=mid; i<n; i++) {
			right[i- mid] = array[i]; 
		}
		mergeSort(left, mid);
		mergeSort(right, n- mid);
		merge(array, left, right);
	}
	
	private static void merge(int[] array, int[] left, int[] right) {
		int i = 0;
		int j = 0;
		int index = 0;
		while(i < left.length && j < right.length) {
			if(left[i] <= right[j]) {
				array[index++] = left[i++];
			} else {
				array[index++] = right[j++];
			}
		}
		
		//left overs
		while(i < left.length) {
			array[index++] = left[i++];
		}
		
		while(j < right.length) {
			array[index++] = right[j++];
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T> void mergeSort(T[] array, int n, Comparator<T> c) {
		if(n < 2) {
			return;
		}
		int mid = n/2;
		T[] left = (T[])new Object[mid];
		for(int i=0; i<mid; i++) {
			left[i] = array[i];
		}
		T[] right = (T[])new Object[n-mid];
		for(int i=mid; i<n; i++) {
			right[i-mid] = array[i];
		}
		mergeSort(left, mid, c);
		mergeSort(right, n - mid, c);
		merge(array, left, right, c);
	}
	
	private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> c) {
		int i = 0;
		int j = 0;
		int index = 0;
		while(i < left.length && j < right.length) {
			if(c.compare(left[i], right[j]) <= 0) {
				array[index++] = left[i++];
			} else {
				array[index++] = right[j++];
			}
		}
		
		
		//left overs
		while(i < left.length) {
			array[index++] = left[i++];
		}
		
		while(j < right.length) {
			array[index++] = right[j++];
		}
	}
}
