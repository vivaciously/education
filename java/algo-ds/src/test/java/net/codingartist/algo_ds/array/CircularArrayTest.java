package net.codingartist.algo_ds.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import net.codingartist.algo_ds.exceptions.FullCapacityDataStructureException;
import net.codingartist.algo_ds.objects.Point;

public class CircularArrayTest {
	
	
	private CircularArray<Point> array;
	private static final int DEFAULT_TEST_CAPACITY = 2;
	
	@AfterEach
	void tearDown() {
		array.clear();
		array = null;
	}
	
	@Test
	public void testPoll() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY);
		int initCapa = array.capacity();
		Point p1 = new Point(3,3);
		Point p2 = new Point(2,2);
		array.insert(p1);
		array.insert(p2);
		assertTrue(array.capacity() == initCapa);
		assertEquals(array.poll(), p1);
		assertEquals(array.poll(), p2);
		assertTrue(array.capacity() == initCapa);
		array.insert(p1);
		array.insert(p2);
		assertTrue(array.capacity() == initCapa);
		assertEquals(array.poll(), p1);
		assertEquals(array.poll(), p2);
		assertTrue(array.capacity() == initCapa);
	}
	
	@Test
	public void testPeekAt() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY);
		int initCapa = array.capacity();
		Point p1 = new Point(3,3);
		Point p2 = new Point(2,2);
		array.insert(p1);
		array.insert(p2);
		assertTrue(array.capacity() == initCapa);
		assertEquals(array.peekAt(0), p1);
		assertEquals(array.peekAt(1), p2);
		assertEquals(array.peekAt(2), p1);
		assertEquals(array.peekAt(3), p2);
		assertEquals(array.peek(), p1);
	}
	
	//CircularArray(int capacity, boolean immutable, boolean reallocatable)
	@Test
	public void testConstructor_1() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, false, true);
		circularArrayTest_1();
	}
	
	//CircularArray(E[] tArray, boolean immutable, boolean reallocatable)
	@Test
	public void testConstructor_2() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, true, true);
		circularArrayTest_2();
	}
	
	//CircularArray(int capacity, boolean immutable, boolean reallocatable)
	@Test
	public void testConstructor_3() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, true, false);
		circularArrayTest_3();
	}
	
	//CircularArray(int capacity, boolean immutable, boolean reallocatable)
	@Test
	public void testConstructor_4() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, false, false);
		circularArrayTest_4();
	}
	
	//CircularArray(E[] tArray, boolean immutable, boolean reallocatable)
	@Test
	public void testConstructor_5() {
		Point[] points = new Point[] {new Point(3,3), new Point(2,2)};
		array = new CircularArray<>(points, false, true);
		assertTrue(array.isReallocatable());
		assertFalse(array.isElementImmutable());
		int initCapa = array.capacity();
		array.insert(new Point(1,1));
		assertTrue(array.capacity() == initCapa*2);
		array.poll();
		array.poll();
		
		array.insert(new Point(10,10));
		assertTrue(array.size() == 2);
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
		
		assertThrows(NullPointerException.class, () -> {
			array.insert(null);
		});
	}
	
	//CircularArray(Iterable<? extends E> src, boolean immutable)
	@Test
	public void testConstructor_6() {
		List<Point> list = Arrays.asList(new Point(3,3), new Point(2,2));
		array = new CircularArray<>(list, true);
		int initCapa = array.capacity();
		assertTrue(array.capacity() == initCapa);
		array.insert(new Point(1,1));
		assertTrue(array.capacity() == initCapa);
		array.poll();
		array.poll();
		
		array.insert(new Point(10,10));
		assertTrue(array.size() == 2);
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
		
		assertThrows(NullPointerException.class, () -> {
			array.insert(null);
		});
		
		Point firstElement = array.peek();
		firstElement.x = 10;
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
	}
	
	//CircularArray(Iterable<? extends E> src, boolean immutable)
	@Test
	public void testConstructor_7() {
		List<Point> list = Arrays.asList(new Point(3,3), new Point(2,2));
		array = new CircularArray<>(list, false);
		int initCapa = array.capacity();
		assertTrue(array.capacity() == initCapa);
		array.insert(new Point(1,1));
		assertTrue(array.capacity() == initCapa);
		array.poll();
		array.poll();
		
		array.insert(new Point(10,10));
		assertTrue(array.size() == 2);
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
		
		assertThrows(NullPointerException.class, () -> {
			array.insert(null);
		});
		
		Point firstElement = array.peek();
		firstElement.x = 10;
		assertTrue(array.peek().x == 10);
		assertTrue(array.peek().y == 1);
	}
	
	//CircularArray(int capacity)
	@Test
	public void testConstructor_8() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY);
		circularArrayTest_1();	
	}
	
	//CircularArray(int capacity)
	@Test
	public void testConstructor_9() {
		array = new CircularArray<>();
		assertTrue(array.isReallocatable());
		assertFalse(array.isElementImmutable());
		assertTrue(array.capacity() == array.DEFAULT_CAPACITY);
	}
	
	@Test
	public void testToCollectionFrom(){
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY);
		for(int i=0; i<10; i++){
			array.insert(new Point(i,i));
		}
		ArrayList<Point> list = new ArrayList<>();
		array.toCollectionFrom(0,list);
		for(int i=0; i<10; i++){
			assertTrue(list.get(i).x == i);
			assertTrue(list.get(i).y == i);
		}
		list.clear();
		array.toCollectionFrom(5,list);
		for(int i=0; i<10; i++){
			int v  = (i + 5 ) % 10;
			assertTrue(list.get(i).x == v);
			assertTrue(list.get(i).y == v);
		}
	}
	
	@Test
	public void testToListFrom() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY);
		for(int i=0; i<10; i++){
			array.insert(new Point(i,i));
		}
		List<Point> list = array.toListFrom(0);
		for(int i=0; i<10; i++){
			assertTrue(list.get(i).x == i);
			assertTrue(list.get(i).y == i);
		}
		list.clear();
		array.toCollectionFrom(4,list);
		for(int i=0; i<10; i++){
			int v  = (i + 4) % 10;
			assertTrue(list.get(i).x == v);
			assertTrue(list.get(i).y == v);
		}
	}
	
	@Test
	public void testToArrayFrom(){
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY);
		for(int i=0; i<10; i++){
			array.insert(new Point(i,i));
		}
		Point[] buffer = new Point[array.size()];
		array.toArrayFrom(0, buffer);
		for(int i=0; i<10; i++){
			assertTrue(buffer[i].x == i);
			assertTrue(buffer[i].y == i);
		}
		
		array.toArrayFrom(6, buffer);
		for(int i=0; i<10; i++){
			int v  = (i + 6) % 10;
			assertTrue(buffer[i].x == v);
			assertTrue(buffer[i].y == v);
		}
	}
	
	@Test
	public void testToCollectionFromImmutable(){
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, true, true);
		for(int i=0; i<10; i++){
			array.insert(new Point(i,i));
		}
		ArrayList<Point> list = new ArrayList<>();
		array.toCollectionFrom(0,list);
		for(int i=0; i<10; i++){
			assertTrue(list.get(i).x == i);
			assertTrue(list.get(i).y == i);
		}
		list.clear();
		array.toCollectionFrom(5,list);
		for(int i=0; i<10; i++){
			int v  = (i + 5 ) % 10;
			assertTrue(list.get(i).x == v);
			assertTrue(list.get(i).y == v);
		}
		
		assertTrue(list.get(0).x == 5);
		list.get(0).x = 90;
		assertTrue(array.peekAt(5).x == 5);
	}
	
	@Test
	public void testToListFromImmutable() {
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, true, true);
		for(int i=0; i<10; i++){
			array.insert(new Point(i,i));
		}
		List<Point> immutableList = array.toListFrom(0);
		for(int i=0; i<10; i++){
			assertTrue(immutableList.get(i).x == i);
			assertTrue(immutableList.get(i).y == i);
		}
		assertThrows(UnsupportedOperationException.class, () -> {
			immutableList.clear();
		});
	}
	
	@Test
	public void testToArrayFromImmutable(){
		array = new CircularArray<>(DEFAULT_TEST_CAPACITY, true, true);
		for(int i=0; i<10; i++){
			array.insert(new Point(i,i));
		}
		Point[] buffer = new Point[array.size()];
		array.toArrayFrom(0, buffer);
		for(int i=0; i<10; i++){
			assertTrue(buffer[i].x == i);
			assertTrue(buffer[i].y == i);
		}
		buffer[0].x = 90;
		assertTrue(array.peek().x == 0);
	}
	
	
	//Some common tests are defined below
	private void circularArrayTest_1() {
		assertTrue(array.isReallocatable());
		assertFalse(array.isElementImmutable());
		int initCapa = array.capacity();
		array.insert(new Point(3,3));
		array.insert(new Point(2,2));
		assertTrue(array.capacity() == initCapa);
		array.insert(new Point(1,1));
		assertTrue(array.capacity() == initCapa*2);
		array.poll();
		array.poll();
		
		array.insert(new Point(10,10));
		assertTrue(array.size() == 2);
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
		
		assertThrows(NullPointerException.class, () -> {
			array.insert(null);
		});
	}
	
	private void circularArrayTest_2() {
		assertTrue(array.isReallocatable());
		assertTrue(array.isElementImmutable());
		int initCapa = array.capacity();
		array.insert(new Point(3,3));
		array.insert(new Point(2,2));
		assertTrue(array.capacity() == initCapa);
		array.insert(new Point(1,1));
		assertTrue(array.capacity() == initCapa*2);
		array.poll();
		array.poll();
		
		array.insert(new Point(10,10));
		assertTrue(array.size() == 2);
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
		
		assertThrows(NullPointerException.class, () -> {
			array.insert(null);
		});
		
		Point firstElement = array.peek();
		firstElement.x = 10;
		assertTrue(array.peek().x == 1);
		assertTrue(array.peek().y == 1);
	}
	
	private void circularArrayTest_3() {
		assertFalse(array.isReallocatable());
		assertTrue(array.isElementImmutable());
		int initCapa = array.capacity();
		array.insert(new Point(3,3));
		array.insert(new Point(2,2));
		assertTrue(array.capacity() == initCapa);
		
		assertThrows(FullCapacityDataStructureException.class, () -> {
			array.insert(new Point(1,1));
		});
		
		assertTrue(array.size() == 2);
		Point firstElement = array.peek();
		firstElement.x = 10;
		assertTrue(array.peek().x == 3);
		assertTrue(array.peek().y == 3);
	}
	
	private void circularArrayTest_4() {
		assertFalse(array.isReallocatable());
		assertFalse(array.isElementImmutable());
		int initCapa = array.capacity();
		array.insert(new Point(3,3));
		array.insert(new Point(2,2));
		assertTrue(array.capacity() == initCapa);
		
		assertThrows(FullCapacityDataStructureException.class, () -> {
			array.insert(new Point(1,1));
		});
		
		assertTrue(array.size() == 2);
		Point firstElement = array.peek();
		firstElement.x = 10;
		assertTrue(array.peek().x == 10);
		assertTrue(array.peek().y == 3);
	}
	
	
}
