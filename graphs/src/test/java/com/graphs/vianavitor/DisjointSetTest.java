package com.graphs.vianavitor;

import com.graphs.vianavitor.disjointsset;
import com.graphs.vianavitor.disjointsset.QuickJoin;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class DisjointSetTest {
    @Test
    public void QuickUnionTest() {
        QuickJoin qu = new QuickJoin(5);

        qu.union(0, 1);
        qu.union(1, 3);
        qu.union(0, 2);

        qu.union(4, 5);
        qu.union(4, 6);
        
        assert(false == qu.isConnected(5, 1));
        System.out.println("next test ->");
        assert(true == qu.isConnected(0, 3));
    }

    @Test
    public void QuickFindTest() {
        QuickJoin qf = new QuickJoin(5);

        qf.union(0, 1);
        qf.union(1, 3);
        qf.union(0, 2);

        qf.union(4, 5);
        qf.union(4, 6);
        
        assert(false == qf.isConnected(5, 1));
        System.out.println("next test ->");
        assert(true == qf.isConnected(0, 3));
    }
}
