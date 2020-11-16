package net.codingartist.algo_ds.linkedlist;

import java.util.Comparator;

public class ListNodeUtils {

	private ListNodeUtils() {
		throw new AssertionError("no instaintiability");
	}
	
	public static <E> SListNode<E> removeDuplicates(SListNode<E> head, Comparator<E> c){
		if(head == null || head.next == null) {
			return head;
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
		return head;
	}
	
	public static <E> SListNode<E> bubbleSort(SListNode<E> head, Comparator<E> c) {
        if(head == null || head.next == null) {
            return head;
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
        return head;
    }
	
	public static <E> SListNode<E> insertionSort(SListNode<E> head, Comparator<E> c) {
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
        return dummy.next;
    }
	
	public static <E> SListNode<E> mergeSort(SListNode<E> head, Comparator<E> c) {
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
	
	public static <E> SListNode<E> merge(SListNode<E> l1, SListNode<E> l2, Comparator<E> c) {
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
		}
		if(l1 != null) {
			p.next = l1;
		}
		if(l2 != null) {
			p.next = l2;
		}
		return dummy.next;
	}
	
}
