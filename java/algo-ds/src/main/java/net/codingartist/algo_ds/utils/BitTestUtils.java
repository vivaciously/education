package net.codingartist.algo_ds.utils;

import net.codingartist.algo_ds.string.StringUtils;

public class BitTestUtils {

	private BitTestUtils() {
		throw new AssertionError("no instantiability");
	}
	
	//For BitUtils
	public static String doubleToBinaryString(double value) {
		return Long.toBinaryString(Double.doubleToRawLongBits(value));
	}
	
	public static String intToBinaryString(int value) {
		return StringUtils.leftJustify(Integer.toBinaryString(value), 32, '0');
	}
	
}
