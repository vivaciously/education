package net.codingartist.algo_ds.stack;

import java.util.Comparator;
import java.util.EmptyStackException;

import net.codingartist.algo_ds.math.MinMaxUtils;

public class MinMaxStack<E> {

	private ListNode head;
	private final Comparator<E> comparator;
	private int size;
	
	public MinMaxStack(Comparator<E> comparator) {
		this.size = 0;
		this.comparator = comparator;
	}
	
	public int size() {
		return this.size;
	}
	
	public void push(E val) {
		size++;
		if(head == null) {
			head = new ListNode(val,val,val);
		} else {
			ListNode n = new ListNode(val, MinMaxUtils.min(val, head.min, comparator), MinMaxUtils.max(val, head.max, comparator));
			n.next = head;
			head = n;
		}
	}
	
	public E pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		size--;
		E val = head.val;
		head = head.next;
		return val;
	}
	
	public E min() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return head.min;
	}
	
	public E max() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return head.max;
	}
	
	public E peek() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return head.val;
	}
	
	private class ListNode {
		E max;
		E min;
		E val;
		ListNode next;
		
		public ListNode(E val, E min, E max) {
			this.val = val;
			this.min = min;
			this.max = max;
		}
	}
}
