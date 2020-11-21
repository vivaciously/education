package net.codingartist.algo_ds.queue;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Stream;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;
import net.codingartist.algo_ds.linkedlist.LinkedList;

public class Queue<E> implements Iterable<E> {
	
	protected LinkedList<E> list;
	
	protected void checkSize() {
		if(list.isEmpty()) {
			throw new EmptyDataStructureException("The Queue is empty.");
		}
	}
	
	public Queue() {
		list = new LinkedList<>();
	}
	
	public Queue(Iterable<? extends E> src) {
		list = new LinkedList<>(src);
	}
	
	public Queue(E[] array) {
		list = new LinkedList<>(array);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void clear() {
		list.clear();
	}
	
	public E peek() {
		checkSize();
		return list.peek();
	}
	
	public E peekLast() {
		checkSize();
		return list.peekTail();
	}
	
	public void enqueue(E val) {
		list.addToTail(val);
	}
	
	public void enqueueAll(Iterable<? extends E> src) {
		list.addAll(src);
	}
	
	public void enqueueAll(E[] array) {
		list.addAll(array);
	}
	
	public E dequeue() {
		checkSize();
		return list.removeFirst();
	}

	@Override
	public Iterator<E> iterator() {
		return list.iterator();
	}
	
	public E[] toArray(E[] array) {
		return list.toArray(array);
	}
	
	public void toCollection(Collection<? super E> dst){
		list.toCollection(dst);
	}

	public Stream<E> stream() {
		return list.stream();
	}
}
