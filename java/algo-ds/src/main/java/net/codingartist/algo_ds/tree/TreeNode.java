package net.codingartist.algo_ds.tree;

public class TreeNode<E> {

	protected TreeNode<E> left;
	protected TreeNode<E> right;
	protected E val;
	
	/*
	 * public methods are provided to be compatible with encapsulation 
	 * for the usage outside of the package.
	 * 
	 */
	public TreeNode(E val) {
		this.val = val;
	}
	
	public TreeNode<E> left() {
		return left;
	}
	
	public TreeNode<E> right() {
		return right;
	}
	
	public E value() {
		return val;
	}
	
	public void setValue(E val) {
		this.val = val;
	}
}
