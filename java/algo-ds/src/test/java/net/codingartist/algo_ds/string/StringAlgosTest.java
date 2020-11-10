package net.codingartist.algo_ds.string;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

public class StringAlgosTest {

	@Test
	public void testIsPermutation(){
		assertTrue(StringAlgos.isPermutation("abcd", "acbd"));
		assertFalse(StringAlgos.isPermutation("abcd", "acfd"));
		assertFalse(StringAlgos.isPermutation("", "acfd"));
		assertTrue(StringAlgos.isPermutation("", ""));
		assertFalse(StringAlgos.isPermutation(null, "acbd"));
		assertFalse(StringAlgos.isPermutation("abcd", null));
	}
	
	@Test
	public void testPermutation(){
		//System.out.println("abc".substring(0, 0)); returns an empty String.
		var set = new HashSet<String>();
		set.addAll(Arrays.asList(
				"abc", "acb", "bac", "bca", "cab", "cba" 
		));
		var results = StringAlgos.permutate("abc");
		for(var result : results) {
			assertTrue(set.contains(result));
		}
		
		results = StringAlgos.permutate(null);
		assertTrue(results.isEmpty());
		results = StringAlgos.permutate("");
		assertTrue(results.isEmpty());
	}
}
