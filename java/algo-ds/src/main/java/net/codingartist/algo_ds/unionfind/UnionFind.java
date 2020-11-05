package net.codingartist.algo_ds.unionfind;

public class UnionFind {

	private int[] array;
    private int[] size;
    
    public UnionFind(int n) {
    	if(n < 2) {
    		throw new IllegalArgumentException("The number of elements should be greater than or equal to 2");
    	}
        array = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++) {
            array[i] = i;
            size[i] = 1;
        }
    }
    
    private int root(int i) {
        while(i != array[i]) {
            i = array[array[i]];
        }
        return i;
    }
    
    public boolean find(int i, int j) {
    	validateIndices(i,j);
        return root(i) == root(j);
    }
    
    public boolean union(int i, int j) {
    	validateIndices(i,j);
        int root_i = root(i);
        int root_j = root(j);
        if(root_i != root_j) {
            if(size[root_i] > size[root_j]) {
                array[root_j] = root_i;
                size[root_i] += size[root_j];
            } else {
                array[root_i] = root_j;
                size[root_j] += size[root_i];
            }
            return true;
        }
        return false;
    }
    
    protected void validateIndices(int i, int j) {
    	if(!checkRange(i) || !checkRange(j)) {
    		throw new IllegalArgumentException("Given Index is invalid: i " + i + " j: " + j);
    	}
    }
    
    protected boolean checkRange(int i) {
    	if(i <0 || i >= array.length) {
    		return false;
    	}
    	return true;
    }
}
