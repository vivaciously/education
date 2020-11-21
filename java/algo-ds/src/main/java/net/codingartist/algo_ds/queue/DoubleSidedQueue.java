package net.codingartist.algo_ds.queue;

public class DoubleSidedQueue<E> extends Queue<E> {
	
	public DoubleSidedQueue() {
		super();
	}
	
	public DoubleSidedQueue(Iterable<? extends E> src) {
		super(src);
	}
	
	public DoubleSidedQueue(E[] array) {
		super(array);
	}
	
	public E dequeueLast() {
		checkSize();
		return list.removeTail();
	}
	
}
