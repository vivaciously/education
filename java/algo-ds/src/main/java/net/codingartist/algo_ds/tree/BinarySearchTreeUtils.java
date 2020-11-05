package net.codingartist.algo_ds.tree;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearchTreeUtils {

	private BinarySearchTreeUtils() {
		throw new AssertionError("Non instantiability");
	}
	
	public static <E extends Comparable<? super E>> TreeNode<E> buildBST(List<E> src) {
		List<E> distinct = src.stream().distinct().collect(Collectors.toList());
		Collections.sort(distinct);
		return buildBST(distinct, 0, distinct.size() -1);
	}
	
	private static <E extends Comparable<? super E>> TreeNode<E> buildBST(List<E> src, int left, int right) {
		if(left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode<E> root = new TreeNode<>(src.get(mid));
		root.left = buildBST(src, left, mid -1);
		root.right = buildBST(src, mid+1, right);
		return root;
	}
}
