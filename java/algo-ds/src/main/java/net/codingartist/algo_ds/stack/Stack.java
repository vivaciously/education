package net.codingartist.algo_ds.stack;

import java.util.Collection;
import java.util.EmptyStackException;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;


public class Stack<T> {

	protected int capacity = 10;
	protected int cursor = -1;
	protected int size = 0;
	protected Object[] data;
	
	public Stack(){
		data = new Object[capacity];
	}
	
	public Stack(int initCapacity){
		if(initCapacity < 1){
			throw new IllegalArgumentException("Capacity of the Stack must be greater than 0");
		}
		this.capacity = initCapacity;
		data = new Object[capacity];
	}
	
	public void push(T element){
		if(element == null) {
			throw new NullPointerException("Given element is null.");
		}
		if(size == capacity){
			reallocate();
		}
		++size;
		++cursor;
		data[cursor] = element;
	}
	
	public void pushAll(Iterable<? extends T> src) {
		for(T t : src) {
			push(t);
		}
	}
	
	public void popAll(Collection<? super T> dst) {
		while(!isEmpty()) {
			dst.add(pop());
		}
	}
	
	public T pop(){
		if(size == 0){
			throw new EmptyStackException();
		}
		--size;
		@SuppressWarnings("unchecked")
		T value = (T) data[cursor];
		data[cursor] = null;
		cursor--;
		return value;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void clear(){
		for(int i=0; i<size; i++){
			data[i] = null;
		}
		size = 0;
		cursor = -1;
	}
	
	@SuppressWarnings("unchecked")
	public T peek(){
		if(size == 0){
			throw new EmptyStackException();
		}
		return (T) data[cursor];
	}
	
	protected void reallocate(){
		capacity <<=1;
		Object[] newData = new Object[capacity];
		System.arraycopy(data, 0, newData, 0, data.length);
		data = null;
		data = newData;
	}
	
	public int capacity(){
		return capacity;
	}
	
	@SuppressWarnings("unchecked")
	public Stream<T> stream() {
		Builder<T> builder = Stream.builder();
		int tempCursor = cursor;
		for(int i=0; i<size; i++) {
			builder.add((T)data[tempCursor]);
			tempCursor--;
		}
		return builder.build();
	}
	
	
	@SuppressWarnings("unchecked")
	public void toCollection(Collection<? super T> collection){
		int tempCursor = cursor;
		for(int i=0; i<size; i++){
			collection.add((T)data[tempCursor]);
			tempCursor--;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T[] toArray(T[] buffer) {
		if(buffer.length < size){
			throw new IllegalArgumentException("The lenght of the array is less than the size of the Stack.");
		}
		Object[] src = new Object[size];
		int tempCursor = cursor;
		for(int i=0; i<size; i++){
			src[i] = (T)data[tempCursor];
			tempCursor--;
		}
		System.arraycopy(src, 0, buffer, 0, size);
		src = null;
		return buffer;
	}
}