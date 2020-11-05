package net.codingartist.algo_ds.queue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import net.codingartist.algo_ds.utils.AlgoDSUtils;

public class ImmutableCircularQueue<E extends Serializable> extends CircularQueue<E> {

	public ImmutableCircularQueue(int capacity) {
		super(capacity);
	}
	
	public ImmutableCircularQueue() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public E peek() {
		E val = super.peek();
		return (E)AlgoDSUtils.deepCopy(val);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void enqueue(E element) {
		if(element == null) {
			throw new NullPointerException("The element passsed to enqueue is null");
		}
		if(size < capacity) {
			size++;
			int index = insertIndex % capacity;
			elements[index] = (E)AlgoDSUtils.deepCopy(element);
			insertIndex = (insertIndex + 1) % capacity;
		} else {
			throw new IllegalArgumentException("The CircularQueue is Full.");
		}
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<E> peekAllFrom(int startIndex) {
		if(startIndex >= size || startIndex < 0 || startIndex > capacity) {
			throw new IllegalArgumentException("Given index is invalid. startIndex: " + startIndex);
		}
		List<E> results = new ArrayList<>();
		for(int i=0; i <capacity; i++) {
			int peekIndex = (removeIndex + startIndex + i) % capacity;
			var element = (E)elements[peekIndex];
			if(element != null) {
				results.add((E)element);
			}
		}
		return List.of(results.toArray((E[])new Serializable[] {}));
	}

	
	//static methods
	public static <T extends Serializable> ImmutableCircularQueue<T> from(Collection<? extends T> c, Class<T> typeDefiner) {
		if(c == null) throw new IllegalArgumentException("The collection is null.");
		var queue = new ImmutableCircularQueue<T>(c.size());
		for(T item : c) {
			if (item != null) {
				queue.enqueue(item);
			}
		}
		return queue;
	}
	
	public static <T extends Serializable> ImmutableCircularQueue<T> from(T[] array) {
		return from(Arrays.asList(array), null);
	}


}
