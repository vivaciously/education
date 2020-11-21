package net.codingartist.algo_ds.queue;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;
import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class QueueTest {
	
	protected Queue<Integer> queue;

	@Test
	public void testDefaultConstructor() {
		queue = new Queue<>();
		assertTrue(queue.size() == 0);
		assertTrue(queue.isEmpty());
		assertThrows(EmptyDataStructureException.class, () -> {
			queue.dequeue();
		});
	}
	
	@Test
	public void testConstructorWithInterable() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue = new Queue<>(testCase);
		assertTrue(queue.size() == 10);
		assertTrue(queue.peekLast() == 9);
		assertTrue(queue.peek() == 1);
		assertTrue(queue.size() == 10);
		int size = queue.size();
		for(int i=0; i<size; i++) {
			assertEquals(queue.dequeue(), testCase.get(i));
		}
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testConstructorWithArray() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		queue = new Queue<>(testCase);
		assertTrue(queue.size() == 10);
		assertTrue(queue.peekLast() == 9);
		assertTrue(queue.peek() == 1);
		assertTrue(queue.size() == 10);
		int size = queue.size();
		for(int i=0; i<size; i++) {
			assertEquals(queue.dequeue(), testCase[i]);
		}
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testSize() {
		queue = new Queue<>();
		assertTrue(queue.size() == 0);
		queue.enqueue(1);
		assertTrue(queue.size() == 1);
		queue.enqueue(2);
		assertTrue(queue.size() == 2);
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue.enqueueAll(testCase);
		assertTrue(queue.dequeue() == 1);
		assertTrue(queue.dequeue() == 2);
		assertTrue(queue.size() == testCase.size());
		for(int i=0; i< testCase.size(); i++) {
			assertEquals(queue.dequeue(), testCase.get(i));
		}
	}
	
	@Test
	public void testIsEmpty() {
		queue = new Queue<>();
		assertTrue(queue.isEmpty());
		queue.enqueue(47);
		assertFalse(queue.isEmpty());
		assertTrue(queue.dequeue() == 47);
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testClear() {
		queue = new Queue<>();
		assertDoesNotThrow(() -> {
			queue.clear();
		});
		assertTrue(queue.size() == 0);
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue.enqueueAll(testCase);
		assertTrue(queue.size() == 10);
		queue.clear();
		assertTrue(queue.size() == 0);
	}
	
	@Test
	public void testPeek() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue = new Queue<>(testCase);
		assertEquals(queue.peek(), 1);
		queue.dequeue();
		assertEquals(queue.peek(), 3);
		queue.dequeue();
		assertEquals(queue.peek(), 5);
		queue.clear();
		assertThrows(EmptyDataStructureException.class, () -> {
			queue.peek();
		});
	}
	
	@Test
	public void testPeekLast() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,9]");
		queue = new Queue<>(testCase);
		assertEquals(queue.peekLast(), 9);
		queue.dequeue();
		assertEquals(queue.peekLast(), 9);
		queue.dequeue();
		assertEquals(queue.peekLast(), 9);
		queue.dequeue();
		assertEquals(queue.peekLast(), 9);
		queue.dequeue();
		assertThrows(EmptyDataStructureException.class, () -> {
			queue.peek();
		});
	}
	
	@Test
	public void testEnqueue() {
		queue = new Queue<>();
		for(int i=0; i<10; i++) {
			queue.enqueue(i);
		}
		assertTrue(queue.size() == 10);
		for(int i=0; i<10; i++) {
			assertEquals(queue.dequeue(), i);
		}
	}
	
	@Test
	public void testEnqueueAllWithIterable() {
		queue = new Queue<>();
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue.enqueueAll(testCase);
		queue.enqueueAll(testCase);
		for(int i=0; i<testCase.size() * 2; i++) {
			assertEquals(queue.dequeue(), testCase.get(i % testCase.size()));
		}
	}
	
	@Test
	public void testEnqueueAllWithArray() {
		queue = new Queue<>();
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		queue.enqueueAll(testCase);
		queue.enqueueAll(testCase);
		for(int i=0; i<testCase.length * 2; i++) {
			assertEquals(queue.dequeue(), testCase[i % testCase.length]);
		}
	}
	
	@Test
	public void testDequeue() {
		queue = new Queue<>();
		assertThrows(EmptyDataStructureException.class, () -> {
			queue.dequeue();
		});
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		queue.enqueueAll(testCase);
		assertTrue(queue.size() == 10);
		assertTrue(queue.peekLast() == 9);
		assertTrue(queue.peek() == 1);
		assertTrue(queue.size() == 10);
		int size = queue.size();
		for(int i=0; i<size; i++) {
			assertEquals(queue.dequeue(), testCase[i]);
		}
		assertTrue(queue.isEmpty());
	}

	@Test
	public void testIterator() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue = new Queue<>(testCase);
		Iterator<Integer> itr = queue.iterator();
		int i = 0;
		while(itr.hasNext()) {
			assertEquals(itr.next(), testCase.get(i++));
		}
		assertThrows(NoSuchElementException.class, () -> {
			itr.next();
		});
	}
	
	@Test
	public void testToArray() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue = new Queue<>(testCase);
		Integer[] results = new Integer[testCase.size()];
		queue.toArray(results);
		for(int i=0; i<testCase.size(); i++) {
			assertEquals(results[i], testCase.get(i));
		}
	}
	
	@Test
	public void testToCollection(){
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue = new Queue<>(testCase);
		Set<Integer> set = new HashSet<>();
		queue.toCollection(set);
		for(int n : testCase) {
			assertTrue(set.contains(n));
		}
	}

	@Test
	public void testStream() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		queue = new Queue<>(testCase);
		assertEquals(queue.stream().count(), testCase.stream().count());
	}
}
