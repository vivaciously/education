package net.codingartist.algo_ds.linkedlist;

import java.util.Comparator;

public class LinkedList<E> extends AbstractLinkedList<E> {

	protected ListNode<E> tail;
	
	public LinkedList() {
		head = new ListNode<>();
		tail = new ListNode<>();
		
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public LinkedList(E value) {
		
	}
	
	public LinkedList(Iterable<? extends E> src) {
		
	}
	
	public LinkedList(E[] array) {
		
	}

	@Override
	public void addAll(Iterable<? extends E> src) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAll(E[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E peekAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E peekTail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToFront(E value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addToTail(E value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAt(E value, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeTail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E removeAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(E value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeDuplicates(Comparator<E> c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mergeSort(Comparator<E> c) {
		// TODO Auto-generated method stub
		
	}
	

}
