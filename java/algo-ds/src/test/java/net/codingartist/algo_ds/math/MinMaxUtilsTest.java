package net.codingartist.algo_ds.math;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import java.util.Comparator;

public class MinMaxUtilsTest {

	@Test
	public void testMinMaxComparable() {
		String s1 ="abcde";
		String s2 = "abcdef";
		
		assertTrue(MinMaxUtils.max(s1, s2) == s2);
		assertTrue(MinMaxUtils.min(s1, s2) == s1);
	}
	
	@Test
	public void testMinMaxComparableWithNull() {
		
		assertThrows(NullPointerException.class, () -> {
			String s1 ="abc";
			String s2 = null;
			MinMaxUtils.max(s1, s2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			String s1 =null;
			String s2 = "abc";
			MinMaxUtils.max(s1, s2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			String s1 =null;
			String s2 = null;
			MinMaxUtils.max(s1, s2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			String s1 ="abc";
			String s2 = null;
			MinMaxUtils.min(s1, s2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			String s1 =null;
			String s2 = "abc";
			MinMaxUtils.min(s1, s2);
		});
		
		assertThrows(NullPointerException.class, () -> {
			String s1 =null;
			String s2 = null;
			MinMaxUtils.min(s1, s2);
		});
	}
	
	@Test
	public void testMinMaxComparator() {
		Comparator<Integer> c = (a, b) -> Integer.compare(a,b);
		assertTrue(MinMaxUtils.max(100, 290, c) == 290);
		assertTrue(MinMaxUtils.min(290, 100, c) == 100);
		
		c = (a,b) -> Integer.compare(b, a);
		assertTrue(MinMaxUtils.max(100, 290, c) == 100);
		assertTrue(MinMaxUtils.min(290, 100, c) == 290);
	}
	
	@Test
	public void testMinMaxComparatorWithNull() {
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.max(1, null, (a, b) -> Integer.compare(a,b));
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.max(null, 35, (a, b) -> Integer.compare(a,b));
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.max(null, null, null);
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.max(1, 5, null);
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.min(1, null, (a, b) -> Integer.compare(a,b));
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.min(null, 35, (a, b) -> Integer.compare(a,b));
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.min(null, null, null);
		});
		
		assertThrows(NullPointerException.class, () -> {
			MinMaxUtils.min(1, 5, null);
		});
	}
	
	
	
}
