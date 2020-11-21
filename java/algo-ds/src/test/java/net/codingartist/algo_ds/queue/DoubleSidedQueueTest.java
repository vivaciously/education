package net.codingartist.algo_ds.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;
import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class DoubleSidedQueueTest {

	protected DoubleSidedQueue<Integer> dq;
	
	@Test
	public void testDequeLast() {
		dq = new DoubleSidedQueue<>();
		assertThrows(EmptyDataStructureException.class, () -> {
			dq.dequeueLast();
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		dq.enqueueAll(testCase);
		assertTrue(dq.dequeue() == 1);
		assertTrue(dq.dequeueLast() == 9);
		assertTrue(dq.size() == 8);
		assertTrue(dq.peekLast() == 6);
		assertTrue(dq.dequeueLast() == 6);
		assertTrue(dq.dequeueLast() == 24);
		assertTrue(dq.dequeueLast() == 78);
		assertTrue(dq.dequeue() == 3);
		assertTrue(dq.dequeue() == 5);
		assertTrue(dq.dequeueLast() == 6);
		assertTrue(dq.dequeueLast() == 34);
		assertTrue(dq.dequeueLast() == 2);
		assertThrows(EmptyDataStructureException.class, () -> {
			dq.dequeueLast();
		});
		assertThrows(EmptyDataStructureException.class, () -> {
			dq.dequeue();
		});
	}
}
