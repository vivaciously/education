package net.codingartist.algo_ds.linkedlist;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


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
		checkValue(value);
		head = new ListNode<>();
		tail = new ListNode<>();
		
		head.next = tail;
		tail.prev = head;
		
		ListNode<E> n = new ListNode<>(value);
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
			checkValue(val, "Given src contains Null.");
			prev = p;
			p.next = new ListNode<>(val);
			p = p.next;
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
		for(int i=0; i<array.length; i++) {
			checkValue(array[i], "Given array contains Null at index: " + i );
			prev = p;
			p.next = new ListNode<>(array[i]);
			p = p.next;
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
				checkValue(val, "Given src contains Null.");
				prev = p;
				p.next = new ListNode<>(val);
				p = p.next;
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
				checkValue(val, "Given src contains Null.");
				prev = p;
				p.next = new ListNode<>(val);
				p = p.next;
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
			for(int i=0; i<array.length; i++) {
				checkValue(array[i], "Given array contains Null at index: " + i );
				prev = p;
				p.next = new ListNode<>(array[i]);
				p = p.next;
				p.prev = prev;
				prev.next = p;
				size++;
			}
			p.next = tail;
			tail.prev = p;
		} else {
			ListNode<E> p = tail.prev;
			ListNode<E> prev = null;
			for(int i=0; i<array.length; i++) {
				checkValue(array[i], "Given array contains Null at index: " + i );
				prev = p;
				p.next = new ListNode<>(array[i]);
				p = p.next;
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
		checkValue(value);
		if(size == 0) {
			return false;
		}
		ListNode<E> p = head.next;
		while(p != tail) {
			if(p.value.equals(value)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}

	@Override
	public void clear() {
		head.next = null;
		tail.prev = null;
		
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	@Override
	public void addToFront(E value) {
		checkValue(value);
		ListNode<E> n = new ListNode<>(value);
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
		ListNode<E> prev = tail.prev;
		prev.next = n;
		n.prev = prev;
		
		n.next = tail;
		tail.prev = n;
		size++;
	}

	@Override
	public void insertAt(E value, int index) {
		checkValue(value);
		if(index >= size + 1) {
			throw new IllegalArgumentException("The given index is out of range. index: " + index + " size:" + size);
		}
		if(index < size) {
			ListNode<E> n = findNodeAt(index);
			ListNode<E> newNode = new ListNode<>(value);
			ListNode<E> prev = n.prev;
			n.prev = newNode;
			newNode.next = n;
			
			newNode.prev = prev;
			prev.next = newNode;
			size++;
		} else if(index == size) {
			addToTail(value);
		}
	}

	@Override
	public E removeFirst() {
		checkSize();
		ListNode<E> n = head.next;
		ListNode<E> next = n.next;
		head.next = next;
		next.prev = head;
		size--;
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
		return n.value;
	}

	@Override
	public E removeAt(int index) {
		if(index >= size || index < 0) {
			throw new IllegalArgumentException("The given index is out of range. index: " + index + " size:" + size);
		}
		ListNode<E> n = findNodeAt(index);
		remove(n);
		return n.value;
	}

	@Override
	public boolean remove(E value) {
		checkValue(value);
		if(size == 0) {
			return false;
		}
		ListNode<E> p = head.next;
		while(p != tail) {
			if(p.value.equals(value)) {
				remove(p);
				return true;
			}
			p = p.next;
		}
		return false;
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
	public void removeDuplicates(Comparator<E> c) {
		if(size <= 1) {
			return;
		}
		mergeSort(c);
		ListNode<E> cur = head.next;
		while(cur != null && cur.next != tail) {
			if(c.compare(cur.value(), cur.next.value) == 0) {
				ListNode<E> next = cur.next.next;
				remove(cur.next);
				cur = next;
			} else {
				cur = cur.next;
			}
		}
	}
	
	public void removeAllDuplicatedElements() {
		checkSize();
		ListNode<E> cur = head.next;
		Map<E, SingleLinkedList<ListNode<E>>> map = new HashMap<>();
		while(cur != tail) {
			map.putIfAbsent(cur.value, new SingleLinkedList<>());
			map.get(cur.value).addToFront(cur);
			cur = cur.next;
		}
		for(SingleLinkedList<ListNode<E>> sl : map.values()) {
			if(sl.size() > 1) {
				for(ListNode<E> n : sl) {
					remove(n);
				}
			}
		}
		map.clear();
		map = null;
	}

	@Override
	public void mergeSort(Comparator<E> c) {
		if(size <= 1) {
			return;
		}
		ListNode<E> start = head.next;
		head.next = null;
		tail.prev.next = null;
		tail.prev = null;
		ListNode<E> sorted = mergeSort(start, c);
		
		//fix the pointers
		head.next = sorted;
		sorted.prev = head;
		ListNode<E> p = head.next;
		while(p.next != null) {
			p = p.next;
		}
		tail.prev = p;
		p.next = tail;
	}
	
	private ListNode<E> mergeSort(ListNode<E> n, Comparator<E> c) {
		if(n == null || n.next == null) {
			return n;
		}
		ListNode<E> slow = n;
		ListNode<E> fast = n;
		ListNode<E> prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		slow.prev = null;
		
		return merge(mergeSort(n,c), mergeSort(slow,c), c);
	}
	
	private ListNode<E> merge(ListNode<E> l1, ListNode<E> l2, Comparator<E> c) {
		ListNode<E> dummy = new ListNode<>();
		ListNode<E> p = dummy;
		while(l1 != null && l2 != null) {
			if(c.compare(l1.value(), l2.value()) < 0) {
				p.next = l1;
				l1.prev = p;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2.prev = p;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1 != null) {
			p.next = l1;
			l1.prev = p;
		}
		if(l2 != null) {
			p.next = l2;
			l2.prev = p;
		}
		p = dummy.next;
		dummy = null;
		return p;
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
				if(pointer.value() != null) {
					sb.append(pointer.value().toString());
				} else {
					sb.append(pointer.value());
				}
				sb.append("\n");
				pointer = pointer.next();
			}
		}
		return sb.toString();
	}
	
	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(head, tail);
	}

}
