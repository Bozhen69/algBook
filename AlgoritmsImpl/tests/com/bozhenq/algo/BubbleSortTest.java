package com.bozhenq.algo;

import org.junit.Assert;
import org.junit.Test;

public class BubbleSortTest extends Assert {
    @Test
    public void BubbleSort(){
        Integer[] mass = new Integer[]{5, 4, 3, 6, 7, 8};
        BubbleSort.sort(mass);
        assertArrayEquals(new Integer[]{3, 4, 5, 6, 7, 8}, mass);
    }
}
