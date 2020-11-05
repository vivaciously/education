package net.codingartist.algo_ds.stack;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class StackTest {

	protected Stack<Integer> stack;
	
	@BeforeEach
	void init() {
		stack = new Stack<>(1);
	}
	
	@AfterEach
	void tearDown() {
		stack = null;
	}
	
	@Test
	public void testReallocate(){
		stack.push(2);
		stack.push(1);
		assertTrue(stack.capacity() == 2);
		stack.push(0);
		assertTrue(stack.capacity() == 4);
	}
	
	@Test
	public void testPush(){
		stack.push(2);
		assertTrue(stack.peek() == 2);
		assertTrue(stack.size() == 1);
		stack.push(1);
		assertTrue(stack.peek() == 1);
		assertTrue(stack.size() == 2);
		assertThrows(NullPointerException.class, 
				() -> stack.push(null));
		
		assertTrue(stack.peek() == 1);
		assertTrue(stack.size() == 2);
		stack.clear();
		assertTrue(stack.size() == 0);
		stack.push(2);
		assertTrue(stack.peek() == 2);
		assertTrue(stack.size() == 1);
		stack.push(1);
		assertTrue(stack.peek() == 1);
		assertTrue(stack.size() == 2);
		assertTrue(stack.peek() == 1);
		assertTrue(stack.size() == 2);
	}
	
	@Test
	public void testPop(){
		stack.push(1);
		stack.push(3);
		assertTrue(stack.pop() == 3);
		assertTrue(stack.size() == 1);
		assertTrue(stack.pop() == 1);
		assertTrue(stack.size() == 0);
		stack.clear();
		assertTrue(stack.size() == 0);
		assertThrows(EmptyStackException.class, 
				() -> stack.pop());
	}
	
	@Test
	public void testToCollection(){
		for(int i=0; i<10; i++){
			stack.push(Integer.valueOf(i));
		}
		ArrayList<Integer> list = new ArrayList<>();
		stack.toCollection(list);
		for(int i=0; i<10; i++){
			assertTrue(list.get(i) == (9-i));
		}
	}
	
	@Test
	public void testToArray(){
		for(int i=0; i<10; i++){
			stack.push(Integer.valueOf(i));
		}
		Integer[] buffer = new Integer[stack.size()];
		stack.toArray(buffer);
		for(int i=0; i<10; i++){
			assertTrue(buffer[i] == (9-i));
		}
	}
}
