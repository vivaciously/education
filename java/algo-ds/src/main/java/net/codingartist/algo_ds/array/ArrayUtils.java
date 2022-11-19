package net.codingartist.algo_ds.array;

import java.util.Arrays;

public class ArrayUtils {

	private ArrayUtils() {
		throw new AssertionError();
	}
	
	public static <T> T[] slice(T[] array, int start, int end) {
		T[] sliced = Arrays.copyOf(array, end - start);
		return sliced;
	}
	
	public static int[] slice(int[] array, int start, int end) {
		int[] sliced = new int[end - start];
		int index =0;
		for(int i=start; i<end; i++) {
			sliced[index++] = array[i];
		}
		return sliced;
	}
	
	public static <T> void swap(T[] array, int i, int j) {
		T temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void swap(int[] array, int left, int right) {
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}
	
	public static <T> void reverse(T[] array) {
		int left = 0;
		int right = array.length -1;
		while(left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}
	
	public static void reverse(int[] array) {
		int left =0;
		int right = array.length -1;
		while(left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}
}
