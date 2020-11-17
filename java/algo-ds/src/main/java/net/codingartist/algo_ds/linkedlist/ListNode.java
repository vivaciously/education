package net.codingartist.algo_ds.linkedlist;

public class SListNode<E> {
	protected SListNode<E> next;
	protected E value;
	
	protected SListNode() {
		next = null;
		value = null;
	}
	
	
	public SListNode(E value) {
		this.value = value;
	}
	
	public E value() {
		return this.value;
	}
	
	public SListNode<E> next() {
		return next;
	}
}
