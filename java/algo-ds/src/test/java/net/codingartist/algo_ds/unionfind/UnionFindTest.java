package net.codingartist.algo_ds.unionfind;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class UnionFindTest {

	/*@BeforeAll
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
		
	}*/
	
	@Test
	public void testUnionFind() {
		UnionFind uf = new UnionFind(10);
		assertFalse(uf.find(0, 1));
		assertTrue(uf.union(0, 1));
		assertTrue(uf.find(0, 1));
		
		assertTrue(uf.union(1, 3));
		assertTrue(uf.find(0, 3));
		assertTrue(uf.find(3, 1));
		assertTrue(uf.find(1, 3));
		assertTrue(uf.find(0, 1));
		
		assertFalse(uf.find(0, 4));
	}
	
	@Test(expected = Test.None.class /* no exception expected */) 
	public void testValidIndices() {
		UnionFind uf = new UnionFind(2);
		assertTrue(uf.union(0, 1));
		assertFalse(uf.union(0, 1));
		assertTrue(uf.find(0, 1));
	}
	
	@Test
	public void testInvalidIndices() {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    @SuppressWarnings("unused")
			UnionFind uf = new UnionFind(-1);
		 });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    @SuppressWarnings("unused")
			UnionFind uf = new UnionFind(1);
		 });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    UnionFind uf = new UnionFind(10);
		    uf.union(-1, 0);
		 });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    UnionFind uf = new UnionFind(10);
		    uf.union(11, 0);
		 });
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
		    UnionFind uf = new UnionFind(2);
		    uf.union(0, 2);
		 });
	}
}
