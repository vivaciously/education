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

public class LinkedListTest {
	
	protected LinkedList<Integer> list;

	@Test
	public void testSingleValueConstructor() {
		assertThrows(NullPointerException.class, () -> {
			Integer val = null;
			list = new LinkedList<>(val);
		});
		list = new LinkedList<>(89);
		assertTrue(list.size == 1);
		assertTrue(list.peek() == 89);
		assertTrue(list.peekTail() == 89);
		assertTrue(list.remove(89));
		assertTrue(list.size() == 0);
	}
	
	@Test
	public void testIterableConstructor() {
		Set<Integer> testCase = new HashSet<>(ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]"));
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.size());
		for(int n : testCase) {
			assertTrue(list.contains(n));
		}
		List<Integer> anotherTestCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		anotherTestCase.add(null);
		list.clear();
		list = null;
		assertThrows(NullPointerException.class, () -> {
			list = new LinkedList<>(anotherTestCase);
		});
	}
	
	@Test
	public void testArrayConstructor() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.length);
		list.clear();
		list = null;
		testCase[4] = null;
		assertThrows(NullPointerException.class, () -> {
			list = new LinkedList<>(testCase);
		});
	}
	
	@Test
	public void testAddAllWithIterable() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.size());
		for(int i=0; i<testCase.size(); i++) {
			assertEquals(list.peekAt(i), testCase.get(i));
		}
		List<Integer> anotherTestCase = ArrayTestUtils.strToIntegerList("[5,6,7]");
		list.addAll(anotherTestCase);
		assertTrue(list.size() == testCase.size() + 3);
		testCase.addAll(anotherTestCase);
		assertEquals(list.peekTail(), 7);
		for(int i=0; i<testCase.size(); i++) {
			assertEquals(list.peekAt(i), testCase.get(i));
		}
		List<Integer> yetAnotherTestCase = ArrayTestUtils.strToIntegerList("[1,3,5,24,6,9]");
		yetAnotherTestCase.add(null);
		assertThrows(NullPointerException.class, () -> {
			list.addAll(yetAnotherTestCase);
		});
	}
	
	@Test
	public void testAddAllWithArray() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new LinkedList<>();
		list.addAll(testCase);
		assertTrue(list.size() == testCase.length);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		for(int i=testCase.length -1; i >= 0; i--) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase[3] = null;
		assertThrows(NullPointerException.class, () -> {
			list.addAll(testCase);
		});
	}
	
	@Test
	public void testPeekAt() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.peekAt(9) == 9);
		assertThrows(IllegalArgumentException.class, () -> {
			list.peekAt(10);
		});
		assertTrue(list.remove(3));
		assertTrue(list.peekAt(1) == 3);
		assertTrue(list.size() == 9);
		assertThrows(IllegalArgumentException.class, () -> {
			list.peekAt(9);
		});
		assertTrue(list.contains(3));
		assertTrue(list.remove(3));
		assertTrue(list.peekAt(1) == 2);
		assertTrue(list.remove(78));
		assertTrue(list.peekAt(4) == 24);
		assertThrows(IllegalArgumentException.class, () -> {
			list.peekAt(-1);
		});
		assertTrue(list.peekAt(0) == 1);
		assertTrue(list.peek() == 1);
	}
	
	@Test
	public void testPeek() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == 4);
		assertTrue(list.peek() == 1);
		assertTrue(list.remove(1));
		assertTrue(list.peek() == 3);
		list.removeAllDuplicatedElements();
		assertTrue(list.size == 1);
		assertTrue(list.peek() == 2);
		assertTrue(list.removeFirst() == 2);
		assertTrue(list.size == 0);
		list.addToTail(90);
		assertTrue(list.size == 1);
		assertTrue(list.peek() == 90);
		list.addToTail(67);
		assertTrue(list.peek() == 90);
		list.addToFront(23);
		assertFalse(list.peek() == 90);
		assertTrue(list.peek() == 23);
		assertTrue(list.size == 3);
		
		assertTrue(list.removeTail() == 67);
		assertTrue(list.removeFirst() == 23);
		assertTrue(list.peek() == 90);
		assertTrue(list.size == 1);
		assertTrue(list.removeFirst() == 90);
		assertThrows(NoSuchElementException.class, () -> {
			list.peek();
		});
	}
	
	@Test
	public void testPeekTail() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == 4);
		assertTrue(list.peekTail() == 2);
		list.addToTail(52);
		assertTrue(list.peekTail() == 52);
		assertTrue(list.removeTail() == 52);
		assertTrue(list.peekTail() == 2);
		assertTrue(list.removeTail() == 2);
		assertTrue(list.peekTail() == 3);
		list.removeAllDuplicatedElements();
		assertTrue(list.peekTail() == 1);
		assertTrue(list.removeTail() == 1);
		assertThrows(NoSuchElementException.class, () -> {
			list.peekTail();
		});
	}
	
	@Test
	public void testContains() {
		list = new LinkedList<>();
		assertThrows(NullPointerException.class, () -> {
			list.contains(null);
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2]");
		list.addAll(testCase);
		assertTrue(list.contains(3));
		assertFalse(list.contains(4));
		list.addToFront(5);
		assertTrue(list.contains(5));
		list.remove(5);
		assertFalse(list.contains(5));
		list.addToTail(5);
		assertTrue(list.contains(5));
		list.remove(5);
		assertFalse(list.contains(5));
		list.clear();
		assertFalse(list.contains(1));
	}
	
	@Test
	public void testClear() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == 10);
		list.clear();
		assertTrue(list.size() == 0);
		assertTrue(list.head.next == list.tail);
		assertTrue(list.head.prev == null);
		assertTrue(list.tail.next == null);
	}
	
	@Test
	public void testAddToFront() {
		list = new LinkedList<>();
		assertThrows(NullPointerException.class, () -> {
			Integer val = null;
			list.addToFront(val);
		});
		list.addToFront(0);
		assertTrue(list.peek() == 0);
		assertTrue(list.size() == 1);
		list.addToFront(1);
		assertTrue(list.peek() == 1);
		assertTrue(list.size() == 2);
		list.addToFront(2);
		assertTrue(list.peek() == 2);
		assertTrue(list.size() == 3);
		for(int i=0; i<3; i++) {
			assertTrue(list.peekAt(i) == 2 -i);
		}
	}
	
	@Test
	public void testAddToTail() {
		list = new LinkedList<>();
		assertThrows(NullPointerException.class, () -> {
			Integer val = null;
			list.addToTail(val);
		});
		list.addToTail(0);
		assertTrue(list.peek() == 0);
		assertTrue(list.peekTail() == 0);
		assertTrue(list.peekAt(0) == 0);
		assertTrue(list.size() == 1);
		
		list.addToTail(1);
		assertTrue(list.peek() == 0);
		assertTrue(list.peekTail() == 1);
		assertTrue(list.peekAt(0) == 0);
		assertTrue(list.peekAt(1) == 1);
		assertTrue(list.size() == 2);
		
		list.addToTail(2);
		assertTrue(list.peek() == 0);
		assertTrue(list.peekTail() == 2);
		assertTrue(list.peekAt(0) == 0);
		assertTrue(list.peekAt(1) == 1);
		assertTrue(list.peekAt(2) == 2);
		assertTrue(list.size() == 3);
		
		for(int i=0; i<3; i++) {
			assertTrue(list.peekAt(i) == i);
		}
	}
	
	@Test
	public void testInsertAt() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[-1,6,8,4,2]");
		list = new LinkedList<>(testCase);
		list.insertAt(78, 0);
		assertTrue(list.peek() == 78);
		assertTrue(list.peekAt(1) == -1);
		list.insertAt(56, 1);
		assertTrue(list.peekAt(1) == 56);
		
		assertTrue(list.size() == 7);
		list.insertAt(98, 7);
		assertTrue(list.peekAt(7) == 98);
		assertTrue(list.size() == 8);
		assertThrows(IllegalArgumentException.class, () -> {
			list.insertAt(100, 9);
		});
	}
	
	@Test
	public void testRemoveFirst() {
		list = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
		list.addToFront(0);
		assertTrue(list.removeFirst() == 0);
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
		list.addToFront(0);
		list.addToFront(1);
		assertTrue(list.removeFirst() == 1);
		assertTrue(list.removeFirst() == 0);
		
		list.addToFront(0);
		list.addToFront(1);
		list.addToTail(2);
		assertTrue(list.removeFirst() == 1);
		assertTrue(list.removeFirst() == 0);
		assertTrue(list.removeFirst() == 2);
		assertThrows(NoSuchElementException.class, () -> {
			list.removeFirst();
		});
	}
	
	@Test
	public void testRemoveTail() {
		list = new LinkedList<>();
		assertThrows(NoSuchElementException.class, () -> {
			list.removeTail();
		});
		list.addToTail(0);
		assertTrue(list.removeTail() == 0);
		assertThrows(NoSuchElementException.class, () -> {
			list.removeTail();
		});
		
		list.addToTail(0);
		list.addToTail(1);
		assertTrue(list.size() == 2);
		assertTrue(list.removeTail() == 1);
		assertTrue(list.removeTail() == 0);
		assertTrue(list.isEmpty());
		
		list.addToTail(0);
		list.addToTail(1);
		list.addToTail(2);
		assertTrue(list.size() == 3);
		assertTrue(list.removeTail() == 2);
		assertTrue(list.removeTail() == 1);
		assertTrue(list.removeTail() == 0);
		assertTrue(list.isEmpty());
		
		list.addToTail(0);
		list.addToTail(1);
		list.addToTail(2);
		assertTrue(list.removeFirst() == 0);
		assertTrue(list.removeFirst() == 1);
		assertTrue(list.removeFirst() == 2);
		assertTrue(list.isEmpty());
		assertThrows(NoSuchElementException.class, () -> {
			list.removeTail();
		});
	}
	
	@Test
	public void testRemoveAt() {
		list = new LinkedList<>();
		assertThrows(IllegalArgumentException.class, () -> {
			list.removeAt(-1);
		});
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,2,3]");
		list.addAll(testCase);
		assertTrue(list.removeAt(1) == 2);
		assertTrue(list.removeAt(1) == 3);
		assertTrue(list.removeAt(0) == 1);
		testCase = ArrayTestUtils.strToIntegerList("[1,2,3,1,2,3]");
		list.addAll(testCase);
		assertEquals(list.removeAt(3), 1);
		assertEquals(list.removeAt(0), 1);
		assertEquals(list.removeAt(0), 2);
		assertThrows(IllegalArgumentException.class, () -> {
			list.removeAt(3);
		});
		assertEquals(list.removeAt(1), 2);
		assertEquals(list.removeAt(0), 3);
		assertEquals(list.removeAt(0), 3);
	}
	
	@Test
	public void testRemove() {
		list = new LinkedList<>();
		assertThrows(NullPointerException.class, () -> {
			Integer val = null;
			list.remove(val);
		});
		assertFalse(list.remove(35));
		list.addToTail(35);
		list.addToTail(35);
		assertTrue(list.remove(35));
		assertTrue(list.remove(35));
		assertFalse(list.remove(35));
		assertTrue(list.isEmpty());
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2,34,6,78,24,6,9]");
		list.addAll(testCase);
		assertTrue(list.size() == testCase.size());
		assertTrue(list.remove(3));
		assertTrue(list.remove(3));
		assertFalse(list.remove(3));
		assertTrue(list.size() == testCase.size() -2);
		assertTrue(list.remove(9));
		assertTrue(list.remove(6));
		assertTrue(list.remove(6));
		assertFalse(list.remove(9));
		assertFalse(list.remove(6));
	}
	
	@Test
	public void testFindNodeAt() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,3,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == 10);
		assertEquals(list.findNodeAt(0).value, 1);
		assertThrows(IllegalArgumentException.class, () -> {
			list.findNodeAt(-1);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			list.findNodeAt(10);
		});
		assertEquals(list.findNodeAt(9).value, 9);
		assertTrue(list.removeFirst() == 1);
		assertEquals(list.findNodeAt(0).value, 3);
		assertThrows(IllegalArgumentException.class, () -> {
			list.findNodeAt(9);
		});
		assertEquals(list.findNodeAt(3).value, 34);
		list.clear();
		assertThrows(NoSuchElementException.class, () -> {
			list.findNodeAt(0);
		});
		testCase = ArrayTestUtils.strToIntegerList("[1,2,4,3]");
		list.addAll(testCase);
		assertEquals(list.findNodeAt(3).value, 3);
		assertEquals(list.findNodeAt(0).value, 1);
		list.mergeSort(Integer::compare);
		assertEquals(list.findNodeAt(3).value, 4);
		assertEquals(list.findNodeAt(0).value, 1);
		list.reverse();
		assertEquals(list.findNodeAt(3).value, 1);
		assertEquals(list.findNodeAt(0).value, 4);
	}
	
	@Test
	public void testReverse() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.length);
		list.reverse();
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(list.size() -i -1));
		}
		assertTrue(list.head.next.value == 9);
		assertTrue(list.head.prev == null);
		assertTrue(list.tail.next == null);
		assertTrue(list.tail.prev.value == 1);
	}
	
	@Test
	public void testSortAndRemoveDuplicates() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		list.sortAndRemoveDuplicates((a,b) -> Integer.compare(a, b));
		Set<Integer> set = new HashSet<>();
		for(int n : list) {
			assertFalse(set.contains(n));
		}
	}
	
	@Test
	public void testRemoveDuplicates() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		
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
	public void testRemoveAllDuplicatedElements() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
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
		
		list.clear();
		list.addAll(ArrayTestUtils.strToIntegerArray("[2, 1,1,1,1,1,1,1, 2]"));
		list.removeAllDuplicatedElements();
		assertTrue(list.size() == 0);
		
		list.clear();
		list.addAll(ArrayTestUtils.strToIntegerArray("[0,1,2]"));
		list.removeAllDuplicatedElements();
		assertTrue(list.size() == 3);
		for(int i=0; i<list.size(); i++) {
			assertTrue(list.peekAt(i) == i);
		}
	}
	
	@Test
	public void testMergeSort() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[]");
		list = new LinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1]");
		list = new LinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		testCase = ArrayTestUtils.strToIntegerArray("[1,2]");
		list = new LinkedList<>(testCase);
		list.mergeSort((a,b) -> Integer.compare(a, b));
		Arrays.sort(testCase);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
	}
	
	@Test
	public void testStream() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		assertEquals(list.stream().count(), testCase.stream().count());
	}
	
	@Test
	public void testIterator() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		Iterator<Integer> itr = list.iterator();
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
		list = new LinkedList<>(testCase);
		Integer[] results = new Integer[testCase.size()];
		list.toArray(results);
		for(int i=0; i<testCase.size(); i++) {
			assertEquals(results[i], testCase.get(i));
		}
	}
	
	@Test
	public void testToCollection() {
		List<Integer> testCase = ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]");
		list = new LinkedList<>(testCase);
		Set<Integer> set = new HashSet<>();
		list.toCollection(set);
		for(int n : testCase) {
			assertTrue(set.contains(n));
		}
	}
	
}
