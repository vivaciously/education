package net.codingartist.algo_ds.linkedlist;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import net.codingartist.algo_ds.utils.ArrayTestUtils;

public class SingleLinkedListTest {

	protected SingleLinkedList<Integer> list;
	
	@Test
	public void testIterableConstructor() {
		Set<Integer> testCase = new HashSet<>(ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]"));
		list = new SingleLinkedList<>(testCase);
		assertTrue(list.size() == testCase.size());
		list.clear();
		List<Integer> anotherTestCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		anotherTestCase.add(null);
		assertThrows(NullPointerException.class, () -> {
			list = new SingleLinkedList<>(anotherTestCase);
		});
	}
	
	@Test
	public void testArrayConstructor() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		assertTrue(list.size() == testCase.length);
		testCase[3] = null;
		assertThrows(NullPointerException.class, () -> {
			list = new SingleLinkedList<>(testCase);
		});
	}
	
	@Test
	public void testContains() {
		list = new SingleLinkedList<>();
		assertThrows(NullPointerException.class, () -> {
			list.contains(null);
		});
		assertTrue(list.size() == 0);
		assertFalse(list.contains(1));
		list.addToFront(1);
		assertTrue(list.contains(1));
		list.addToFront(2);
		assertTrue(list.contains(1));
		assertTrue(list.contains(2));
		assertFalse(list.contains(3));
		list.addToFront(3);
		assertTrue(list.size() == 3);
		assertTrue(list.contains(2));
		assertTrue(list.remove(2));
		assertTrue(list.size == 2);
		assertFalse(list.contains(2));
		assertTrue(list.contains(1));
		assertTrue(list.contains(3));
	}
	
	@Test
	public void testPeek() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		assertTrue(list.size() == testCase.size());
		assertTrue(list.peek() == 1);
		assertTrue(list.size() == testCase.size());
		assertTrue(list.remove(1));
		assertEquals(list.peek(), 3);
		assertTrue(list.remove(3));
		assertEquals(list.peek(), 5);
		assertTrue(list.size() == testCase.size() -2);
		list.clear();
		assertThrows(NoSuchElementException.class, () -> {
			list.peek();
		});
	}
	
	@Test
	public void testPeekTail() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		assertTrue(list.size() == testCase.size());
		assertTrue(list.peekTail() == 9);
		assertTrue(list.remove(9));
		assertTrue(list.peekTail() == 6);
		assertTrue(list.remove(6));
		assertTrue(list.size() == testCase.size()-2);
		list.clear();
		assertThrows(NoSuchElementException.class, () -> {
			list.peekTail();
		});
	}
	
	@Test
	public void testPeekAt() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		assertTrue(list.size() == testCase.length);
		assertThrows(IllegalArgumentException.class, () -> {
			list.peekAt(11);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			list.peekAt(-1);
		});
		list.clear();
		assertThrows(IndexOutOfBoundsException.class, () -> {
			list.peekAt(0);
		});
	}
	
	@Test
	public void testClear() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		assertTrue(list.size() == testCase.length);
		list.clear();
		assertTrue(list.size() == 0);
		assertFalse(list.contains(1));
	}
	
	@Test
	public void testIsEmpty() {
		list = new SingleLinkedList<>();
		assertTrue(list.isEmpty());
		list.addToFront(1);
		assertFalse(list.isEmpty());
		list.remove(1);
		assertTrue(list.isEmpty());
	}
	
	@Test
	public void testAddToFront() {
		list = new SingleLinkedList<>();
		assertTrue(list.isEmpty());
		list.addToFront(1);
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 1);
		assertTrue(list.peek() == 1);
		assertTrue(list.peekAt(0) == 1);
		assertTrue(list.contains(1));
		list.addToFront(35);
		assertTrue(list.peekTail() == 1);
		assertTrue(list.size() == 2);
		assertTrue(list.peek() == 35);
		assertTrue(list.peekAt(0) == 35);
		assertTrue(list.peekAt(1) == 1);
		assertTrue(list.contains(1));
		assertTrue(list.contains(35));
		assertThrows(NullPointerException.class, () -> {
			list.addToFront(null);
		});
	}
	
	@Test
	public void testAddToTail() {
		list = new SingleLinkedList<>();
		assertTrue(list.isEmpty());
		list.addToTail(1);
		assertFalse(list.isEmpty());
		assertTrue(list.size() == 1);
		assertTrue(list.peek() == 1);
		assertTrue(list.peekAt(0) == 1);
		assertTrue(list.contains(1));
		list.addToTail(35);
		assertTrue(list.peekTail() == 35);
		assertTrue(list.size() == 2);
		assertTrue(list.peek() == 1);
		assertTrue(list.peekAt(0) == 1);
		assertTrue(list.peekAt(1) == 35);
		assertTrue(list.contains(1));
		assertTrue(list.contains(35));
		assertThrows(NullPointerException.class, () -> {
			list.addToTail(null);
		});
	}
	
	@Test
	public void testInsertAt() {
		list = new SingleLinkedList<>();
		assertTrue(list.isEmpty());
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertAt(1, 1);
		});
		assertThrows(NullPointerException.class, () -> {
			list.insertAt(null, 0);
		});
		list.insertAt(1, 0);
		assertTrue(list.size() == 1);
		assertFalse(list.isEmpty());
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertAt(1, 2);
		});
		list.insertAt(2, 1);
		assertTrue(list.size() == 2);
		list.insertAt(3, 2);
		assertTrue(list.size() == 3);
		assertTrue(list.peekAt(0) == 1);
		assertTrue(list.peekAt(2) == 3);
		list.insertAt(45, 2);
		assertTrue(list.size() == 4);
		assertTrue(list.peekAt(2) == 45);
		list.insertAt(27, 1);
		list.insertAt(90, 0);
		assertTrue(list.size() == 6);
		assertTrue(list.peekAt(0) == 90);
		assertTrue(list.peekAt(5) == 3);
		list.insertAt(85, 6);
		assertTrue(list.peekAt(5) == 3);
		assertTrue(list.peekAt(6) == 85);
	}
	
	@Test
	public void testRemoveFirst() {
		list = new SingleLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5]");
		list.addAll(testCase);
		assertTrue(list.removeFirst() == 1);
		assertTrue(list.removeFirst() == 3);
		assertTrue(list.size() == testCase.size() -2);
		assertTrue(list.removeFirst() == 5);
		assertTrue(list.isEmpty());
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
	}
	
	@Test
	public void testRemoveTail() {
		list = new SingleLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeTail();
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5]");
		list.addAll(testCase);
		assertTrue(list.removeTail() == 5);
		assertTrue(list.removeTail() == 3);
		assertTrue(list.size() == testCase.size() -2);
		assertTrue(list.removeTail() == 1);
		assertTrue(list.isEmpty());
		assertThrows(NoSuchElementException.class, () -> {
			list.removeTail();
		});
	}
	
	@Test
	public void testRemoveAt() {
		list = new SingleLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeAt(0);
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5]");
		list.addAll(testCase);
		assertTrue(list.removeAt(1) == 3);
		assertTrue(list.removeAt(1) == 5);
		assertThrows(IllegalArgumentException.class, () -> {
			list.removeAt(1);
		});
		assertTrue(list.removeAt(0) == 1);
		assertThrows(NoSuchElementException.class, () -> {
			list.removeAt(0);
		});
		list.addAll(testCase);
		assertTrue(list.removeAt(2) == 5);
		assertTrue(list.removeAt(1) == 3);
		assertTrue(list.removeAt(0) == 1);
		assertThrows(NoSuchElementException.class, () -> {
			list.removeAt(0);
		});
		assertTrue(list.isEmpty());
		list.addAll(testCase);
		assertTrue(list.removeAt(0) == 1);
		assertTrue(list.removeAt(0) == 3);
		assertTrue(list.removeAt(0) == 5);
		assertThrows(NoSuchElementException.class, () -> {
			list.removeAt(0);
		});
	}
	
	@Test
	public void testRemove() {
		list = new SingleLinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.remove(0);
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,3,24,6,9]");
		list.addAll(testCase);
		assertTrue(list.remove(3));
		assertTrue(list.remove(3));
		assertFalse(list.remove(3));
		assertTrue(list.size() == testCase.size() -2);
		assertTrue(list.remove(1));
		assertTrue(list.peek() == 5);
		assertFalse(list.remove(35));
		list.remove(5);
		assertTrue(list.size() == testCase.size() -4);
		assertTrue(list.peekAt(0) == 2);
		list.remove(6);
		assertTrue(list.peekAt(1) == 34);
		assertTrue(list.peekAt(2) == 24);
		assertTrue(list.peekAt(3) == 6);
		assertTrue(list.peekAt(4) == 9);
		assertTrue(list.size() == testCase.size() -5);
	}
	
	@Test
	public void testReverse() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		list.reverse();
		for(int i=0; i<list.size; i++) {
			assertEquals(testCase.get(i), list.peekAt(list.size() - i -1));
		}
	}
	
	@Test
	public void testAddAllIterable() {
		Set<Integer> testCase = new HashSet<>(ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]"));
		list = new SingleLinkedList<>();
		list.addAll(testCase);
		assertTrue(list.size() == testCase.size());
		for(int n : testCase) {
			assertTrue(list.contains(n));
		}
		list.clear();
		List<Integer> anotherTestCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		anotherTestCase.add(null);
		assertThrows(NullPointerException.class, () -> {
			list.addAll(anotherTestCase);
		});
	}
	
	@Test
	public void testAddAllArray() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>();
		list.addAll(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		Integer[] anotherTestCase = ArrayTestUtils.strToIntegerArray("[1,2,3]");
		list.addAll(anotherTestCase);
		assertTrue(list.size() == testCase.length + anotherTestCase.length);
		for(int i=0; i<anotherTestCase.length; i++) {
			assertEquals(anotherTestCase[i], list.peekAt(i + testCase.length));
		}
		anotherTestCase[0] = null;
		assertThrows(NullPointerException.class, () -> {
			list.addAll(anotherTestCase);
		});
	}
	
	@Test
	public void testToArray() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		Integer[] results = new Integer[testCase.size()];
		list.toArray(results);
		for(int i=0; i<testCase.size(); i++) {
			assertEquals(results[i], testCase.get(i));
		}
	}
	
	@Test
	public void testToCollection() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		Set<Integer> set = new HashSet<>();
		list.toCollection(set);
		for(int n : testCase) {
			assertTrue(set.contains(n));
		}
	}
	
	@Test
	public void testStream() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		assertTrue(list.stream().count() == testCase.stream().count());
	}
	
	@Test
	public void testIterator() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		Iterator<Integer> itr = list.iterator();
		int i = 0;
		while(itr.hasNext()) {
			assertEquals(itr.next(), testCase.get(i++));
		}
	}
	
	@Test
	public void testInsertionSort() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		list.insertionSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[]");
		list = new SingleLinkedList<>(testCase);
		list.insertionSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1]");
		list = new SingleLinkedList<>(testCase);
		list.insertionSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1,2]");
		list = new SingleLinkedList<>(testCase);
		list.insertionSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
	}
	
	@Test
	public void TestSortAndRemoveDuplicates() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		list.sortAndRemoveDuplicates((a,b) -> Integer.compare(a, b));
		Set<Integer> set = new HashSet<>();
		for(int n : list) {
			assertFalse(set.contains(n));
		}
	}
	
	@Test
	public void TestRemoveDuplicates() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		
		list.removeDuplicates();
		List<Integer> expected = ArrayTestUtils.strToIntegerList("[5,1,2,34,3,24,6,9]");
		assertTrue(list.size() == expected.size());
		for(int i =0; i<expected.size(); i++) {
			assertEquals(expected.get(i), list.peekAt(i));
		}
		list.clear();
		testCase = ArrayTestUtils.strToIntegerArray("[1,1,1,1,1,1,1,1]");
		list.addAll(testCase);
		list.removeDuplicates();
		assertTrue(list.size() == 1);
		assertTrue(list.peek() == 1);
		
		list.clear();
		testCase = ArrayTestUtils.strToIntegerArray("[1,1]");
		list.addAll(testCase);
		list.removeDuplicates();
		assertTrue(list.size() == 1);
		assertTrue(list.peek() == 1);
		
		list.clear();
		testCase = ArrayTestUtils.strToIntegerArray("[1]");
		list.addAll(testCase);
		list.removeDuplicates();
		assertTrue(list.size() == 1);
		assertTrue(list.peek() == 1);
		
		list.clear();
		testCase = ArrayTestUtils.strToIntegerArray("[1,1,3,1,3,5,7,2,1,1,2,3,6,3,5,6,7,8,1]");
		list.addAll(testCase);
		list.removeDuplicates();
		expected = ArrayTestUtils.strToIntegerList("[2,3,5,6,7,8,1]");
		assertTrue(list.size() == expected.size());
		for(int i =0; i<expected.size(); i++) {
			assertEquals(expected.get(i), list.peekAt(i));
		}
	}
	
	@Test
	public void testRemoveAllDuplicatedElements() {//TODO
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		assertTrue(list.size() == testCase.length);
		assertTrue(list.contains(3));
		assertTrue(list.contains(6));
		list.removeAllDuplicatedElements();
		assertFalse(list.contains(3));
		assertFalse(list.contains(6));
		assertTrue(list.size() == testCase.length - 4);
		list.clear();
		list.addAll(ArrayTestUtils.strToIntegerArray("[1,1,1,1,1,1,1]"));
		list.removeAllDuplicatedElements();
		assertTrue(list.size() == 0);
	}
	
	@Test
	public void testBubbleSort() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		list.bubbleSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[]");
		list = new SingleLinkedList<>(testCase);
		list.bubbleSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1]");
		list = new SingleLinkedList<>(testCase);
		list.bubbleSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1,2]");
		list = new SingleLinkedList<>(testCase);
		list.bubbleSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
	}
	
	@Test
	public void testMergeSort() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new SingleLinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[]");
		list = new SingleLinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1]");
		list = new SingleLinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1,2]");
		list = new SingleLinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
	}
	
	
}
