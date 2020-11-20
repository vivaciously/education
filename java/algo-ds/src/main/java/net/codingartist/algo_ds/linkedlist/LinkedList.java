package net.codingartist.algo_ds.linkedlist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinkedList<E> extends AbstractLinkedList<E> {

	protected ListNode<E> tail;
	protected Map<E, SingleLinkedList<ListNode<E>>> map = new HashMap<>();
	
	public LinkedList() {
		head = new ListNode<>();
		tail = new ListNode<>();
		
		head.next = tail;
		tail.prev = head;
		size = 0;
	}
	
	public LinkedList(E value) {
		head = new ListNode<>();
		tail = new ListNode<>();
		
		head.next = tail;
		tail.prev = head;
		
		ListNode<E> n = new ListNode<>(value);
		map.put(value, new SingleLinkedList<>(n));
		head.next = n;
		n.prev = head;
		
		tail.prev = n;
		n.next = tail;
		
		size = 1;
	}
	
	public LinkedList(Iterable<? extends E> src) {
		head = new ListNode<>();
		tail = new ListNode<>();
		
		ListNode<E> p = head;
		ListNode<E> prev = null;
		for(E val : src) {
			map.putIfAbsent(val, new SingleLinkedList<>());
			prev = p;
			p.next = new ListNode<>(val);
			p = p.next;
			map.get(val).addToFront(p);
			p.prev = prev;
			prev.next = p;
			size++;
		}
		p.next = tail;
		tail.prev = p;
		
	}
	
	public LinkedList(E[] array) {
		head = new ListNode<>();
		tail = new ListNode<>();
		
		ListNode<E> p = head;
		ListNode<E> prev = null;
		for(E val : array) {
			map.putIfAbsent(val, new SingleLinkedList<>());
			prev = p;
			p.next = new ListNode<>(val);
			p = p.next;
			map.get(val).addToFront(p);
			p.prev = prev;
			prev.next = p;
			size++;
		}
		p.next = tail;
		tail.prev = p;
	}

	@Override
	public void addAll(Iterable<? extends E> src) {
		if(size == 0) {
			ListNode<E> p = head;
			ListNode<E> prev = null;
			for(E val : src) {
				map.putIfAbsent(val, new SingleLinkedList<>());
				prev = p;
				p.next = new ListNode<>(val);
				p = p.next;
				map.get(val).addToFront(p);
				p.prev = prev;
				prev.next = p;
				size++;
			}
			p.next = tail;
			tail.prev = p;
		} else {
			ListNode<E> p = tail.prev;
			ListNode<E> prev = null;
			for(E val : src) {
				map.putIfAbsent(val, new SingleLinkedList<>());
				prev = p;
				p.next = new ListNode<>(val);
				p = p.next;
				map.get(val).addToFront(p);
				p.prev = prev;
				prev.next = p;
				size++;
			}
			p.next = tail;
			tail.prev = p;
		}
		
	}

	@Override
	public void addAll(E[] array) {
		if(size == 0) {
			ListNode<E> p = head;
			ListNode<E> prev = null;
			for(E val : array) {
				map.putIfAbsent(val, new SingleLinkedList<>());
				prev = p;
				p.next = new ListNode<>(val);
				p = p.next;
				map.get(val).addToFront(p);
				p.prev = prev;
				prev.next = p;
				size++;
			}
			p.next = tail;
			tail.prev = p;
		} else {
			ListNode<E> p = tail.prev;
			ListNode<E> prev = null;
			for(E val : array) {
				map.putIfAbsent(val, new SingleLinkedList<>());
				prev = p;
				p.next = new ListNode<>(val);
				p = p.next;
				map.get(val).addToFront(p);
				p.prev = prev;
				prev.next = p;
				size++;
			}
			p.next = tail;
			tail.prev = p;
		}
	}

	@Override
	public E peekAt(int index) {
		ListNode<E> p = findNodeAt(index);
		return p.value;
	}

	@Override
	public E peek() {
		checkSize();
		return head.next.value;
	}

	@Override
	public E peekTail() {
		checkSize();
		return tail.prev.value;
	}

	@Override
	public boolean contains(E value) {
		if(map.containsKey(value)) {
			return true;
		}
		return false;
	}

	@Override
	public void clear() {
		head = new ListNode<>();
		tail = new ListNode<>();
		
		head.next = tail;
		tail.prev = head;
		size = 0;
		for(SingleLinkedList<ListNode<E>> sl : map.values()) {
			sl.clear();
		}
		map.clear();
	}

	@Override
	public void addToFront(E value) {
		checkValue(value);
		ListNode<E> n = new ListNode<>(value);
		map.putIfAbsent(value, new SingleLinkedList<>());
		map.get(value).addToFront(n);
		ListNode<E> next = head.next;
		n.next = next;
		next.prev = n;
		
		head.next = n;
		n.prev = head;
		size++;
	}

	@Override
	public void addToTail(E value) {
		checkValue(value);
		ListNode<E> n = new ListNode<>(value);
		map.putIfAbsent(value, new SingleLinkedList<>());
		map.get(value).addToFront(n);
		ListNode<E> prev = tail.prev;
		prev.next = n;
		n.prev = prev;
		
		n.next = tail;
		tail.prev = n;
		size++;
	}

	@Override
	public void insertAt(E value, int index) {
		ListNode<E> n = findNodeAt(index);
		ListNode<E> newNode = new ListNode<>(value);
		ListNode<E> prev = n.prev;
		n.prev = newNode;
		newNode.next = n;
		
		newNode.prev = prev;
		prev.next = newNode;
		
	}

	@Override
	public E removeFirst() {
		checkSize();
		ListNode<E> n = head.next;
		ListNode<E> next = n.next;
		head.next = next;
		next.prev = head;
		size--;
		updateMap(n);
		return n.value;
	}

	@Override
	public E removeTail() {
		checkSize();
		ListNode<E> n = tail.prev;
		ListNode<E> prev = n.prev;
		
		prev.next = tail;
		tail.prev = prev;
		size--;
		updateMap(n);
		return n.value;
	}

	@Override
	public E removeAt(int index) {
		ListNode<E> n = findNodeAt(index);
		remove(n);
		return n.value;
	}

	@Override
	public boolean remove(E value) {
		if(map.containsKey(value)) {
			ListNode<E> n = map.get(value).removeFirst();
			updateMap(n);
			remove(n);
			return true;
		}
		return false;
	}
	
	protected void updateMap(ListNode<E> n) {
		if(map.get(n.value).size() == 0) {
			map.put(n.value, null);
			map.remove(n.value);
		} 
	}
	
	protected void remove(ListNode<E> n) {
		ListNode<E> next = n.next;
		ListNode<E> prev = n.prev;
		
		prev.next = next;
		next.prev = prev;
		size--;
	}
	
	protected ListNode<E> findNodeAt(int index) {
		checkSize();
		if(index >= size || index < 0) {
			throw new IllegalArgumentException("The given index is out of range. index: " + index + " size:" + size);
		}
		ListNode<E> p = (size - index) < index ? tail.prev : head.next;
		int count = (size - index < index) ? size - index - 1 :index;
		if(p == tail.prev) {
			for(int i=0; i<count; i++) {
				p = p.prev;
			}
		} else {
			for(int i=0; i<count; i++) {
				p = p.next;
			}
		}
		return p;
	}

	@Override
	public void reverse() {
		if(size <= 1) {
			return;
		}
		ListNode<E> cur = head.next;
		ListNode<E> newTail = head.next;
		ListNode<E> newHead = tail.prev;
		
		head.next = null;
		tail.prev = null;
		while(cur.next != null) {
			ListNode<E> temp = cur.next;
			cur.next = cur.prev;
			cur.prev = temp;
			cur = cur.prev;
		}
		
		tail.prev = newTail;
		newTail.next = tail;
		
		head.next = newHead;
	}

	@Override
	public void removeDuplicates(Comparator<E> c) {//TODO
		// TODO Auto-generated method stub
		
	}
	
	public void removeAllDuplicatedElements() {
		checkSize();
		Set<E> keys = new HashSet<>();
		for(SingleLinkedList<ListNode<E>> sl : map.values()) {
			if(sl.size() > 1) {
				E key = sl.peek().value;
				for(ListNode<E> n : sl) {
					remove(n);
					keys.add(key);
				}
			}
		}
		for(E key : keys) {
			SingleLinkedList<ListNode<E>> sl = map.get(key);
			sl.clear();
			sl = null;
			map.remove(key);
		}
		keys.clear();
		keys = null;
	}

	@Override
	public void mergeSort(Comparator<E> c) {//TODO
		if(size <= 1) {
			return;
		}
		
	}
	
	protected ListNode<E> mergeSort(ListNode<E> head, Comparator<E> c) {//TODO
		return null;
	}
	
	protected ListNode<E> merge(ListNode<E> l1, ListNode<E> l2) {//TODO
		return null;
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("size: ");
		sb.append(size);
		if(size != 0) {
			sb.append("\n");
			int index = 0;
			ListNode<E> pointer = head.next;
			while(pointer != tail){
				sb.append("index: ");
				sb.append(index++);
				sb.append(" - ");
				sb.append(pointer.value().toString());
				sb.append("\n");
				pointer = pointer.next();
			}
		}
		return sb.toString();
	}

}
