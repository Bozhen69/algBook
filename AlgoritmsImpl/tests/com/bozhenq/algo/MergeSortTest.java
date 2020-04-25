package com.bozhenq.algo;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {
    @Test
    public void mergeSortTest() {
        Integer[] mass = new Integer[]{5, 4, 3, 6, 7, 8};
        MergeSort.sortByMerge(mass, 0, mass.length - 1, Integer.class);
        assertArrayEquals(new Integer[]{3, 4, 5, 6, 7, 8}, mass);
        assertEquals(-1, MergeSort.binarySearch(mass, 10, 0, mass.length - 1));
        assertEquals(0, MergeSort.binarySearch(mass, 3, 0, mass.length - 1));
        assertEquals(mass.length - 1, MergeSort.binarySearch(mass, 8, 0, mass.length - 1));
        assertTrue(MergeSort.searchAlg(mass, 9));
        assertFalse(MergeSort.searchAlg(mass, 16));
    }
    
    @Test
    public void mergeUpgradeSortTest() {
        Integer[] mass = new Integer[]{5, 4, 3, 6, 7, 8, 1, 2, 3};
        MergeSort.sortByMergeWithInsert(mass, 0, mass.length - 1, Integer.class);
        assertArrayEquals(new Integer[]{1, 2, 3, 3, 4, 5, 6, 7, 8}, mass);
    }
}
