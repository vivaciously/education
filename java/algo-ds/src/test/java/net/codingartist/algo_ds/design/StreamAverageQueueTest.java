package net.codingartist.algo_ds.design;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;

public class StreamAverageQueueTest {

	@Test
	public void testStreamAverageQueue() {
		StreamAverageQueue saq = new StreamAverageQueue(3);
		saq.offer(1);
		assertEquals(saq.average(), 1.0);
		saq.offer(2);
		assertEquals(saq.average(), 1.5);
		saq.offer(3);
		assertEquals(saq.average(), 2.0);
		saq.offer(4);
		assertEquals(saq.average(), 3.0);
		saq.clear();
		saq.offer(3);
		assertEquals(saq.average(), 3.0);
		saq.clear();
		assertThrows(EmptyDataStructureException.class, () -> {
			saq.average();
		});
		
	}
}
