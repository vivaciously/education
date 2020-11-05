package net.codingartist.algo_ds.trie;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class TrieTest {
	
	protected Trie trie;
	
	@BeforeEach
	public void init() {
		trie = new Trie();
		System.out.println("called.");
	}
	
	@AfterEach
	public void tearDown() {
		trie = null;
	}
	
	@Test
	public void testAddWord(){
		trie.addWord("apple");
		trie.addWord("app");
		assertTrue(trie.wordCount() == 2);
		assertTrue(trie.contains("apple"));
		assertTrue(trie.contains("app"));
		assertFalse(trie.contains("test"));
		trie.addWord("test");
		trie.addWord("apple");
		trie.addWord("app");
		assertTrue(trie.wordCount() == 3);
		assertTrue(trie.contains("test"));
		assertFalse(trie.contains("tast"));
	}
	
	@Test
	public void testHasPrefix() {
		trie.addWord("apple");
		trie.addWord("app");
		trie.addWord("test");
		trie.addWord("apple");
		trie.addWord("app");
		assertTrue(trie.hasPrefix("ap"));
		assertTrue(trie.hasPrefix("test"));
		assertTrue(trie.hasPrefix("app"));
		assertFalse(trie.hasPrefix("ta"));
	}
	
	@Test
	public void testFindWordsWithPrefix(){
		trie.addWord("apple");
		trie.addWord("app");
		trie.addWord("test");
		trie.addWord("apple");
		trie.addWord("app");
		List<String> words = trie.findWordsWithPrefix("appl");
		for(String word : words){
			System.out.println(word);
		}
	}
	
	@Test
	public void testNumbers(){
		trie.addWord("12310");
		assertTrue(trie.hasPrefix("12"));
		assertTrue(trie.wordCount() == 1);
		assertFalse(trie.hasPrefix("125"));
	}
}
