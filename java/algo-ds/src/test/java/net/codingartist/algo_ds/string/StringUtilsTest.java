package net.codingartist.algo_ds.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class StringUtilsTest {

	@Test
	public void testIsNullOrEmpty() {
		assertTrue(StringUtils.isNullOrEmpty(""));
		assertTrue(StringUtils.isNullOrEmpty(null));
		assertFalse(StringUtils.isNullOrEmpty("Hello"));
	}
	
	@Test
	public void testReverse() {
		assertEquals(StringUtils.reverse("abc"), "cba");
		assertEquals(StringUtils.reverse(""), "");
		assertThrows(NullPointerException.class, () -> {
			StringUtils.reverse(null);
		});
		assertFalse(StringUtils.reverse("acb").equals("acb"));
	}
	
	@Test
	public void testLeftJustify() {
		assertEquals(StringUtils.leftJustify("", 5, 'a'), "aaaaa");
		assertEquals(StringUtils.leftJustify("abc", 3, 'd'), "abc");
		assertEquals(StringUtils.leftJustify("abc", 4, 'd'), "dabc");
		assertEquals(StringUtils.leftJustify("abc", 5, 'd'), "ddabc");
		assertEquals(StringUtils.leftJustify("abc", 2, 'd'), "abc");
	}
	
	@Test
	public void testRightJustify() {
		assertEquals(StringUtils.rightJustify("", 5, 'a'), "aaaaa");
		assertEquals(StringUtils.rightJustify("abc", 3, 'd'), "abc");
		assertEquals(StringUtils.rightJustify("abc", 4, 'd'), "abcd");
		assertEquals(StringUtils.rightJustify("abc", 5, 'd'), "abcdd");
		assertEquals(StringUtils.rightJustify("abc", 2, 'd'), "abc");
	}
}
