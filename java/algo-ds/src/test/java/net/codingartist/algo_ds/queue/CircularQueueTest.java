package net.codingartist.algo_ds.queue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.DoubleStream;
import java.util.function.UnaryOperator;

public class CircularQueueTest extends TestCase {

	protected CircularQueue<Integer> queue;
	public CircularQueueTest(String testName){
		super(testName);
		setup();
	}
	
	public static Test suite(){
	    return new TestSuite( CircularQueueTest.class );
	}
	
	public void setup(){
		queue = new CircularQueue<>();
	}
	
	public void testFrom() {
		List<Integer> list = IntStream.range(1, 11).boxed().collect(Collectors.toList());
		CircularQueue<Integer> queue = CircularQueue.from(list);
		assertTrue(queue.stream().reduce(0, (i, j) -> i + j) == 55);
	}
	
	public void testIntStream() {
		IntStream.range(1, 11).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		IntStream intStream = queue.intStream(0, UnaryOperator.identity());
		assertTrue(intStream.sum() == 55);
	}
	
	public void testLongStream() {
		IntStream.range(1, 11).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		LongStream longStream = queue.longStream(0, (i) -> Long.valueOf((long)i));
		assertTrue(longStream.sum() == 55);
	}
	
	public void testDoubleStream() {
		IntStream.range(1, 11).forEach((i) -> {
			queue.enqueue(Integer.valueOf(i));
		});
		DoubleStream ds = queue.doubleStream(0, (i) -> Double.valueOf((double)i));
		assertTrue(ds.sum() == 55.0);
	}
	
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
	
	public void testPeekAllElementsFrom() {
		for(int i=0; i< 10; i++) {
			queue.enqueue(Integer.valueOf(i));
		}
		List<Integer> immutableList = queue.peekAllFrom(0);
		assertTrue(queue.size() == 10);
		assertTrue(queue.size() == immutableList.size());
		assertThrows(UnsupportedOperationException.class, 
				() -> immutableList.remove(0));
		for(int i=0; i<10; i++) {
			assertTrue(immutableList.get(i).intValue() == i);
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
		assertTrue(queue.peekAt(-1) == null);
		assertTrue(queue.peekAt(11) == null);
		assertTrue(queue.peekAt(10) == null);
		assertTrue(queue.peekAt(4).intValue() == 2);
		assertTrue(queue.peekAt(1).intValue() == 4);
		assertTrue(queue.peekAt(5) == null);
	}
	
	public void testCapacity() {
		assertTrue(queue.capacity() == 10);
	}
	
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
		for(int i=10; i>0; i--) {
			assertTrue(list.get(i).intValue() == i);
		}
	}
	
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
	
	public void testRemoveAll() {
		queue.enqueue(5);
		assertTrue(queue.peek().intValue() == 5);
		queue.enqueue(8);
		queue.enqueue(7);
		assertTrue(queue.size() == 3);
		queue.removeAll();
		assertTrue(queue.size() == 0);
	}
	
	public void testPeek() {
		assertTrue(queue.peek() == null);
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
	
	public void testIsEmpty() {
		queue.enqueue(null);
		assertTrue(queue.isEmpty());
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
		queue.dequeue();
		assertTrue(queue.isEmpty());
	}
	
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
