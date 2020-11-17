package net.codingartist.algo_ds.design;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;


public class StreamMedianQueueTest {

	@Test
	public void testStreamMedianQueue() {
		StreamMedianQueue mq = new StreamMedianQueue();
		mq.offer(1);
		mq.offer(2);
		assertEquals(mq.median(), 1.5);
		assertEquals(mq.size(), 2);
		mq.offer(3);
		assertEquals(mq.median(), 2.0);
		mq.offer(4);
		assertEquals(mq.median(), 2.5);
		mq.remove(4);
		assertEquals(mq.median(), 2.0);
		mq.clear();
		assertTrue(mq.size() == 0);
		assertThrows(EmptyDataStructureException.class, () -> {
			mq.median();
		});
	}
}
