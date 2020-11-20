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
		assertTrue(list.map.size() == 0);
	}
	
	@Test
	public void testIterableConstructor() {
		Set<Integer> testCase = new HashSet<>(ArrayTestUtils.strToIntegerList("[1,3,5,2,34,6,78,24,6,9]"));
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.size());
		for(int n : testCase) {
			assertTrue(list.contains(n));
		}
		assertTrue(list.map.get(6).size() == 1);
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
		assertTrue(list.map.get(3).size() == 2);
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
		assertTrue(list.map.size() == 0);
	}
	
	@Test
	public void testAddToFront() {
		
	}
	
	@Test
	public void testAddToTail() {
		
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
		
	}
	
	@Test
	public void testRemoveTail() {
		
	}
	
	@Test
	public void testRemoveNode() {
		
	}
	
	@Test
	public void testRemove() {
		
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
	public void testUpdateMap() {
		
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
	public void testRemoveDuplicates() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[5,3,1,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		list.removeDuplicates((a,b) -> Integer.compare(a, b));
		Set<Integer> set = new HashSet<>();
		for(int n : list) {
			assertFalse(set.contains(n));
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
