package net.codingartist.algo_ds.trie;

import java.util.ArrayList;
import java.util.List;


public class TrieNode {

	public static final char NULL_CHARACTER = '*';
	private static final int ALPHABET_SIZE = 27;//26 + 1
	private static final int NUMBERS_SIZE = 10; // 0 - 9
	private Character value;
	private TrieNode[] children;
	
	public TrieNode(){
		value = null;
		children = new TrieNode[ALPHABET_SIZE + NUMBERS_SIZE];
	}
	
	public TrieNode(Character value){
		this.value = value;
		children = new TrieNode[ALPHABET_SIZE + NUMBERS_SIZE];
	}
	
	public Character getValue(){
		return value;
	}
	
	public void setValue(Character c){
		this.value = c;
	}
	
	public void addChild(Character c){
		int index = getIndex(c);
		if(children[index] == null){
			children[getIndex(c)] = new TrieNode(c);
		}
	}
	
	public List<TrieNode> getNonNullChildren(){
		List<TrieNode> nodes = new ArrayList<>();
		for(int i=0; i<ALPHABET_SIZE-1; i++){
			if(children[i] != null){
				nodes.add(children[i]);
			}
		}
		return nodes;
	}
	
	public TrieNode getChild(Character c){
		return children[getIndex(c)];
	}
	
	public boolean isTerminating(){
		return children[getIndex(NULL_CHARACTER)] != null;
	}
	
	protected int getIndex(Character c){
		assert(c != null);
		if(c.equals(NULL_CHARACTER)) {
			return ALPHABET_SIZE -1;
		}else if(Character.isDigit(c)){
			int index =  c - '0' + ALPHABET_SIZE;
			assert(index >=  ALPHABET_SIZE && index <  ALPHABET_SIZE + NUMBERS_SIZE);
			return index;
		}
		char ch = Character.toLowerCase(c);
		int index = ch - 'a';
		assert(index >=0 && index < ALPHABET_SIZE);
		return index;
	}
	
}