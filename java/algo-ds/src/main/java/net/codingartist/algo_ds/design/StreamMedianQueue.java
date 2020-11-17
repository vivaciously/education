package net.codingartist.algo_ds.design;

import java.util.Collections;
import java.util.PriorityQueue;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;

public class StreamMedianQueue {

	protected PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
	protected PriorityQueue<Integer> right = new PriorityQueue<>();
	
	public void offer(int n) {
		left.offer(n);
		right.offer(left.poll());
		if(left.size() < right.size()) {
			left.offer(right.poll());
		}
	}
	
	public int size() {
		return left.size() + right.size();
	}
	
	public void clear() {
		left.clear();
		right.clear();
	}
	
	public boolean remove(int n) {
		return left.remove(n) || right.remove(n);
	}
	
	public double median() {
		if(size() == 0) {
			throw new EmptyDataStructureException("StreamMedianQueue is empty");
		}
		if((size() & 1) == 0) {
			return (double)(left.peek() + (long)right.peek()) * 0.5;
		} else {
			return (double)left.peek();
		}
	}
}
