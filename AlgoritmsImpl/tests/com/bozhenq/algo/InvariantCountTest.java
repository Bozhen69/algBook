package com.bozhenq.algo;

import org.junit.Assert;
import org.junit.Test;

import static com.bozhenq.algo.InvariantCount.sortByMerge;


public class InvariantCountTest extends Assert {
    @Test
    public void testInvariant(){
        assertEquals(12,sortByMerge(new Integer[]{7,7,7,7,1,1,1},Integer.class)); //3*4
        assertEquals(15,sortByMerge(new Integer[]{7,8,1,5,3,3,1},Integer.class)); //5+5+3+1+1
    }
}
