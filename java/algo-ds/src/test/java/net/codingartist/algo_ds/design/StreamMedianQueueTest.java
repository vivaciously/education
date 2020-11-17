package net.codingartist.algo_ds.design;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class StreamMedianQueueTest {

	@Test
	public void testStreamMedianQueue() {
		StreamMedianQueue mq = new StreamMedianQueue();
		mq.offer(1);
		mq.offer(2);
		assertEquals(mq.median(), 1.5);
		mq.offer(3);
		assertEquals(mq.median(), 2.0);
		mq.offer(4);
		assertEquals(mq.median(), 2.5);
	}
}
