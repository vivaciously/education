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
		assertThrows(NullPointerException.class, () -> {
			StringUtils.leftJustify(null, 2, 'd');
		});
	}
	
	@Test
	public void testRightJustify() {
		assertEquals(StringUtils.rightJustify("", 5, 'a'), "aaaaa");
		assertEquals(StringUtils.rightJustify("abc", 3, 'd'), "abc");
		assertEquals(StringUtils.rightJustify("abc", 4, 'd'), "abcd");
		assertEquals(StringUtils.rightJustify("abc", 5, 'd'), "abcdd");
		assertEquals(StringUtils.rightJustify("abc", 2, 'd'), "abc");
		assertThrows(NullPointerException.class, () -> {
			StringUtils.rightJustify(null, 2, 'd');
		});
	}
	
	@Test
	public void testLeftPad() {
		assertEquals(StringUtils.leftPad("", 5, 'a'), "aaaaa");
		assertEquals(StringUtils.leftPad("abc", 3, 'd'), "dddabc");
		assertEquals(StringUtils.leftPad("abc", 4, 'd'), "ddddabc");
		assertEquals(StringUtils.leftPad("abc", 5, 'd'), "dddddabc");
		assertEquals(StringUtils.leftPad("abc", 2, 'd'), "ddabc");
		assertThrows(NullPointerException.class, () -> {
			StringUtils.leftPad(null, 2, 'd');
		});
	}
	
	@Test
	public void testRightPad() {
		assertEquals(StringUtils.rightPad("", 5, 'a'), "aaaaa");
		assertEquals(StringUtils.rightPad("abc", 3, 'd'), "abcddd");
		assertEquals(StringUtils.rightPad("abc", 4, 'd'), "abcdddd");
		assertEquals(StringUtils.rightPad("abc", 5, 'd'), "abcddddd");
		assertEquals(StringUtils.rightPad("abc", 2, 'd'), "abcdd");
		assertThrows(NullPointerException.class, () -> {
			StringUtils.rightPad(null, 2, 'd');
		});
	}
}
