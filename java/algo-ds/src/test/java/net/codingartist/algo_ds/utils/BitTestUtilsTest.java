package net.codingartist.algo_ds.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BitTestUtilsTest {

	@Test
	public void testIntToBinaryString() {
		String bin5 = BitTestUtils.intToBinaryString(5);
		assertTrue(bin5.length() == 32);
		assertEquals(bin5, "00000000000000000000000000000101");
		String negBin1 = BitTestUtils.intToBinaryString(-1);
		assertTrue(negBin1.length() == 32);
		assertEquals(negBin1, "11111111111111111111111111111111");
		String zero = BitTestUtils.intToBinaryString(0);
		assertTrue(zero.length() == 32);
		assertEquals(zero, "00000000000000000000000000000000");
		
		String negBin17 = BitTestUtils.intToBinaryString(-17);
		assertTrue(negBin1.length() == 32);
		assertEquals(negBin17, "11111111111111111111111111101111");
	}
	
	@Test
	public void testDoubleToBinaryString() {
		assertEquals(BitTestUtils.doubleToBinaryString(-23.45), "1100000000110111011100110011001100110011001100110011001100110011");
	}
	
}
