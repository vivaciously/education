package net.codingartist.algo_ds.objects;


import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;


public class PointTest {

	@Test
	void testEquals() {
		Point x = new Point(2,3);
		Point y = new Point(2,3);
		Point z = new Point(2,3);
		
		assertTrue(x.equals(x));
		
		assertTrue(x.equals(y));
		assertTrue(y.equals(x));
		
		assertTrue(y.equals(z));
		assertTrue(x.equals(z));
		
		assertFalse(x.equals(null));
	
	}
	
	@Test
	void testHashcode() {
		Point c1 = new Point(2,3);
		Point c2 = new Point(2,3);
		Point c3 = new Point(3,2);
		
		assertTrue(c1.hashCode() == c2.hashCode());
		assertFalse(c1.hashCode() == c3.hashCode());
	}
}
