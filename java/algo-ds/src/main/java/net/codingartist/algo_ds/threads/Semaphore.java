package net.codingartist.algo_ds.threads;

public final class Semaphore {

	private volatile boolean avialable = true;
	
	public synchronized void release() {
		this.avialable = true;
		this.notify();
	}
	
	public synchronized void acquire() throws InterruptedException {
		while(!avialable) {
			wait();
		}
		avialable = false;
	}
}
