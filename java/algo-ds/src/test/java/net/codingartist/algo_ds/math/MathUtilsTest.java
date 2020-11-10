package net.codingartist.algo_ds.math;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

	@Test
	public void testIsEven() {
		assertTrue(MathUtils.isEven(4));
		assertFalse(MathUtils.isEven(3));
		assertTrue(MathUtils.isEven(0));
		assertTrue(MathUtils.isEven(-2));
	}
	
	@Test
	public void testIsOdd() {
		assertFalse(MathUtils.isOdd(4));
		assertTrue(MathUtils.isOdd(3));
		assertFalse(MathUtils.isOdd(0));
		assertTrue(MathUtils.isOdd(-15));
	}
	
	@Test
	public void testIsPowerOfTwo() {
		assertFalse(MathUtils.isPowerOfTwo(41));
		assertTrue(MathUtils.isPowerOfTwo(4));
		assertTrue(MathUtils.isPowerOfTwo(1024));
		assertFalse(MathUtils.isPowerOfTwo(1023));
		assertFalse(MathUtils.isPowerOfTwo(1025));
		assertTrue(MathUtils.isPowerOfTwo(1));
	}
	
	@Test
	public void testIsPowerOfThree() {
		assertFalse(MathUtils.isPowerOfThree(41));
		assertTrue(MathUtils.isPowerOfThree(3));
		assertTrue(MathUtils.isPowerOfThree(27));
		assertFalse(MathUtils.isPowerOfThree(26));
		assertFalse(MathUtils.isPowerOfThree(25));
		assertTrue(MathUtils.isPowerOfThree(1));
	}
	
	@Test
	public void testIsPowerOfFour() {
		assertFalse(MathUtils.isPowerOfFour(41));
		assertTrue(MathUtils.isPowerOfFour(4));
		assertTrue(MathUtils.isPowerOfFour(64));
		assertFalse(MathUtils.isPowerOfFour(65));
		assertFalse(MathUtils.isPowerOfFour(63));
		assertTrue(MathUtils.isPowerOfFour(1));
	}
	
	@Test
	public void testIsInt() {
		assertFalse(MathUtils.isInt(41.25));
		assertTrue(MathUtils.isInt(0.0));
		assertTrue(MathUtils.isInt(64));
		assertFalse(MathUtils.isInt(65.987));
		assertFalse(MathUtils.isInt(63.01));
		assertTrue(MathUtils.isInt(25.000));
	}
	
	@Test
	public void testLog2() {
		assertEquals(MathUtils.log2(8), 3);
		assertEquals(MathUtils.log2(1024), 10);
		assertEquals(MathUtils.log2(65536), 16);
	}
	
	@Test
	public void testFbonacci() {
		assertThrows(IllegalArgumentException.class, () -> {
			MathUtils.fibonacci(-1);
		});
		assertEquals(MathUtils.fibonacci(0), 0);
		assertEquals(MathUtils.fibonacci(1), 1);
		assertEquals(MathUtils.fibonacci(20), 6765);
		assertEquals(MathUtils.fibonacci(9), 34);
	}
	
	@Test
	public void testRandomInt() {
		Set<Integer> set = new HashSet<>();
		for(int i=0; i<=10; i++) {
			set.add(i);
		}
		assertFalse(set.contains(MathUtils.randomInt(11, 15)));
		while(set.size() > 0) {
			int v = MathUtils.randomInt(0, 10);
			if(set.contains(v)) {
				set.remove(v);
			}
		}
		assertTrue(set.size() == 0);
		assertTrue(MathUtils.randomInt(11, 11) == 11);
	}
	
	public void testGCD() {
		assertTrue(MathUtils.gcd(52, 39) == 13);
		assertTrue(MathUtils.gcd(51357, 3819) == 57);
	}
	
	public void testLCM() {
		assertTrue(MathUtils.lcm(10, 8) == 40);
		assertTrue(MathUtils.lcm(2, 3) == 6);
	}
	
}
