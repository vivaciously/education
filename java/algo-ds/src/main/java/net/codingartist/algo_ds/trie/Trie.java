package net.codingartist.algo_ds.trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	//Currently the Trie class supports English alphabets in lowercase and numbers only.
	private TrieNode root;
	private int wordCount;
	
	public Trie(){
		root = new TrieNode();
		wordCount = 0;
	}
	
	public int wordCount(){
		return wordCount;
	}
	
	public void addWord(String word){
		TrieNode pointer = root;
		for(char c : word.toLowerCase().toCharArray()){
			pointer.addChild(c);
			pointer = pointer.getChild(c);
		}
		if(!pointer.isTerminating()){
			++wordCount;
			pointer.addChild(TrieNode.NULL_CHARACTER);
		}
	}
	
	public boolean contains(String word){
		TrieNode pointer = prefixNode(word);
		if(pointer == null) {
			return false;
		}
		return pointer.isTerminating();
	}
	
	public boolean hasPrefix(String prefix){
		TrieNode pointer = prefixNode(prefix);
		return pointer == null ? false : true;
	}
	
	public List<String> findWordsWithPrefix(String prefix){
		List<String> words = new ArrayList<>();
		TrieNode pointer = prefixNode(prefix);
		if(pointer == null){
			return words;
		}
		
		findwordsWithPrefixHelper(pointer, prefix, words);
		return words;
	}
	
	protected void findwordsWithPrefixHelper(TrieNode prefixNode, String prefix, List<String> words){
		if(prefixNode.isTerminating()){
			words.add(prefix);
		}
		StringBuffer sb = new StringBuffer();
		sb.append(prefix);
		findWordsWithPrefixHelper(prefixNode, sb, words);
	}
	
	protected void findWordsWithPrefixHelper(TrieNode prefixNode, StringBuffer sb, List<String> words){
		for(TrieNode node : prefixNode.getNonNullChildren()){
			sb.append(node.getValue());
			if(node.isTerminating()){
				words.add(sb.toString());
				sb.deleteCharAt(sb.length()-1);
			}
			findWordsWithPrefixHelper(node, sb, words);
		}
	}
	
	
	public void addWords(List<String> words){
		for(String word : words){
			addWord(word);
		}
	}
	
	public void addWords(String[] words){
		for(String word : words){
			addWord(word);
		}
	}
	
	protected TrieNode prefixNode(String prefix){
		TrieNode pointer = root;
		for(char c : prefix.toLowerCase().toCharArray()){
			pointer = pointer.getChild(c);
			if(pointer == null) {
				return null;
			}
		}
		return pointer;
	}
	
}//End of Trie