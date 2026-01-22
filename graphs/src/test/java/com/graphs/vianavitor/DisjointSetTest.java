package com.graphs.vianavitor;

import com.graphs.vianavitor.disjointsset.QuickFind;
import com.graphs.vianavitor.disjointsset.QuickUnion;
import com.graphs.vianavitor.disjointsset.UnionByRank;

import org.junit.Test;

public class DisjointSetTest {
    @Test
    public void QuickUnionTest() {
        QuickUnion qu = new QuickUnion(6);

        qu.union(0, 1);
        qu.union(1, 3);
        qu.union(0, 2);

        qu.union(4, 5);
        qu.union(4, 5);

        qu.display();
        
        assert(false == qu.isConnected(5, 1));
    }

    @Test
    public void QuickFindTest() {
        QuickFind qf = new QuickFind(6);

        qf.union(0, 1);
        qf.union(1, 3);
        qf.union(0, 2);

        qf.union(4, 5);
        qf.union(4, 5);

        qf.display();
        
        assert(true == qf.isConnected(0, 3));
    }

    @Test
    public void UnionByRankTest() {
        UnionByRank ubr = new UnionByRank(6);

        ubr.union(0, 1);
        ubr.union(1, 3);
        ubr.union(0, 2);

        ubr.union(4, 5);
        ubr.union(4, 5);
        
        ubr.display();

        assert(false == ubr.isConnected(5, 1));
    }
}
