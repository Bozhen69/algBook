package com.bozhenq.algo;

public class InsertionSort {
    /**
     * @param mass massive for sorting operation
     * @param <T>  type of massive elements, should extends from Comparable
     */
    public static <T extends Comparable<T>> void sortByInsertion(T[] mass) {
        sortByInsertionForMerge(mass,0,mass.length-1);
    }

    /**
     * @param mass massive for sorting operation
     * @param <T>  type of massive elements, should extends from Comparable
     * @param start index of start element for sort
     * @param end index of end element for sort that included in sort
     */
    public static <T extends Comparable<T>> void sortByInsertionForMerge(T[] mass, int start, int end) {
        for (int i = start; i <= end; i++) {
            T key = mass[i]; // Get the key element for current iteration
            int j = i - 1; // cursor for moving from sorted array to find place for insert key element
            while (j >= 0 && mass[j].compareTo(key) > 0) { // while key element smaller that mass element
                mass[j + 1] = mass[j]; // swap element
                j--; // move to next element
            }
            //when we find correct position go swap
            mass[j + 1] = key;
        }
    }

}
