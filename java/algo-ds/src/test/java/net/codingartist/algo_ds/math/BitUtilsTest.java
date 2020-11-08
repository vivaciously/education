package net.codingartist.algo_ds.math;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BitUtilsTest {

	@Test
	public void testGetBit() {
		assertTrue(BitUtils.getBit(1, 0) == 1);
		assertFalse(BitUtils.getBit(1, 1) == 1);
		assertTrue(BitUtils.getBit(-1, 31) == 1);
		assertTrue(BitUtils.getBit(5, 2) == 1);
		assertFalse(BitUtils.getBit(5, 1) == 1);
	}
	
	@Test
	public void testClearBit() {
		assertTrue(BitUtils.getBit(BitUtils.clearBit(5, 2), 2) == 0);
		assertTrue(BitUtils.getBit(BitUtils.clearBit(5, 1), 1) == 0);
	}
}
