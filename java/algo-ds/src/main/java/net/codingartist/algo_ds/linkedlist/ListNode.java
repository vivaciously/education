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
	
	public ListNode(E value, ListNode<E> next, ListNode<E> prev) {
		this.value = value;
		this.next = next;
		this.prev = prev;
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
