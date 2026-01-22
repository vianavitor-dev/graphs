package com.graphs.vianavitor.disjointsset;

/*
    It implements the Disjoint Set using the Union by Rank

    UNION BY RANK
    - pros: it optimizes the Quick Union by keeping the tree flat
        worst case: O(N log N)
        <= O(N log N)

    - cons: it uses extra space for the rank array
        space complexity: O(N)
*/
public class UnionByRank {
    private int[] root;
    private int[] rank;

    // it initlizes both root and rank arrays with indexes as verteces
    public UnionByRank(int size) {
        root = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        // it searches for the root node of X, switching X for its parent node until finding the root node
        while (x != root[x]) {
            x = root[x];
        }

        return x;
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        
        // it replaces the root node of the group to be unified based on the rank of each tree
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;

            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;

            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public void display() {
        for (int i = 0; i < root.length; i++) {
            System.out.println("node: " + i + " root: " + root[i] + " rank: " + rank[i]);
        }
    }
}
