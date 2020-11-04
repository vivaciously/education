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
	
	
	@SuppressWarnings("unchecked")
	public E get(int row, int column){
		boundaryCheck(row, column);
		return (E)array[columns*row + column];
	}
	
	public void set(int row, int column, E value){
		boundaryCheck(row, column);
		array[columns*row + column] = value;
	}
	
	public void rotate() {
		//TODO
	}
	
	public void transpose() {
		//TODO
	}
	
	public void flip() {
		//TODO
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
	
	public E[][] to2DArray() {
		//TODO
		return null;
	}
	
	protected void boundaryCheck(int row, int column){
		if(row < 0 || row >= rows || column < 0 || column >= columns){
			throw new IllegalArgumentException("Invalid boundary of Matrix row: " + row + " column: " + column);
		}
	}
}
