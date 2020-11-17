package net.codingartist.algo_ds.linkedlist;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {

	private ListNode<T> itr;
	
	public LinkedListIterator(ListNode<T> head) {
		this.itr = head;
	}
	
	@Override
	public boolean hasNext() {
		return itr == null ? false:true;
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
