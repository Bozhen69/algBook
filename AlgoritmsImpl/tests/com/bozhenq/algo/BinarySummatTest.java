package com.bozhenq.algo;

import org.junit.Assert;
import org.junit.Test;

public class BinarySummatTest extends Assert {
    @Test
    public void summatorBinaryArrays() {
        int[] mass1 = new int[]{0, 1};
        int[] mass2 = new int[]{1, 1};
        assertArrayEquals(new int[]{1, 0, 0}, BinarySummat.binarySumatra(mass1, mass2));
    }
}
