package net.codingartist.algo_ds.design;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class LRUCacheTest {

	@BeforeAll
	static void setup() {
		
	}
	
	@BeforeEach
	void init() {
		
	}
	
	@AfterEach
	void tearDown() {
		
	}
	
	@AfterAll
	static void done() {
		
	}
	
	@Test
	public void testLRUCache() {
		LRUCache<Integer, Integer> cache = new LRUCache<>(2);
		assertTrue(cache.size() == 0);
		cache.put(1, 1);
		assertTrue(cache.size() == 1);
		cache.put(2, 2);
		assertTrue(cache.size() == 2);
		assertEquals(cache.get(1), Integer.valueOf(1));
		cache.put(3, 3);
		assertTrue(cache.size() == 2);
		assertTrue(cache.get(2) == null);
		cache.put(4, 4);
		assertTrue(cache.get(1) == null);
		assertEquals(cache.get(3), Integer.valueOf(3));
		assertEquals(cache.get(4), Integer.valueOf(4));
	}
}
