package net.codingartist.algo_ds.array;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

import net.codingartist.algo_ds.exceptions.DeepCopyFailedException;
import net.codingartist.algo_ds.exceptions.FullCapacityDataStructureException;
import net.codingartist.algo_ds.utils.AlgoDSUtils;

public class CircularArray<E extends Serializable> {

	protected Object array[];
	protected int size;
	protected int cursor;
	protected final boolean immutable;
	protected final boolean reallocatable;
	protected final int DEFAULT_CAPACITY = 10;
	
	public CircularArray(int capacity, boolean immutable, boolean reallocatable){
		array = new Object[capacity];
		size = 0;
		cursor =0;
		this.immutable = immutable;
		this.reallocatable = reallocatable;
	}
	
	public CircularArray(int capacity){
		array = new Object[capacity];
		size = 0;
		cursor =0;
		immutable = false;
		reallocatable = true;
	}
	
	public CircularArray(){
		array = new Object[DEFAULT_CAPACITY];
		size = 0;
		cursor =0;
		immutable = false;
		reallocatable = true;
	}
	
	public CircularArray(E[] tArray, boolean immutable, boolean reallocatable){
		this.immutable = immutable;
		this.reallocatable = reallocatable;
		size = 0;
		cursor =0;
		array = new Object[tArray.length];
		for(int i=0; i<tArray.length; i++){
			if(tArray[i] != null) {
				insert(tArray[i]);
			}
		}
	}
	
	public CircularArray(Iterable<? extends E> src, boolean immutable){
		this.immutable = immutable;
		this.reallocatable = true;
		size = 0;
		cursor =0;
		array = new Object[DEFAULT_CAPACITY];
		for(E data : src){
			if(data != null) {
				this.insert(data);
			}
		}
	}
	
	public boolean isElementImmutable(){
		return immutable;
	}
	
	public boolean isReallocatable() {
		return reallocatable;
	}
	
	public void clear(){
		for(int i=0; i<size; i++){
			array[i] = null;
		}
		size = 0;
		cursor = 0;
	}
	
	public int capacity() {
		return array.length;
	}
	
	/*
	 * The function returns the first element
	 * 
	 */
	@SuppressWarnings("unchecked")
	public E poll(){
		if(size() == 0){
			throw new NoSuchElementException("The CircularArray is empty.");
		}
		--size;
		E element = (E)array[cursor];
		array[cursor] = null;
		cursor = (cursor+1) % array.length;
		return element;
	}
	
	@SuppressWarnings("unchecked")
	public E peek(){
		if(immutable) {
			E cloned = (E)AlgoDSUtils.deepCopy((E)array[cursor]);
			if(cloned == null) {
				throw new DeepCopyFailedException("Failed to deepCopy the element: " + (E)array[cursor]);
			}
			return cloned;
		}
		return (E)array[cursor];
	}
	
	@SuppressWarnings("unchecked")
	public E peekAt(int offset){
		int tempCur = (cursor + offset) % size;
		if(immutable) {
			E cloned = (E)AlgoDSUtils.deepCopy((E)array[tempCur]);
			if(cloned == null) {
				throw new DeepCopyFailedException("Failed to deepCopy the element: " + (E)array[tempCur]);
			}
			return cloned;
		}
		return (E)array[tempCur];
	}
	
	public void insert(E element){
		if(element == null) {
			throw new NullPointerException("element is null.");
		}
		if(isFull()){
			if(reallocatable){
				reallocate();
			}else{
				throw new FullCapacityDataStructureException("The CircularArray is full.");
			}
		}
		if(immutable) {
			@SuppressWarnings("unchecked")
			E cloned = (E)AlgoDSUtils.deepCopy(element);
			if(cloned == null) {
				throw new DeepCopyFailedException("Failed to deepCopy the element: " + element);
			}
			array[(cursor + size) % array.length] = cloned;
		} else {
			array[(cursor + size) % array.length] = element;
		}
		++size;
	}
	
	public int size(){
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public List<E> toListFrom(int index){
		List<E> list = new ArrayList<>();
		int tempCursor = (cursor + index) % array.length;
		for(int i=0; i<size; i++){
			if(array[tempCursor] != null) {
				list.add((E)array[tempCursor]);
			} else {
				tempCursor = 0;
				list.add((E)array[tempCursor]);
			}
			tempCursor = (tempCursor + 1) % array.length;
		}
		if(immutable) {
			return List.of(list.toArray((E[])new Serializable[] {}));
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public void toCollectionFrom(int index, Collection<? super E> dst){
		int tempCursor = (cursor + index) % array.length;
		if(immutable) {
			for(int i=0; i<size; i++){
				if(array[tempCursor] != null) {
					E cloned = (E)AlgoDSUtils.deepCopy(array[tempCursor]);
					if(cloned == null) {
						throw new DeepCopyFailedException("Failed to deepCopy the element: " + array[tempCursor]);
					}
					dst.add(cloned);
				} else {
					tempCursor = 0;
					E cloned = (E)AlgoDSUtils.deepCopy(array[tempCursor]);
					dst.add(cloned);
				}
				tempCursor = (tempCursor + 1) % array.length;
			}
		} else {
			for(int i=0; i<size; i++){
				if(array[tempCursor] != null) {
					dst.add((E)array[tempCursor]);
				} else {
					tempCursor = 0;
					dst.add((E)array[tempCursor]);
				}
				tempCursor = (tempCursor + 1) % array.length;
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public E[] toArrayFrom(int index, E[] buffer) {
		if(buffer.length < size){
			throw new IllegalArgumentException("The lenght of the array is less than the size of the RingArray.");
		}
		Object[] src = new Object[size];
		int tempCursor = (cursor + index) % array.length;
		if(immutable) {
			for(int i=0; i<size; i++){
				if(array[tempCursor] != null) {
					E cloned = (E)AlgoDSUtils.deepCopy(array[tempCursor]);
					if(cloned == null) {
						throw new DeepCopyFailedException("Failed to deepCopy the element: " + array[tempCursor]);
					}
					src[i] = cloned;
				} else {
					tempCursor = 0;
					E cloned = (E)AlgoDSUtils.deepCopy(array[tempCursor]);
					if(cloned == null) {
						throw new DeepCopyFailedException("Failed to deepCopy the element: " + array[tempCursor]);
					}
					src[i] = cloned;
				}
				tempCursor = (tempCursor + 1) % array.length;
			}
		} else {
			for(int i=0; i<size; i++){
				if(array[tempCursor] != null) {
					src[i] = (E)array[tempCursor];
				} else {
					tempCursor = 0;
					src[i] = (E)array[tempCursor];
				}
				tempCursor = (tempCursor + 1) % array.length;
			}
		}
		System.arraycopy(src, 0, buffer, 0, size);
		src = null;
		return buffer;
	}
	
	protected boolean isFull(){
		return size == array.length;
	}
	
	protected void reallocate(){
		Object [] temp = new Object[array.length *2];
		int tempSize = size;
		for(int i=0; i<tempSize; i++){
			temp[i] = poll();
		}
		cursor = 0;
		size = tempSize;
		array = temp;
	}
	
	@SuppressWarnings("unchecked")
	protected void printAllElementsFrom(int index){
		StringBuffer sb = new StringBuffer();
		int tempCursor = (cursor + index) % array.length;
		for(int i=0; i<size; i++){
			if(array[tempCursor] != null) {
				sb.append(tempCursor);
				sb.append(" - ");
				sb.append((E)array[tempCursor].toString());
				sb.append("\n");
			} else {
				tempCursor = 0;
				sb.append(tempCursor);
				sb.append(" - ");
				sb.append((E)array[tempCursor].toString());
				sb.append("\n");
			}
			tempCursor = (tempCursor + 1) % array.length;
		}
		System.out.println(sb.toString());
	}

}
