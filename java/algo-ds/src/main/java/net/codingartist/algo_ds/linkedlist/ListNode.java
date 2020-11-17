package net.codingartist.algo_ds.linkedlist;

public class ListNode<E> {
	protected ListNode<E> next;
	protected ListNode<E> prev;
	protected E value;
	
	protected ListNode() {
		next = null;
		value = null;
		prev = null;
	}
	
	
	public ListNode(E value) {
		this.value = value;
	}
	
	public E value() {
		return this.value;
	}
	
	public ListNode<E> next() {
		return next;
	}
	
	public ListNode<E> prev() {
		return prev;
	}
	
}
