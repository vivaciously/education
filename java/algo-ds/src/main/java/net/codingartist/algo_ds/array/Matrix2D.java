package net.codingartist.algo_ds.array;

import java.util.Arrays;

public class Matrix2D<E> {

	private Object[] array;
	private final int rows;
	private final int columns;
	
	public Matrix2D(int n){
		if(n < 0) {
			throw new IllegalArgumentException("Index cannot be a negative number: " + n);
		}
		array = new Object[n*n];
		this.rows = n;
		this.columns = n;
	}
	
	public Matrix2D(int rows, int columns){
		if(rows < 0 || columns < 0) {
			throw new IllegalArgumentException("Invalid indices of Matrix rows: " + rows+ " column: " + columns);
		}
		array = new Object[rows * columns];
		this.rows = rows;
		this.columns = columns;
	}
	
	public Matrix2D(E[][] matrix) {
		if(matrix == null) {
			throw new NullPointerException("Given matrix is null.");
		} else if(matrix[0] == null) {
			throw new NullPointerException("The columns of given matrix is null.");
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		array = new Object[rows * cols];
		this.rows = rows;
		this.columns = cols;
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				array[index(i,j)] = matrix[i][j];
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public E get(int row, int column){
		boundaryCheck(row, column);
		return (E)array[index(row, column)];
	}
	
	public void set(int row, int column, E value){
		boundaryCheck(row, column);
		array[index(row, column)] = value;
	}
	
	public void rotate() {
		transpose();
		flip();
	}
	
	@SuppressWarnings("unchecked")
	public void transpose() {
		for(int i=0; i<rows; i++) {
			for(int j=i+1; j<columns; j++) {
				E temp = (E) array[index(i,j)];
				array[index(i,j)] = array[index(j, i)];
				array[index(j,i)] = temp;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public void flip() {
		for(int i=0; i<rows; i++) {
			int left = 0;
			int right = columns -1;
			while(left < right) {
				E temp = (E)array[index(i, left)];
				array[index(i, left)] = array[index(i, right)];
				array[index(i, right)] = temp;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Matrix2D<E> copy() {
		Matrix2D<E> cloned = new Matrix2D<>(rows, columns);
		cloned.array = (E[])Arrays.copyOf(array, rows * columns);
		return cloned;
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArray() {
		return (E[])Arrays.copyOf(array, rows * columns);
	}
	
	@SuppressWarnings("unchecked")
	public E[][] to2DArray() {
		Object[][] matrix = new Object[rows][columns];
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				matrix[i][j] = array[index(i,j)];
			}
		}
		return (E[][])matrix;
	}
	
	protected void boundaryCheck(int row, int column){
		if(row < 0 || row >= rows || column < 0 || column >= columns){
			throw new IllegalArgumentException("Invalid boundary of Matrix row: " + row + " column: " + column);
		}
	}
	
	protected int index(int r, int c) {
		return this.columns * r + c;
	}
}
