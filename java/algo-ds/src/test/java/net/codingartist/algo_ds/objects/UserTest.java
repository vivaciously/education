package net.codingartist.algo_ds.objects;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class UserTest {
	
	@Test
	public void testConstructor() {
		
		assertDoesNotThrow(() -> {
			@SuppressWarnings("unused")
			User u1 = new User("user_id_1", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
		});
		
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			User u1 = new User(null, new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
		});
		assertThrows(NullPointerException.class, () -> {
			@SuppressWarnings("unused")
			User u1 = new User("user_id_1", null);
		});
	}
	
	@Test
	public void testIsPasswordCorrect() {
		User u1 = new User("user_id_1", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
		assertTrue(u1.isPasswordCorrect(new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'}));
		assertFalse(u1.isPasswordCorrect(new char[] {'p', 'a', 'a', 's', 'w', 'o', 'r', 'd'}));
		assertFalse(u1.isPasswordCorrect(new char[] {'P', 'a', 's', 's', 'w', 'o', 'r', 'd'}));
		assertThrows(NullPointerException.class, () -> {
			u1.isPasswordCorrect(null);
		});
	}
	
	@Test
	public void testIsUserIDCorrect() {
		User u1 = new User("user_id_1", new char[] {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'});
		assertTrue(u1.isUserIDCorrect("user_id_1"));
		assertFalse(u1.isUserIDCorrect("user_id_2"));
		assertFalse(u1.isUserIDCorrect("User_id_1"));
		assertThrows(NullPointerException.class, () -> {
			u1.isUserIDCorrect(null);
		});
	}
}
