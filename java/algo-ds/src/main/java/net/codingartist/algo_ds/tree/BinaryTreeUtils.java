package net.codingartist.algo_ds.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeUtils {
	
	private BinaryTreeUtils() {
		throw new AssertionError("non instantiability");
	}
	
	public static <E> int height(TreeNode<E> node) {
		if(node == null) {
			return 0;
		}
		return 1 + Math.max(height(node.left), height(node.right)); 
	}
	
	public static <E> int depth(TreeNode<E> root) {
		if(root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return 1 + Math.max(left, right);
	}
	
	public static <E> int diameter(TreeNode<E> root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight + rightHeight, Math.max(diameter(root.left), diameter(root.right)));
	}
	
	public static <E> TreeNode<E> build(List<E> src, int left, int right) {
		if(left > right) {
			return null;
		}
		int mid = left + (right - left) / 2;
		TreeNode<E> root = new TreeNode<>(src.get(mid));
		root.left = build(src, left, mid -1);
		root.right = build(src, mid+1, right);
		return root;
	}
	
	public static <E> boolean isBalanced(TreeNode<E> root) {
		return true;
	}
	
	
	public static <E> List<E> toList(TreeNode<E> root, TraversingMethod method) {
		if(method == TraversingMethod.BFS) {
			return bfs(root);
		} else if(method == TraversingMethod.PREORDER) {
			return preorder(root);
		} else if(method == TraversingMethod.POSTORDER) {
			return postorder(root);
		} else if(method == TraversingMethod.INORDER){
			return inorder(root);
		}
		throw new IllegalArgumentException("TraversingMethod is not specified: " + method);
	}
	
	private static <E> List<E> bfs(TreeNode<E> root) {
		if(root == null) {
			return Collections.emptyList();
		}
		List<E> results = new ArrayList<>();
		Deque<TreeNode<E>> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode<E> n = queue.poll();
			if(n.val != null) {
				results.add(n.val);
			}
			if(n.left != null) {
				queue.offer(n.left);
			}
			if(n.right != null) {
				queue.offer(n.right);
			}
		}
		return results;
	}
	
	public static <E> List<E> preorder(TreeNode<E> root) {
		if(root == null) {
			return Collections.emptyList();
		}
		List<E> results = new ArrayList<>();
		preorder(root, results);
		return results;
	}
	
	private static <E> void preorder(TreeNode<E> n, List<E> results) {
		if(n == null) {
			return;
		}
		results.add(n.val);
		preorder(n.left, results);
		preorder(n.right, results);
	}
	
	public static <E> List<E> postorder(TreeNode<E> root) {
		if(root == null) {
			return Collections.emptyList();
		}
		List<E> results = new ArrayList<>();
		postorder(root, results);
		return results;
	}
	
	private static <E> void postorder(TreeNode<E> n, List<E> results) {
		if(n == null) {
			return;
		}
		postorder(n.left, results);
		postorder(n.right, results);
		results.add(n.val);
	}
	
	public static <E> List<E> inorder(TreeNode<E> root) {
		if(root == null) {
			return Collections.emptyList();
		}
		List<E> results = new ArrayList<>();
		inorder(root, results);
		return results;
	}
	
	private static <E> void inorder(TreeNode<E> n, List<E> results) {
		if(n == null) {
			return;
		}
		inorder(n.left, results);
		results.add(n.val);
		inorder(n.right, results);
	}
	
	public static <E> boolean equals(TreeNode<E> root1, TreeNode<E> root2) {
		if(root1 == root2) {//check identity
			return true;
		}
		if(root1 == null && root2 == null) {
			return true;
		} else if(root1 == null || root2 == null) {
			return false;
		} 
		if(root1.val == null && root2.val == null) {
			return equals(root1.left, root2.left) && equals(root1.right, root2.right);
		}
		if(!root1.val.equals(root2.val)) {
			return false;
		}
		return equals(root1.left, root2.left) && equals(root1.right, root2.right);
	}
	
	public static <E> TreeNode<E> copy(TreeNode<E> root) {
		return copy(root, new HashMap<>());
	}
	
	private static <E> TreeNode<E> copy(TreeNode<E> n, Map<TreeNode<E>, TreeNode<E>> map) {
		if(n == null) {
			return null;
		} else if(map.containsKey(n)) {
			return map.get(n);
		}
		TreeNode<E> cloned = new TreeNode<>(n.val);
		cloned.left = copy(n.left, map);
		cloned.right = copy(n.right, map);
		map.put(n, cloned);
		return cloned;
	}
	
	public static <E> TreeNode<E> find(TreeNode<E> root,  E target) {
		if(root == null) {
			return null;
		}
		Deque<TreeNode<E>> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode<E> n = queue.poll();
			if(n.val != null && n.val.equals(target)) {
				return n;
			}
			if(n.left != null) {
				queue.offer(n.left);
			}
			if(n.right != null) {
				queue.offer(n.right);
			}
		}
		return null;
	}
	
	public static <E> List<TreeNode<E>> findAll(TreeNode<E> root, E target) {
		if(root == null) {
			return Collections.emptyList();
		}
		List<TreeNode<E>> results = new ArrayList<>();
		Deque<TreeNode<E>> queue = new ArrayDeque<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			TreeNode<E> n = queue.poll();
			if(n.val != null && n.val.equals(target)) {
				results.add(n);
			}
			if(n.left != null) {
				queue.offer(n.left);
			}
			if(n.right != null) {
				queue.offer(n.right);
			}
		}
		return results;
	}
	
	public static String encode(TreeNode<Integer> root) {//currently support only Integer
		StringBuilder sb = new StringBuilder();
		if(root == null) {
			sb.append("null");
			return sb.toString();
		}
		serialize(root, sb);
		sb.setLength(sb.length() -1);//remove the last comma
		return sb.toString();
	}
	
	private static <E> void serialize(TreeNode<E> n, StringBuilder sb) {
		if(n == null) {
			sb.append("null");
			sb.append(",");
			return;
		}
		sb.append(n.val);
		sb.append(",");
		serialize(n.left, sb);
		serialize(n.right, sb);
	}
	
	public static TreeNode<Integer> decode(String src) {
		if(src == null || src.length() == 0) {
			return null;
		}
		String[] data = src.split(",");
		int[] index = {0};
		return deserialize(data, index);
	}
	
	private static TreeNode<Integer> deserialize(String[] data, int[] index) {
		if(index[0] == data.length) {
			return null;
		}
		if(data[index[0]].equals("null")) {
			index[0]++;
			return null;
		}
		TreeNode<Integer> root = new TreeNode<>(Integer.valueOf(data[index[0]++]));
		root.left = deserialize(data, index);
		root.right = deserialize(data, index);
		return root;
	}
	
	public static <E> String toString(TreeNode<E> root) {
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		sb.setLength(sb.length() -1);//remove the last comma
		return sb.toString();
	}
	
	
}
