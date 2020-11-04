package net.codingartist.algo_ds.array;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class Matrix2DTest  extends TestCase {

	protected Matrix2D<Integer> matrix;
	
	public Matrix2DTest(String testName){
		super(testName);
		setup();
	}
	
	public static Test suite(){
	    return new TestSuite( Matrix2DTest.class );
	}
	
	public void setup(){
		matrix = new Matrix2D<>(3,4);
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
				matrix.set(i, j, i*j);
			}
		}
	}
	
	public void testGet(){
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
				assertTrue(matrix.get(i, j) == i*j);
			}
		}
	}
	
	public void testCopy() {
		//TODO
	}
	
	public void testToArray() {
		//TODO
	}
}
	