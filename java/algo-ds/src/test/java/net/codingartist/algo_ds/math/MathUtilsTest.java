package net.codingartist.algo_ds.math;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
}
