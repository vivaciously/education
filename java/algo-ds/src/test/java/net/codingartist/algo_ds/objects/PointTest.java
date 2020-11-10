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
	
	@Test
	void testEuclidianDistance() {
		Point p1 = new Point(1,6);
		Point p2 = new Point(2,3);
		assertTrue(p1.eucledianDistance(p2) == 3.1622776601683795);
		assertTrue(p2.eucledianDistance(p1) == 3.1622776601683795);
	   
		p1.x = 1;
		p1.y = 1;
		
		p2.x = 1;
		p2.y = 1;
		
		assertTrue(p1.eucledianDistance(p2) == 0.0);
	}
}
