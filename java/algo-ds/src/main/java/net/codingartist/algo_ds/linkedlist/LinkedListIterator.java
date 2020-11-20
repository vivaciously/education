package net.codingartist.algo_ds.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

	private ListNode<T> itr;
	private ListNode<T> tail;
	
	public LinkedListIterator(ListNode<T> head) {
		this.itr = head;
		this.tail = null;
	}
	
	public LinkedListIterator(ListNode<T> head, ListNode<T> tail) {
		this.itr = head.next;
		this.tail = tail;
	}
	
	@Override
	public boolean hasNext() {
		return itr == tail ? false:true;
	}

	@Override
	public T next() {
		if(!hasNext()) {
			throw new NoSuchElementException("There are no more elements remaining to iterate over.");
		}
		T value = itr.value;
		itr = itr.next;
		return value;
	}

}
