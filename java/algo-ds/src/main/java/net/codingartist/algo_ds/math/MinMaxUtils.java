package net.codingartist.algo_ds.math;

import java.util.Comparator;

public class MinMaxUtils {

	private MinMaxUtils() {
		throw new AssertionError("No instantiability");
	}
	
	public static <E extends Comparable<E>> E max(E a, E b) {
		if(a == null || b == null) {
			throw new NullPointerException("Given arguments cannot be null. a: " + a + " b: " + b);
		}
		int compare = a.compareTo(b);
		if(compare == 0) {
			return a;
		}
		return compare > 0 ? a : b;
	}
	
	public static <T> T max(T a, T b, Comparator<T> c) {
		if(a == null || b == null || c == null) {
			throw new NullPointerException("Given arguments cannot be null. a: " + a + " b: " + b);
		}
		int compare = c.compare(a, b);
		if(compare == 0) {
			return a;
		}
		return compare > 0 ? a : b;
	}
	
	public static <E extends Comparable<E>> E min(E a, E b) {
		if(a == null || b == null) {
			throw new NullPointerException("Given arguments cannot be null. a: " + a + " b: " + b);
		}
		int compare = a.compareTo(b);
		if(compare == 0) {
			return a;
		}
		return compare > 0 ? b : a;
	}
	
	public static <T> T min(T a, T b, Comparator<T> c) {
		if(a == null || b == null || c == null) {
			throw new NullPointerException("Given arguments cannot be null. a: " + a + " b: " + b);
		}
		int compare = c.compare(a, b);
		if(compare == 0) {
			return a;
		}
		return compare > 0 ? b : a;
	}
}
