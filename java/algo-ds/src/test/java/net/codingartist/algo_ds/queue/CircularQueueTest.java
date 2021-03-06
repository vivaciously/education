package net.codingartist.algo_ds.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.function.UnaryOperator;

import net.codingartist.algo_ds.exceptions.EmptyDataStructureException;

public class CircularQueueTest {

	protected CircularQueue<Integer> queue;
	
	@BeforeEach
	void init() {
		queue = new CircularQueue<>();
	}
	
	@AfterEach
	void tearDown() {
		queue = null;
	}
	
	@Test
	public void testFrom() {
		List<Integer> list = IntStream.range(1, 11).boxed().collect(Collectors.toList());
		CircularQueue<Integer> queue = CircularQueue.from(list);
		assertTrue(queue.stream().reduce(0, (i, j) -> i + j) == 55);
	}
	
	@Test
	public void testIntStream() {
		IntStream.range(1, 11).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		IntStream intStream = queue.intStream(0, UnaryOperator.identity());
		assertTrue(intStream.sum() == 55);
	}
	
	@Test
	public void testLongStream() {
		IntStream.range(1, 11).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		LongStream longStream = queue.longStream(0, (i) -> Long.valueOf((long)i));
		assertTrue(longStream.sum() == 55);
	}
	
	@Test
	public void testDoubleStream() {
		IntStream.range(1, 11).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		DoubleStream ds = queue.doubleStream(0, (i) -> Double.valueOf((double)i));
		assertTrue(ds.sum() == 55.0);
	}
	
	@Test
	public void testClear() {
		IntStream.range(0, 10).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		assertTrue(queue.size() == 10);
		assertTrue(queue.isFull());
		queue.clear();
		assertTrue(queue.size() == 0);
		assertTrue(queue.capacity() == 10);
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testStreamWithoutIndex() {
		for(int i=0; i<10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		List<Integer> evenNumbers = queue.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
		assertTrue(evenNumbers.size() == 5);
		for(Integer value : evenNumbers) {
			assertTrue(value % 2 == 0);
		}
		assertTrue(queue.size() == 10);
		for(int i=0; i<10; i++) {
			assertTrue(queue.peekAt(i).intValue() == i);
		}
	}
	
	@Test
	public void testStreamWithIndex() {
		for(int i=0; i<10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		List<Integer> oddNumbers = queue.stream(5).filter(n -> n % 2 != 0).collect(Collectors.toList());
		assertTrue(oddNumbers.size() == 5);
		assertTrue(oddNumbers.get(0).intValue() == 5);
		assertTrue(oddNumbers.get(1).intValue() == 7);
		assertTrue(oddNumbers.get(2).intValue() == 9);
		assertTrue(oddNumbers.get(3).intValue() == 1);
		assertTrue(oddNumbers.get(4).intValue() == 3);
		assertTrue(queue.size() == 10);
		for(int i=0; i<10; i++) {
			assertTrue(queue.peekAt(i).intValue() == i);
		}
	}
	
	@Test
	public void testRemoveAllElementsFrom() {
		for(int i=0; i< 10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		List<Integer> list = queue.removeAllFrom(0);
		assertTrue(queue.size() == 0);
		assertTrue(list.size() == 10);
		for(int i=0; i<10; i++) {
			assertTrue(list.get(i).intValue() == i);
		}
		queue.removeAll();
		queue.enqueue(Integer.valueOf(3));//index 0
		queue.enqueue(Integer.valueOf(4));//index 1
		queue.enqueue(Integer.valueOf(0));//index 2
		queue.enqueue(Integer.valueOf(1));//index 3
		queue.enqueue(Integer.valueOf(2));//index 4
		
		List<Integer> anotherList = queue.removeAllFrom(3);
		assertTrue(anotherList.size() == 5);
		assertTrue(anotherList.get(0).intValue() == 1);
		assertTrue(anotherList.get(1).intValue() == 2);
		assertTrue(anotherList.get(2).intValue() == 3);
		assertTrue(anotherList.get(3).intValue() == 4);
		assertTrue(anotherList.get(4).intValue() == 0);
		assertTrue(queue.size() == 0);
		
		queue.removeAll();
		queue.enqueue(Integer.valueOf(3));//index 0 -> dequeued
		queue.enqueue(Integer.valueOf(4));//index 1 -> 0
		queue.enqueue(Integer.valueOf(0));//index 2 -> 1
		queue.enqueue(Integer.valueOf(1));//index 3 -> 2
		queue.enqueue(Integer.valueOf(2));//index 4 -> 3
		
		assertTrue(queue.dequeue().intValue() == 3);
		List<Integer> yetAnotherList = queue.removeAllFrom(2);
		assertTrue(queue.size() == 0);
		assertTrue(yetAnotherList.size() == 4);
		
		assertTrue(yetAnotherList.get(0).intValue() == 1);
		assertTrue(yetAnotherList.get(1).intValue() == 2);
		assertTrue(yetAnotherList.get(2).intValue() == 4);
		assertTrue(yetAnotherList.get(3).intValue() == 0);
	}
	
	@Test
	public void testPeekAllElementsFrom() {
		for(int i=0; i< 10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		List<Integer> list = queue.peekAllFrom(0);
		assertTrue(queue.size() == 10);
		assertTrue(queue.size() == list.size());
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
		List<Integer> yetAnotherList = queue.peekAllFrom(2);
		assertTrue(yetAnotherList.size() == 4);
		
		assertTrue(yetAnotherList.get(0).intValue() == 1);
		assertTrue(yetAnotherList.get(1).intValue() == 2);
		assertTrue(yetAnotherList.get(2).intValue() == 4);
		assertTrue(yetAnotherList.get(3).intValue() == 0);
		
	}
	
	@Test
	public void testPeekAt() {
		for(int i=0; i< 10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		assertTrue(queue.size() == 10);
		for(int i=0; i<queue.size(); i++) {
			assertTrue(queue.peekAt(i).intValue() == i);
		}
		queue.removeAll();
		assertTrue(queue.size() == 0);
		queue.enqueue(Integer.valueOf(3));//index 0
		queue.enqueue(Integer.valueOf(4));//index 1
		queue.enqueue(Integer.valueOf(0));//index 2
		queue.enqueue(Integer.valueOf(1));//index 3
		queue.enqueue(Integer.valueOf(2));//index 4
		assertTrue(queue.size() == 5);
		assertTrue(queue.peekAt(2).intValue() == 0);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			queue.peekAt(-1);
		 });
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			queue.peekAt(11);
		 });
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			queue.peekAt(10);
		 });
		
		assertTrue(queue.peekAt(4).intValue() == 2);
		assertTrue(queue.peekAt(1).intValue() == 4);
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			queue.peekAt(5);
		 });
	}
	
	
	@Test
	public void testCapacity() {
		assertTrue(queue.capacity() == 10);
	}
	
	@Test
	public void removeAllToListTest() {
		for(int i=0; i< 10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		assertTrue(queue.size() == 10);
		List<Integer> list = queue.removeAllToList();
		assertTrue(queue.size() == 0);
		assertTrue(queue.capacity() == 10);
		assertTrue(list.size() == 10);
		for(int i=0; i< 10; i++) {
			assertTrue(list.get(i).intValue() == i);
		}
		list.clear();
		
		for(int i=10; i>0; i--) {
			queue.enqueue(Integer.valueOf(i));
		}
		assertTrue(queue.size() == 10);
		assertTrue(queue.capacity() == 10);
		list = queue.removeAllToList();
		assertTrue(list.size() == 10);
		for(int i=0; i<10; i++) {
			assertTrue(list.get(i).intValue() == 10 -i);
		}
	}
	
	@Test
	public void testIsFull() {
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		assertTrue(queue.isFull());
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, 
				() -> queue.enqueue(1), "The CircularQueue is Full.");
		assertEquals(thrown.getMessage(), "The CircularQueue is Full.");
	}
	
	@Test
	public void testRemoveAll() {
		queue.enqueue(5);
		assertTrue(queue.peek().intValue() == 5);
		queue.enqueue(8);
		queue.enqueue(7);
		assertTrue(queue.size() == 3);
		queue.removeAll();
		assertTrue(queue.size() == 0);
	}
	
	@Test
	public void testPeek() {
		Assertions.assertThrows(EmptyDataStructureException.class, () -> {
			queue.peek();
		 });
		queue.enqueue(2);
		assertTrue(queue.peek().intValue() == 2);
		assertTrue(queue.dequeue().intValue() == 2);
		queue.enqueue(0);
		assertTrue(queue.peek().intValue() == 0);
		assertTrue(queue.peek().intValue() == 0);
		queue.enqueue(2);
		assertTrue(queue.peek().intValue() == 0);
		assertTrue(queue.peek().intValue() == 0);
		queue.dequeue();
		assertTrue(queue.peek().intValue() == 2);
	}
	
	@Test
	public void testDequeue() {
		queue.enqueue(Integer.valueOf(3));//index 0
		queue.enqueue(Integer.valueOf(4));//index 1
		queue.enqueue(Integer.valueOf(0));//index 2
		queue.enqueue(Integer.valueOf(1));//index 3
		queue.enqueue(Integer.valueOf(2));//index 4
		assertTrue(queue.size() == 5);
		
		assertTrue(queue.dequeue().intValue() == 3);
		assertTrue(queue.size() == 4);
		assertTrue(queue.dequeue().intValue() == 4);
		assertTrue(queue.size() == 3);
		assertTrue(queue.dequeue().intValue() == 0);
		assertTrue(queue.size() == 2);
		assertTrue(queue.dequeue().intValue() == 1);
		assertTrue(queue.size() == 1);
		assertTrue(queue.dequeue().intValue() == 2);
		assertTrue(queue.size() == 0);
		
		queue.enqueue(Integer.valueOf(5));
		assertTrue(queue.size() == 1);
		queue.enqueue(Integer.valueOf(3));
		assertTrue(queue.size() == 2);
		
		assertTrue(queue.dequeue().intValue() == 5);
		assertTrue(queue.size() == 1);
		assertTrue(queue.dequeue().intValue() == 3);
		assertTrue(queue.size() == 0);
		
		
		queue.enqueue(Integer.valueOf(0));
		assertTrue(queue.size() == 1);
		queue.enqueue(Integer.valueOf(1));
		assertTrue(queue.size() == 2);
		queue.enqueue(Integer.valueOf(2)); //hit the capacity
		assertTrue(queue.size() == 3);
		queue.enqueue(Integer.valueOf(3));
		assertTrue(queue.size() == 4);
		
		assertTrue(queue.dequeue().intValue() == 0);
		assertTrue(queue.size() == 3);
		assertTrue(queue.dequeue().intValue() == 1);
		assertTrue(queue.size() == 2);
		
		assertTrue(queue.dequeue().intValue() == 2);
		assertTrue(queue.size() == 1);
		
		assertTrue(queue.dequeue().intValue() == 3);
		assertTrue(queue.size() == 0);
		
		queue.enqueue(Integer.valueOf(0));
		assertTrue(queue.size() == 1);
		queue.enqueue(Integer.valueOf(1));
		assertTrue(queue.size() == 2);
		
		assertTrue(queue.size() == 2);
		assertTrue(queue.dequeue().intValue() == 0);
		assertTrue(queue.size() == 1);
		
		assertTrue(queue.dequeue().intValue() == 1);
		assertTrue(queue.size() == 0);
		
	}
	
	@Test
	public void testIsEmpty() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			queue.enqueue(null);
		 });
		
		assertTrue(queue.isEmpty());
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void testSize() {
		assertTrue(queue.size() == 0);
		queue.enqueue(1);
		assertTrue(queue.size() == 1);
		queue.enqueue(2);
		assertTrue(queue.size() == 2);
		queue.dequeue();
		assertTrue(queue.size() == 1);
		queue.dequeue();
		assertTrue(queue.size() == 0);
	}
}
