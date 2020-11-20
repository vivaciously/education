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
	}
	
	@Test
	public void testArrayConstructor() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.length);
		assertTrue(list.map.get(3).size() == 2);
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
	}
	
	@Test
	public void testAddAllWithArray() {
		Integer[] testCase = ArrayTestUtils.strToIntegerArray("[1,3,5,2,34,6,3,24,6,9]");
		list = new LinkedList<>(testCase);
		assertTrue(list.size() == testCase.length);
		for(int i=0; i<testCase.length; i++) {
			assertEquals(testCase[i], list.peekAt(i));
		}
		for(int i=testCase.length -1; i >= 0; i--) {
			assertEquals(testCase[i], list.peekAt(i));
		}
	}
	
	@Test
	public void testPeekAt() {
		
	}
	
	@Test
	public void testPeek() {
		
	}
	
	@Test
	public void testPeekTail() {
		
	}
	
	@Test
	public void testContains() {
		
	}
	
	@Test
	public void testClear() {
		
	}
	
	@Test
	public void testAddToFront() {
		
	}
	
	@Test
	public void testAddToTail() {
		
	}
	
	@Test
	public void testInsertAt() {
		
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
		
	}
	
	@Test
	public void testMerge() {
		
	}
	
}
