package net.codingartist.algo_ds.design;


import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	
	private static class ListNode<K,V> {
		protected K key;
		protected V value;
		protected ListNode<K,V> next;
		protected ListNode<K,V> prev;
		
		ListNode(K key, V value) {
			this.key = key;
			this.value = value;
			this.next = null;
			this.prev = null;
		}
		
		ListNode() {
			this.key = null;
			this.value = null;
			this.next = null;
			this.prev = null;
		}
		
	}
	
	private ListNode<K,V> head;
	private ListNode<K,V> tail;
	private final int capacity;
	private Map<K,ListNode<K,V>> cache = new HashMap<>();
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		head = new ListNode<>();
		tail = new ListNode<>();
		head.next = tail;
		tail.prev = head;
	}
	
	public int size() {
		return cache.size();
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public V get(K key) {
		ListNode<K,V> n = cache.get(key);
		if(n != null) {
			this.moveToFront(n);
			return n.value;
		}
		return null;
	}
	
	public void put(K key, V value) {
		if(cache.containsKey(key)) {
			ListNode<K,V> n = cache.get(key);
			n.value = value;
			cache.put(key, n);
			this.moveToFront(n);
		} else {
			ListNode<K,V> n = new ListNode<>(key, value);
			if(cache.size() < capacity) {
				this.addToFront(n);
				cache.put(key, n);
			} else {
				ListNode<K,V> deleted = this.popTail();
				cache.remove(deleted.key);
				this.addToFront(n);
				cache.put(key, n);
			}
		}
	}
	
	private void moveToFront(ListNode<K,V>  n) {
		this.removeNode(n);
		this.addToFront(n);
	}
	
	private void addToFront(ListNode<K,V>  n) {
		head.next.prev = n;
		n.prev = head;
		
		n.next = head.next;
		head.next = n;
	}
	
	private void removeNode(ListNode<K,V> n) {
		ListNode<K,V>  prev = n.prev;
		ListNode<K,V>  next = n.next;
		prev.next = next;
		next.prev = prev;
	}
	
	@SuppressWarnings("unused")
	private void removeNode(K key) {
		ListNode<K,V> n = cache.get(key);
		if(n != null) {
			removeNode(n);
		}
	}
	
	private ListNode<K,V> popTail() {
		ListNode<K,V> n = tail.prev;
		removeNode(n);
		return n;
	}
	
}

