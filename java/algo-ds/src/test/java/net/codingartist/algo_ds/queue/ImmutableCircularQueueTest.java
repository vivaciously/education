package net.codingartist.algo_ds.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.List;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.objects.Pair;


public class ImmutableCircularQueueTest {
	
	@Test
	public void testEnqueueImmutability() {
		ImmutableCircularQueue<Pair<String, String>> pairQueue = new ImmutableCircularQueue<>(1);
		Pair<String, String> p1 = new Pair<>("test", "test2");
		pairQueue.enqueue(p1);
		p1.setFirst("678");
		assertTrue(pairQueue.peek().getFirst().equals("test"));
	}
	
	@Test
	public void testPeekAtImmutability() {
		ImmutableCircularQueue<Pair<String, String>> pairQueue = new ImmutableCircularQueue<>(1);
		Pair<String, String> p1 = new Pair<>("test", "test2");
		pairQueue.enqueue(p1);
		pairQueue.peek().setFirst("678");
		assertTrue(pairQueue.peek().getFirst().equals("test"));
	}
	
	@Test
	public void testPeekAllElementsFromImmutability() {
		ImmutableCircularQueue<Integer> queue = new ImmutableCircularQueue<>();
		for(int i=0; i< 10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		List<Integer> list = queue.peekAllFrom(0);
		assertTrue(queue.size() == 10);
		assertTrue(queue.size() == list.size());
		assertThrows(UnsupportedOperationException.class, 
				() -> list.remove(0));
		for(int i=0; i<10; i++) {
			assertTrue(list.get(i).intValue() == i);
		}
		queue.removeAll();
		queue.enqueue(Integer.valueOf(3));//index 0
		queue.enqueue(Integer.valueOf(4));//index 1
		queue.enqueue(Integer.valueOf(0));//index 2
		queue.enqueue(Integer.valueOf(1));//index 3
		queue.enqueue(Integer.valueOf(2));//index 4
		
		List<Integer> anotherList = queue.peekAllFrom(3);
		assertTrue(anotherList.size() == 5);
		assertTrue(anotherList.get(0).intValue() == 1);
		assertTrue(anotherList.get(1).intValue() == 2);
		assertTrue(anotherList.get(2).intValue() == 3);
		assertTrue(anotherList.get(3).intValue() == 4);
		assertTrue(anotherList.get(4).intValue() == 0);
		
		queue.removeAll();
		queue.enqueue(Integer.valueOf(3));//index 0 -> dequeued
		queue.enqueue(Integer.valueOf(4));//index 1 -> 0
		queue.enqueue(Integer.valueOf(0));//index 2 -> 1
		queue.enqueue(Integer.valueOf(1));//index 3 -> 2
		queue.enqueue(Integer.valueOf(2));//index 4 -> 3
		assertTrue(queue.size() == 5);
		
		assertTrue(queue.dequeue().intValue() == 3);
		List<Integer> yetAnotherImmutableList = queue.peekAllFrom(2);
		assertTrue(yetAnotherImmutableList.size() == 4);
		
		assertTrue(yetAnotherImmutableList.get(0).intValue() == 1);
		assertTrue(yetAnotherImmutableList.get(1).intValue() == 2);
		assertTrue(yetAnotherImmutableList.get(2).intValue() == 4);
		assertTrue(yetAnotherImmutableList.get(3).intValue() == 0);
		
	}
}
