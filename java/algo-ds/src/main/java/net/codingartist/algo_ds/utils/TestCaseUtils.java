package net.codingartist.algo_ds.utils;

import net.codingartist.algo_ds.string.StringUtils;

public class TestCaseUtils {

	private TestCaseUtils() {
		throw new AssertionError("no instantiability");
	}
	
	//For BitUtils
	public static String doubleToBinaryString(double value) {
		return Long.toBinaryString(Double.doubleToRawLongBits(value));
	}
	
	public static String intToBinaryString(int value) {
		return StringUtils.leftPad(Integer.toBinaryString(value), 32, '0');
	}
}
