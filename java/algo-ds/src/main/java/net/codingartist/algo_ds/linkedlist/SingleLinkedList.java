package net.codingartist.algo_ds.linkedlist;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;


public class SingleLinkedList<E> implements Iterable<E> {
	protected SListNode<E> head;
	protected int size;
	
	protected void checkIndex(int index) {
		if(index < 0 ){
			throw new IllegalArgumentException("The given index is invalid. index: " + index);
		}else if(index > size){
			throw new IllegalArgumentException("The given index is out of range. index: " + index + " size:" + size);
		}
	}
	
	protected void checkValue(E value) {
		if(value == null) {
			throw new NullPointerException("Given value is null.");
		}
	}
	
	protected void checkSize() {
		if(size == 0) {
			throw new NoSuchElementException("List is empty.");
		}
	}
	
	public SingleLinkedList() {
		head = null;
		size = 0;
	}
	
	public SingleLinkedList(E value) {
		head = new SListNode<>(value);
		size++;
	}
	
	public SingleLinkedList(Iterable<? extends E> src){
		SListNode<E> p = null;
		for(E data : src){
			if(head == null) { 
				head = new SListNode<>(data);
				p = head;
			} else {
				p.next = new SListNode<>(data);
				p = p.next;
			}
			size++;
		}
	}
	
	public SingleLinkedList(E[] array){
		SListNode<E> p = null;
		for(int i=0;  i<array.length; i++){
			if(head == null) { 
				head = new SListNode<>(array[i]);
				p = head;
			} else {
				p.next = new SListNode<>(array[i]);
				p = p.next;
			}
			size++;
		}
	}
	
	public SListNode<E> head() {
		return head;
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean contains(E value) {
		if(head == null) {
			return false;
		}
		SListNode<E> p = head;
		while(p != null) {
			if(p.value.equals(value)) {
				return true;
			}
			p = p.next;
		}
		return false;
	}
	
	public E peek() {
		checkSize();
		return head.value;
	}
	
	public E peekTail() {
		checkSize();
		SListNode<E> pointer = head;
		while(pointer != null && pointer.next != null) {
			pointer = pointer.next;
		}
		return pointer.value;
	}
	
	public E peekAt(int index) {
		if(size() == 0) {
			throw new IndexOutOfBoundsException("index: " + index + " size: " + size);
		}
		
		checkIndex(index);
		SListNode<E> node = head;
		for(int i=0; i<index; i++) {
			node = node.next;
		}
		return node.value;
	}
	
	public void clear() {
		head = null;
		size = 0;
	}
	
	public void addToFront(E value) {
		checkValue(value);
		if(head == null) {
			head = new SListNode<>(value);
		} else {
			SListNode<E> n = new SListNode<>(value);
			n.next = head;
			head = n;
		}
		size++;
	}
	
	public void addToTail(E value) {
		checkValue(value);
		if(head == null) {
			head = new SListNode<>(value);
		} else {
			SListNode<E> pointer = head;
			while(pointer != null && pointer.next != null) {
				pointer = pointer.next;
			}
			pointer.next = new SListNode<>(value);
		}
		size++;
	}
	
	public void insertAt(E value, int index) {
		checkValue(value);
		if(head == null && index == 0) {
			head = new SListNode<>(value);
		} else {
			checkIndex(index);
			SListNode<E> n = head;
			SListNode<E> prev = null;
			for(int i=0; i<index; i++) {
				prev = n;
				n = n.next;
			}
			SListNode<E> node = new SListNode<>(value);
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
	
	public E removeFirst(){
		return removeAt(0);
	}
	
	public E removeTail(){
		return removeAt(size -1);
	}
	
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
			SListNode<E> cur = head;
			SListNode<E> prev = head;
			while(counter++ != index){
				prev = cur;
				cur = cur.next;
			}
			prev.next = cur.next;
			value = cur.value;
		}
		return value;
	}
	
	public boolean remove(E value) {
		checkSize();
		checkValue(value);
		if(head != null) {
			if(head.value.equals(value)) {
				head = head.next;
				size--;
				return true;
			} else {
				SListNode<E> cur = head.next;
				SListNode<E> prev = head;
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
	
	public void reverse() {
		SListNode<E> current = head;
		SListNode<E> next = null;
		SListNode<E> prev = null;
		
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}
	
	
	public void addAll(Iterable<? extends E> src) {
		for(E data : src){
			if(data != null) {
				addToFront(data);
			}
		}
		reverse();
	}
	
	public void addAll(E[] array) {
		for(E data : array) {
			if(data != null) {
				addToFront(data);
			}
		}
		reverse();
	}
	
	public E[] toArray(E[] array){
		if(array.length < size){
			throw new IllegalArgumentException("The lenght of the array is less than the size of the RingArray.");
		}
		Object[] src = new Object[size];
		for(int i=0; i<size; i++){
			src[i] = this.peekAt(i);
		}
		System.arraycopy(src, 0, array, 0, size);
		src = null;
		return array;
	}
	
	public void toCollection(Collection<? super E> dst){
		for(int i=0; i<size; i++){
			dst.add((E)peekAt(i));
		}
	}
	
	public Stream<E> stream() {
		Builder<E> builder = Stream.builder();
		for(E value: this) {
			builder.add(value);
		}
		return builder.build();
	}
	
	@Override
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("size: ");
		sb.append(size);
		sb.append("\n");
		int index = 0;
		SListNode<E> pointer = head;
		while(pointer != null){
			sb.append("index: ");
			sb.append(index++);
			sb.append(" - ");
			sb.append(pointer.value().toString());
			sb.append("\n");
			pointer = pointer.next();
		}
		return sb.toString();
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(head);
	}
	
	public void insertionSort(Comparator<E> c) {
        SListNode<E> cur = head;
        SListNode<E> dummy = new SListNode<>();
        
        while(cur != null) {
            SListNode<E> next = cur.next;
            SListNode<E> p = dummy;
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
	
	public void removeDuplicates(Comparator<E> c){
		if(head == null || head.next == null) {
			return;
		}
		head = mergeSort(head, c);
		SListNode<E> cur = head;
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
        for(SListNode<E> prev=head; prev != null; prev = prev.next) {
            for(SListNode<E> cur=prev.next; cur != null; cur = cur.next) {
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
	
	private SListNode<E> mergeSort(SListNode<E> head, Comparator<E> c) {
		if(head == null || head.next == null) {
			return head;
		}
		SListNode<E> slow = head;
		SListNode<E> fast = head;
		SListNode<E> prev = null;
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;
		return merge(mergeSort(head, c), mergeSort(slow, c), c);
	}
	
	private SListNode<E> merge(SListNode<E> l1, SListNode<E> l2, Comparator<E> c) {
		SListNode<E> dummy = new SListNode<>();
		SListNode<E> p = dummy;
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
