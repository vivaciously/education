package net.codingartist.algo_ds.math;

public class BitUtils {

	private BitUtils() {
		throw new AssertionError("non instantiability");
	}
	
	public static boolean isPositive(int a) {
		return (a >> 31 & 1) == 0;
	}
	
	public static int sign(int a) {
		return (a >> 31 & 0x1);
	}
	
	public static int getBit(int n, int i) {
		return (n & (1 << i)) != 0 ? 1 : 0;
	}
	
	public static int clearBit(int n, int i){
		return n & ~(1 << i);
	}
	
	public static int flipBit(int bit) {
		return 1^bit;
	}
	
	
}
