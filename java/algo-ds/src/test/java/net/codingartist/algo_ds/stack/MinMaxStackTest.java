package net.codingartist.algo_ds.stack;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

public class MinMaxStackTest {

	
	@Test
	public void testMinMaxStack() {
		MinMaxStack<Integer> stack = new MinMaxStack<>((a,b) -> Integer.compare(a, b));
		assertTrue(stack.size() == 0);
		stack.push(1);
		assertTrue(stack.size() == 1);
		assertTrue(stack.min() == 1);
		assertTrue(stack.max() == 1);
		assertTrue(stack.peek() == 1);
		
		stack.push(2);
		assertTrue(stack.size() == 2);
		assertTrue(stack.min() == 1);
		assertTrue(stack.max() == 2);
		assertTrue(stack.peek() == 2);
		
		assertTrue(stack.pop() == 2);
		assertTrue(stack.min() == 1);
		assertTrue(stack.max() == 1);
		assertTrue(stack.peek() == 1);
		
		assertTrue(stack.pop() == 1);
		assertTrue(stack.size() == 0);
		
		assertThrows(EmptyStackException.class, () -> {
			stack.pop();
		});
		
		assertThrows(EmptyStackException.class, () -> {
			stack.min();
		});
		
		assertThrows(EmptyStackException.class, () -> {
			stack.max();
		});
		
		assertThrows(EmptyStackException.class, () -> {
			stack.peek();
		});
		
		stack.push(3);
		stack.push(2);
		assertTrue(stack.size() == 2);
		assertTrue(stack.min() == 2);
		assertTrue(stack.max() == 3);
		assertTrue(stack.peek() == 2);
		stack.push(1);
		assertTrue(stack.size() == 3);
		assertTrue(stack.min() == 1);
		assertTrue(stack.max() == 3);
		assertTrue(stack.peek() == 1);
		
		assertTrue(stack.pop() == 1);
		assertTrue(stack.size() == 2);
		assertTrue(stack.min() == 2);
		assertTrue(stack.max() == 3);
		assertTrue(stack.peek() == 2);
		
		assertTrue(stack.pop() == 2);
		assertTrue(stack.size() == 1);
		assertTrue(stack.min() == 3);
		assertTrue(stack.max() == 3);
		assertTrue(stack.peek() == 3);
		
		assertTrue(stack.pop() == 3);
		assertTrue(stack.size() == 0);
	}
}
