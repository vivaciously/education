package net.codingartist.algo_ds.unionfind;

public class UnionFind {

	private int[] array;
    private int[] size;
    
    public UnionFind(int n) {
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
        return root(i) == root(j);
    }
    
    public boolean union(int i, int j) {
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
}
