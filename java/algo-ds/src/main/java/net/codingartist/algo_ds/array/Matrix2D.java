package net.codingartist.algo_ds.array;

import java.util.Arrays;

public class Matrix2D<E> {

	private Object[] array;
	protected final int rows;
	protected final int columns;
	
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
	
	public int rows() {
		return this.rows;
	}
	
	public int columns() {
		return this.columns;
	}
	
	public int length() {
		return rows * columns;
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
				left++;
				right--;
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
	public E[] toArray(E[] dst) {
		if(dst == null) {
			throw new NullPointerException("Given array dst is null.");
		}
		if(dst.length < rows * columns) {
			throw new IllegalArgumentException("The length of dst is less than the length of Matrix2D: " + dst.length + " rows: " 
					+ this.rows + " columns: " + columns);
		}
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				dst[index(i,j)] = (E)array[index(i,j)];
			}
		}
		return dst;
	}
	
	@SuppressWarnings("unchecked")
	public E[][] to2DArray(E[][] dst) {
		if(dst == null) {
			throw new NullPointerException("Given array dst is null.");
		}
		if(dst.length != rows || dst[0].length != columns) {
			throw new IllegalArgumentException("The length of dst is not the same as the length of Matrix2D: " + "dst.length"
		+ dst.length + " rows: " 
					+ this.rows + " dst[0].length: " + dst[0].length + " columns: " + columns);
		}
		for(int i=0; i<rows; i++) {
			for(int j=0; j<columns; j++) {
				dst[i][j] = (E)array[index(i,j)];
			}
		}
		return dst;
	}
	
	protected void boundaryCheck(int row, int column){
		if(row < 0 || row >= rows || column < 0 || column >= columns){
			throw new IllegalArgumentException("Invalid boundary of Matrix row: " + row + " column: " + column);
		}
	}
	
	protected int index(int r, int c) {
		return this.columns * r + c;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[  ").append("\n");
		for(int i=0; i<rows; i++) {
			sb.append("  [");
			for(int j=0; j<columns; j++) {
				sb.append(this.get(i, j)).append(",").append(" ");
			}
			sb.setLength(sb.length() -2);
			sb.append("]");
			sb.append("\n");
		}
		sb.append("]");
		return sb.toString();
	}
	
}
