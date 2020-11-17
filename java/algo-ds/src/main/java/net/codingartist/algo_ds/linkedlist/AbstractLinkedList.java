package net.codingartist.algo_ds.linkedlist;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public abstract class AbstractLinkedList<E> implements Iterable<E> {

	protected ListNode<E> head;
	protected int size;
	
	protected void checkIndex(int index) {
		if(index < 0 ){
			throw new IllegalArgumentException("The given index is invalid. index: " + index);
		}else if(index > size){
			throw new IllegalArgumentException("The given index is out of range. index: " + index + " size:" + size);
		}
	}
	
	protected void checkValue(E value) {
		if(value == null) {
			throw new NullPointerException("Given value is null.");
		}
	}
	
	protected void checkSize() {
		if(size == 0) {
			throw new NoSuchElementException("List is empty.");
		}
	}
	
	public abstract void addAll(Iterable<? extends E> src);
	public abstract void addAll(E[] array);
	public abstract E peekAt(int index);
	public abstract E peek();
	public abstract E peekTail();
	public abstract boolean contains(E value);
	public abstract void clear();
	public abstract void addToFront(E value);
	public abstract void addToTail(E value);
	public abstract void insertAt(E value, int index);
	public abstract E removeFirst();
	public abstract E removeTail();
	public abstract E removeAt(int index);
	public abstract boolean remove(E value);
	public abstract void reverse();
	public abstract void removeDuplicates(Comparator<E> c);
	public abstract void mergeSort(Comparator<E> c);
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public E[] toArray(E[] array){
		if(array.length < size){
			throw new IllegalArgumentException("The lenght of the array is less than the size of the LinkedList.");
		}
		Object[] src = new Object[size];
		for(int i=0; i<size; i++){
			src[i] = this.peekAt(i);
		}
		System.arraycopy(src, 0, array, 0, size);
		src = null;
		return array;
	}
	
	public void toCollection(Collection<? super E> dst){
		for(int i=0; i<size; i++){
			dst.add((E)peekAt(i));
		}
	}
	
	public Stream<E> stream() {
		Builder<E> builder = Stream.builder();
		for(E value: this) {
			builder.add(value);
		}
		return builder.build();
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(head);
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("size: ");
		sb.append(size);
		sb.append("\n");
		int index = 0;
		ListNode<E> pointer = head;
		while(pointer != null){
			sb.append("index: ");
			sb.append(index++);
			sb.append(" - ");
			sb.append(pointer.value().toString());
			sb.append("\n");
			pointer = pointer.next();
		}
		return sb.toString();
	}
}
