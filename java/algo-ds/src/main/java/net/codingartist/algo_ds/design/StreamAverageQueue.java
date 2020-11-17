package net.codingartist.algo_ds.design;

import java.util.ArrayDeque;
import java.util.Deque;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;

public class StreamAverageQueue {

	private Deque<Integer> queue = new ArrayDeque<>();
	private int sum = 0;
	private final int windowSize;
	
	public StreamAverageQueue(int windowSize) {
		this.windowSize = windowSize;
	}
	
	public double average() {
		if(queue.size() == 0) {
			throw new EmptyDataStructureException("StreamAverageQueue is empty");
		}
		return (double)sum/queue.size();
	}
	
	public int windowSize() {
		return windowSize;
	}
	
	public void offer(int n) {
		sum += n;
		queue.offer(n);
        if(queue.size() > windowSize) {
            sum -= queue.poll();
        }
	}
	
	public void clear() {
		sum = 0;
		queue.clear();
	}
}
