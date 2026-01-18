package com.graphs.vianavitor.disjointsset;

/*
    It implements the Disjoint Set using the Quick Find 

    QUICK FIND
    - pros: fast to find out if the vertices are connected, because 
      it stores the root node of each group instead of the parent node; 
      O(1)

    - cons: slow to unite vertices, because when unifying graphs, 
      it needs to replace the former root nodes with the new ones, 
      iterating over the entire root array; 
      O(N)
*/
public class QuickFind {
    private int[] root;

    // it initlizes the root array with indexes as vertices
    public QuickFind(int size) {
        root = new int[size];

        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        if (rootX != rootY) {
            // X is always chosen to be the root node of the group
            for (int i = 0; i < root.length; i++) {
                if (root[i] == rootY) {
                    root[i] = rootX;
                }
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
