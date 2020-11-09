package net.codingartist.algo_ds.design;

import java.util.ArrayDeque;
import java.util.Deque;

public class StreamAverageQueue {

	private Deque<Integer> queue = new ArrayDeque<>();
	private int sum = 0;
	private final int capacity;
	
	public StreamAverageQueue(int capacity) {
		this.capacity = capacity;
	}
	
	public double average() {
		return (double)sum/queue.size();
	}
	
	public void add(int n) {
		sum += n;
		queue.offer(n);
        if(queue.size() > capacity) {
            sum -= queue.poll();
        }
	}
}
