package com.graphs.vianavitor.disjointsset;

/*
    It implements the Disjoint Set using the Quick Union 

    QUICK UNION
    - pros: can be faster than Quick Find to unite the verteces, 
      it depends on the find function
      worst case: O(N²)
      <= O(N²)

    - cons: slower than Quick Find to find the root node
      worst case: O(N)
      <= O(N)
*/
public class QuickJoin {
    private int[] root;

    // it initlizes the root array with indexes as verteces
    public QuickJoin(int size) {
        root = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        // it searches for the root node of X, switching X for its parent node until finding the root node
        while (x != root[x]) {
            x = root[x];
        }
    }

    public union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        // it only replaces the root node of the group to be unified
        if (rootX != rootY) {
            root[rootY] = rootX;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
