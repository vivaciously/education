package net.codingartist.algo_ds.string;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class KMPTest {

	@Test
	public void testLPS() {
		String pattern = "aabaabaaa";
		int[] lps = KMP.lps(pattern);
		int[] expected = ArrayTestUtils.strToIntArray("[0,1,0,1,2,3,4,5,2]");
		for(int i=0; i<lps.length; i++) {
			assertTrue(lps[i] == expected[i]);
		}
	}
	
	@Test
	public void testKMP() {
		String text = "abxabcabcaby";
		String pattern = "abcaby";
		
		assertTrue(KMP.kmp(text, pattern));
	}
	
	@Test
	public void testKMPIndex() {
		String text = "abxabcabcaby";
		String pattern = "abcaby";
		
		assertEquals(KMP.kmpIndex(text, pattern),6);
		text = "dabc";
		pattern = "abc";
		assertEquals(KMP.kmpIndex(text, pattern),1);
		
		text = "dabc";
		pattern = "abcd";
		assertEquals(KMP.kmpIndex(text, pattern),-1);
		
		text = "djabc";
		pattern = "abc";
		assertEquals(KMP.kmpIndex(text, pattern),2);
	}
}
