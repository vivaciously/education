package net.codingartist.algo_ds.linkedlist;

public class ListNode<E> extends SListNode<E> {

	protected SListNode<E> prev;
	
	public ListNode(E value) {
		super(value);
	}
	
	public SListNode<E> prev() {
		return prev;
	}
}
