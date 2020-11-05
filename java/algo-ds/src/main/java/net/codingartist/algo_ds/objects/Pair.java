package net.codingartist.algo_ds.objects;

import java.io.Serializable;
public class Pair<K, V> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected K first;
	protected V second;
	
	public Pair(K first, V second){
		this.setFirst(first);
		this.setSecond(second);
	}

	public K getFirst() {
		return first;
	}

	public void setFirst(K first) {
		this.first = first;
	}

	public V getSecond() {
		return second;
	}

	public void setSecond(V second) {
		this.second = second;
	}
	
	@Override
	public boolean equals(Object obj){
		if(obj instanceof Pair){
			if(this == obj){//check identity
				return true;
			}
			@SuppressWarnings("unchecked")
			Pair<K,V> pair = (Pair<K,V>)obj;
			if(this.first != null && pair.getFirst() != null && this.first.equals(pair.getFirst())){
				return (this.second != null && pair.getSecond() != null && this.second.equals(pair.getSecond()));
			}
		}
		return false;
	}
	
	
	@Override
	public int hashCode(){
		int result = 17;
		result = result*31 + (first != null ? first.hashCode() : 0);
		result = result*31 + (second != null ? second.hashCode() : 0);
		return result;
	}
	
	
}
