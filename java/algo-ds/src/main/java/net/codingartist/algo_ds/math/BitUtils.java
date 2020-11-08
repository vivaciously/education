package net.codingartist.algo_ds.math;

public class BitUtils {

	private BitUtils() {
		throw new AssertionError("non instantiability");
	}
	
	public static int getBit(int n, int i) {
		return (n & (1 << i)) != 0 ? 1 : 0;
	}
	
	public static int clearBit(int n, int i){
		return n & ~(1 << i);
	}
	
}
