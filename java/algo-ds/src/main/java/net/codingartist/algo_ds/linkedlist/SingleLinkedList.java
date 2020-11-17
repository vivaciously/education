package net.codingartist.algo_ds.linkedlist;

import java.util.Comparator;


public class SingleLinkedList<E> extends AbstractLinkedList<E> {
	
	public SingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public SingleLinkedList(E value) {
		head = new ListNode<>(value);
		size++;
	}
	
	public SingleLinkedList(Iterable<? extends E> src){
		ListNode<E> p = null;
		for(E data : src){
			if(head == null) { 
				head = new ListNode<>(data);
				p = head;
			} else {
				p.next = new ListNode<>(data);
				p = p.next;
			}
			size++;
		}
	}
	
	public SingleLinkedList(E[] array){
		ListNode<E> p = null;
		for(int i=0;  i<array.length; i++){
			if(head == null) { 
				head = new ListNode<>(array[i]);
				p = head;
			} else {
				p.next = new ListNode<>(array[i]);
				p = p.next;
			}
			size++;
		}
	}
	
	@Override
	public boolean contains(E value) {
		if(head == null) {
			return false;
		}
		ListNode<E> p = head;
		while(p != null) {
			if(p.value.equals(value)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}
	
	@Override
	public E peek() {
		checkSize();
		return head.value;
	}
	
	@Override
	public E peekTail() {
		checkSize();
		ListNode<E> pointer = head;
		while(pointer != null && pointer.next != null) {
			pointer = pointer.next;
		}
		return pointer.value;
	}
	
	@Override
	public E peekAt(int index) {
		if(size() == 0) {
			throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
		}
		
		checkIndex(index);
		ListNode<E> node = head;
		for(int i=0; i<index; i++) {
			node = node.next;
		}
		return node.value;
	}
	
	@Override
	public void clear() {
		head = null;
		size = 0;
	}
	
	@Override
	public void addToFront(E value) {
		checkValue(value);
		if(head == null) {
			head = new ListNode<>(value);
		} else {
			ListNode<E> n = new ListNode<>(value);
			n.next = head;
			head = n;
		}
		size++;
	}
	
	@Override
	public void addToTail(E value) {
		checkValue(value);
		if(head == null) {
			head = new ListNode<>(value);
		} else {
			ListNode<E> pointer = head;
			while(pointer != null && pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = new ListNode<>(value);
		}
		size++;
	}
	
	@Override
	public void insertAt(E value, int index) {
		checkValue(value);
		if(head == null && index == 0) {
			head = new ListNode<>(value);
		} else {
			checkIndex(index);
			ListNode<E> n = head;
			ListNode<E> prev = null;
			for(int i=0; i<index; i++) {
				prev = n;
				n = n.next;
			}
			ListNode<E> node = new ListNode<>(value);
			if(index == 0) {
				node.next = head;
				head = node;
			} else {
				prev.next = node;
				node.next = n;
			}
		}
		size++;
	}
	
	@Override
	public E removeFirst(){
		return removeAt(0);
	}
	
	@Override
	public E removeTail(){
		return removeAt(size -1);
	}
	
	@Override
	public E removeAt(int index){
		checkSize();
		if(index >= size || index < 0) {
			throw new IllegalArgumentException("The given index is out of range. index: " + index + " size:" + size);
		}
		--size;
		E value;
		if(index == 0){
			value = head.value;
			head = head.next;
		}else{
			int counter = 0;
			ListNode<E> cur = head;
			ListNode<E> prev = head;
			while(counter++ != index){
				prev = cur;
				cur = cur.next;
			}
			prev.next = cur.next;
			value = cur.value;
		}
		return value;
	}
	
	@Override
	public boolean remove(E value) {
		checkSize();
		checkValue(value);
		if(head != null) {
			if(head.value.equals(value)) {
				head = head.next;
				size--;
				return true;
			} else {
				ListNode<E> cur = head.next;
				ListNode<E> prev = head;
				while(cur != null) {
					if(cur.value.equals(value)) {
						prev.next = cur.next;
						size--;
						return true;
					}
					prev = cur;
					cur = cur.next;
				}
			}
		}
		return false;
	}
	
	@Override
	public void reverse() {
		ListNode<E> current = head;
		ListNode<E> next = null;
		ListNode<E> prev = null;
		
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	@Override
	public void addAll(Iterable<? extends E> src) {
		ListNode<E> p = head;
		while(p != null && p.next != null) {
			p = p.next;
		}
		for(E data : src) {
			if(p == null) {
				head = new ListNode<>(data);
				p = head;
			} else {
				p.next = new ListNode<>(data);
				p = p.next;
			}
			size++;
		}
	}
	
	@Override
	public void addAll(E[] array) {
		ListNode<E> p = head;
		while(p != null && p.next != null) {
			p = p.next;
		}
		for(int i=0; i<array.length; i++){
			if(p == null) {
				head = new ListNode<>(array[i]);
				p = head;
			} else {
				p.next = new ListNode<>(array[i]);
				p = p.next;
			}
			size++;
		}
	}
	
	public void insertionSort(Comparator<E> c) {
        ListNode<E> cur = head;
        ListNode<E> dummy = new ListNode<>();
        
        while(cur != null) {
            ListNode<E> next = cur.next;
            ListNode<E> p = dummy;
            while(p.next != null && c.compare(p.next.value, cur.value) < 0) { 
                p = p.next; 
            }
            cur.next = p.next;
            p.next = cur;
            cur = next;
        }
        head = dummy.next;
        dummy = null;
    }
	
	@Override
	public void removeDuplicates(Comparator<E> c){
		if(head == null || head.next == null) {
			return;
		}
		head = mergeSort(head, c);
		ListNode<E> cur = head;
		while(cur != null && cur.next != null) {
			if(cur.value.equals(cur.next.value)) {
				cur.next = cur.next.next;
			} else {
				cur = cur.next;
			}
		}
	}
	
	public void bubbleSort(Comparator<E> c) {
        if(head == null || head.next == null) {
            return;
        }
        for(ListNode<E> prev=head; prev != null; prev = prev.next) {
            for(ListNode<E> cur=prev.next; cur != null; cur = cur.next) {
                if(c.compare(cur.value, prev.value) < 0) {
                    E temp = cur.value;
                    cur.value = prev.value;
                    prev.value = temp;
                }
            }
        }
    }
	
	public void mergeSort(Comparator<E> c) {
		head = mergeSort(head, c);
	}
	
	private ListNode<E> mergeSort(ListNode<E> head, Comparator<E> c) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode<E> slow = head;
		ListNode<E> fast = head;
		ListNode<E> prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		return merge(mergeSort(head, c), mergeSort(slow, c), c);
	}
	
	private ListNode<E> merge(ListNode<E> l1, ListNode<E> l2, Comparator<E> c) {
		ListNode<E> dummy = new ListNode<>();
		ListNode<E> p = dummy;
		while(l1 != null && l2 != null) {
			if(c.compare(l1.value, l2.value) < 0) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}
		p = dummy.next;
		dummy = null;
		return p;
	}
	
	
}
