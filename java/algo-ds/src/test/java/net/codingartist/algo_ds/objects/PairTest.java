package net.codingartist.algo_ds.objects;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class PairTest extends TestCase {

	public PairTest(String testName){
		super(testName);
	}
	
	public static Test suite(){
	    return new TestSuite( PairTest.class );
	}
	
	public void testPair(){
		Pair<Integer, Double> p1 = new Pair<>(5,2.5);
		assertTrue(p1.getFirst() == 5);
		assertTrue(Double.doubleToLongBits(p1.getSecond()) == Double.doubleToLongBits(2.5));
		
		Pair<Double, Integer> p2 = new Pair<>(2.5,5);
		
		assertTrue(Double.doubleToLongBits(p2.getFirst()) == Double.doubleToLongBits(2.5));
		assertTrue(p2.getSecond() == 5);
		
		
	}
	
	public void testEqualsPositive(){
		Pair<Integer, Double> p1 = new Pair<>(5,2.5);
		Pair<Integer, Double> p2 = new Pair<>(5,2.5);
		Pair<Integer, Double> p3 = new Pair<>(5,2.5);
		assertFalse(p1.equals(null));
		assertTrue(p1.equals(p1));//reflective
		assertTrue(p1.equals(p2));//symmetry
		assertTrue(p2.equals(p1));//symmetry
		assertTrue(p2.equals(p3));//transitive
		assertTrue(p1.equals(p3));//transitive
	}
	
	public void testEqualsNegative(){
		Pair<Integer, Double> p1 = new Pair<>(5,2.5);
		Pair<Double, Integer> p2 = new Pair<>(2.5,5);
		assertFalse(p1.equals(p2));
	}
	
	public void testHashCode(){
		Pair<Integer, Double> p1 = new Pair<>(5,2.5);
		Pair<Integer, Double> p2 = new Pair<>(5,2.5);
		assertTrue(p1.hashCode() == p2.hashCode());
		
		Pair<Integer, Double> p3 = new Pair<>(5,2.5);
		Pair<Double, Integer> p4 = new Pair<>(2.5,5);
		
		assertFalse(p3.hashCode() == p4.hashCode());
		assertTrue(p2.hashCode() == p3.hashCode());
		assertTrue(p1.hashCode() == p3.hashCode());
		
	}
}
