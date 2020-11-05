package net.codingartist.algo_ds.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class CircularQueue<T> {

	private static final int DEFUALT_CAPACITY = 10;
	private final int capacity;
	private Object[] elements;
	private int insertIndex = 0;
	private int removeIndex = 0;
	private int size = 0;
	
	public CircularQueue(int capacity) {
		this.capacity = Math.max(capacity, 2);
		elements = new Object[capacity];
	}
	
	public CircularQueue() {
		this.capacity = DEFUALT_CAPACITY;
		elements = new Object[capacity];
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == capacity;
	}
	
	public int size() {
		return size;
	}
	
	public int capacity() {
		return this.capacity;
	}
	
	public void clear() {
		for(int i = insertIndex = removeIndex = size =0; i<capacity; i++) {
			elements[i] = null;
		}
	}
	
	public T dequeue() {
		if(this.size == 0) {
			throw new EmptyQueueException("The queue is empty.");
		}
		int index = removeIndex % capacity;
		@SuppressWarnings("unchecked")
		T val = (T)elements[index];
		elements[index] = null;
		removeIndex = (removeIndex + 1 ) % capacity;
		--size;
		return val;
		
	}
	
	public List<T> removeAllToList() {
		List<T> list =  new ArrayList<>();
		while(this.size > 0) {
			list.add(this.dequeue());
		}
		return list;
	}
	
	public void removeAll() {
		for (int to = size, i = size = removeIndex = insertIndex = 0; i < to; i++) {
			elements[i] = null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public T peekAt(int index) {
		if(index >= size || index < 0 || index > capacity) {
			throw new IllegalArgumentException("Given index is invalid. index: " + index);
		}
		var peekIndex = (removeIndex + index) % capacity;
		//TODO cloned copy to enforce immutability;
		return (T)elements[peekIndex];
	}
	
	@SuppressWarnings("unchecked")
	public T peek() {
		if(size == 0) {
			throw new EmptyQueueException("The queue is empty.");
		}
		//TODO cloned copy to enforce immutability;
		return (T)elements[removeIndex % capacity];
	}
	
	@SuppressWarnings("unchecked")
	public List<T> peekAllFrom(int startIndex) {
		if(startIndex >= size || startIndex < 0 || startIndex > capacity) {
			throw new IllegalArgumentException("Given index is invalid. startIndex: " + startIndex);
		}
		List<T> tempList = new ArrayList<>();
		for(int i=0; i <capacity; i++) {
			int peekIndex = (removeIndex + startIndex + i) % capacity;
			var element = (T)elements[peekIndex];
			if(element != null) {
				tempList.add((T)element);
			}
		}
		//return an immutable list 
		return List.of((T[])(tempList.toArray()));
	}
	
	public List<T> removeAllFrom(int startIndex) {
		if(startIndex >= size || startIndex < 0 || startIndex > capacity) {
			throw new IllegalArgumentException("Given index is invalid. startIndex: " + startIndex);
		}
		var list = new ArrayList<T>();
		for(int i=0; i <capacity; i++) {
			int peekIndex = (removeIndex + startIndex + i) % capacity;
			@SuppressWarnings("unchecked")
			var element = (T)elements[peekIndex];
			if(element != null) {
				list.add((T)element);
				elements[peekIndex] = null;
			}
		}
		this.insertIndex = 0;
		this.removeIndex = 0;
		this.size = 0;
		return list;
	}
	
	
	public void enqueue(T element) {
		if(element == null) {
			throw new NullPointerException("The element passsed to enqueue is null");
		}
		if(size < capacity) {
			size++;
			int index = insertIndex % capacity;
			elements[index] = element;
			insertIndex = (insertIndex + 1) % capacity;
		} else {
			throw new IllegalArgumentException("The CircularQueue is Full.");
		}
	}
	
	public Stream<T> stream() {
		Builder<T> builder = Stream.builder();
		List<T> immutableList = this.peekAllFrom(0);
		for(T value: immutableList) {
			builder.add(value);
		}
		return builder.build();
	}
	
	public Stream<T> stream(int index) {
		Builder<T> builder = Stream.builder();
		List<T> immutableList = this.peekAllFrom(index);
		for(T value: immutableList) {
			builder.add(value);
		}
		return builder.build();
	}
	
	public IntStream intStream(int index, Function<? super T, Integer> mapper) {
		IntStream.Builder builder = IntStream.builder();
		List<T> immutableList = this.peekAllFrom(index);
		for(T value: immutableList) {
			builder.add(mapper.apply(value));
		}
		return builder.build();
	}
	
	public LongStream longStream(int index, Function<? super T, Long> mapper) {
		LongStream.Builder builder = LongStream.builder();
		List<T> immutableList = this.peekAllFrom(index);
		for(T value: immutableList) {
			builder.add(mapper.apply(value));
		}
		return builder.build();
	}
	
	public DoubleStream doubleStream(int index, Function<? super T, Double> mapper) {
		DoubleStream.Builder builder = DoubleStream.builder();
		List<T> immutableList = this.peekAllFrom(index);
		for(T value: immutableList) {
			builder.add(mapper.apply(value));
		}
		return builder.build();
	}
	
	
	
	//static methods
	public static <T> CircularQueue<T> from(Collection<? extends T> c) {
		if(c == null) throw new IllegalArgumentException("The collection is null.");
		var queue = new CircularQueue<T>(c.size());
		for(T item : c) {
			if (item != null) {
				queue.enqueue(item);
			}
		}
		return queue;
	}
	
	public static <T> CircularQueue<T> from(T[] array) {
		return from(Arrays.asList(array));
	}
}
