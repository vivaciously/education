package net.codingartist.algo_ds.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;


public class StringUtilsTest {

	@Test
	public void testIsPermutation(){
		assertTrue(StringUtils.isPermutation("abcd", "acbd"));
		assertFalse(StringUtils.isPermutation("abcd", "acfd"));
	}
	
	@Test
	public void testPermutation(){
		//System.out.println("abc".substring(0, 0)); returns an empty String.
		var set = new HashSet<String>();
		set.addAll(Arrays.asList(
				"abc", "acb", "bac", "bca", "cab", "cba" 
		));
		var results = StringUtils.permutate("abc");
		for(var result : results) {
			assertTrue(set.contains(result));
		}
	}
}
