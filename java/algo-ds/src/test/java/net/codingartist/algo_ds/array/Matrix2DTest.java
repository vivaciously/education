package net.codingartist.algo_ds.array;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.math.MathUtils;


public class Matrix2DTest {

	protected Matrix2D<Integer> matrix;
	
	@AfterEach
	void tearDown() {
		matrix = null;
	}
	
	@Test
	public void testSetGet(){
		matrix = new Matrix2D<>(3,4);
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
				matrix.set(i, j, i*j);
			}
		}
		for(int i=0; i<3; i++){
			for(int j=0; j<4; j++){
				assertTrue(matrix.get(i, j) == i*j);
			}
		}
	}
	
	@Test
	public void testCopy() {
		matrix = new Matrix2D<Integer>(5,5);
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				matrix.set(i, j, MathUtils.randomInt(0, 25));
			}
		}
		Matrix2D<Integer> copy = matrix.copy();
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				assertEquals(matrix.get(i, j), copy.get(i, j));
			}
		}
	}
	
	@Test
	public void testToArray() {
		matrix = new Matrix2D<Integer>(5);
		int v = 0;
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				matrix.set(i, j, v++);
			}
		}
		Integer[] copy = new Integer[matrix.length()];
		copy = matrix.toArray(copy);
		for(int i=0; i<copy.length; i++) {
			assertTrue(copy[i].equals(Integer.valueOf(i)));
		}
		
		assertThrows(NullPointerException.class, () -> {
			matrix.toArray(null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			matrix.toArray(new Integer[matrix.length() -1]);
		});
	}
	
	@Test
	public void testTo2DArray() {
		matrix = new Matrix2D<Integer>(5);
		int v = 0;
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				matrix.set(i, j, v++);
			}
		}
		Integer[][] copy = new Integer[matrix.rows][matrix.columns];
		copy = matrix.to2DArray(copy);
		int rows = copy.length;
		int cols = copy[0].length;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				assertTrue(copy[i][j].equals(matrix.get(i, j)));
			}
		}
		
		assertThrows(NullPointerException.class, () -> {
			matrix.to2DArray(null);
		});
		
		assertThrows(IllegalArgumentException.class, () -> {
			matrix.to2DArray(new Integer[matrix.rows -1][matrix.columns -1]);
		});
	}
	
	@Test
	public void testTranspose() {
		matrix = new Matrix2D<Integer>(3);
		int v = 0;
		int[][] grid = new int[3][3];
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				matrix.set(i, j, v);
				grid[i][j] = v++;
			}
		}
		
		matrix.transpose();
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				assertEquals(matrix.get(i, j), grid[j][i]);
			}
		}
		
	}
	
	@Test
	public void testRotate() {
		matrix = new Matrix2D<Integer>(3);
		int v = 0;
		int[][] grid = {{6,3,0},{7,4,1},{8,5,2}};
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				matrix.set(i, j, v++);
			}
		}
		matrix.rotate();
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				assertEquals(matrix.get(i, j), grid[i][j]);
			}
		}
	}
	
	@Test
	public void testFlip() {
		matrix = new Matrix2D<Integer>(3);
		int v = 0;
		int[][] grid = new int[3][3];
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				matrix.set(i, j, v);
				grid[i][j] = v++;
			}
		}
		matrix.flip();
		for(int i=0; i<matrix.rows; i++) {
			for(int j=0; j<matrix.columns; j++) {
				assertEquals(matrix.get(i, j), grid[i][matrix.columns - 1 -j]);
			}
		}
	}
}
	