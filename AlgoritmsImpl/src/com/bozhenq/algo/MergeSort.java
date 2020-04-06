package com.bozhenq.algo;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MergeSort {

    /**
     * @param mass   sorting massive
     * @param start  start element index for sort
     * @param end    end element index for sort
     * @param tClass class elements of sorting massive
     * @param <T>    Type of massive elements, should extends from Comparable
     */
    public static <T extends Comparable<T>> void sortByMerge(T[] mass, int start, int end, Class<T> tClass) {
        if (start < end) { // if its not 1 elem massive
            int middle = (start + end) / 2; // find middle element
            sortByMerge(mass, start, middle, tClass); // recurs for mass[start.. middle], after this we have ordered massive on this position
            sortByMerge(mass, middle + 1, end, tClass); //recurs for mass [middle+1.. end], after this we have ordered massive on this position
            merge(mass, start, middle, end, tClass); // merge this massive's
        }
    }

    /**
     * @param mass   sorting massive
     * @param start  start element index of ordered massive
     * @param middle middle element index of ordered massive
     * @param end    end element index of ordered massive
     * @param tClass class elements of sorting massive
     * @param <T>    Type of massive elements, should extends from Comparable
     */
    private static <T extends Comparable<T>> void merge(T[] mass, int start, int middle, int end, Class<T> tClass) {
        T[] mass1 = (T[]) Array.newInstance(tClass, middle - start + 1); // massive for ordered elements of mass[start..middle]
        T[] mass2 = (T[]) Array.newInstance(tClass, end - middle); // massive for ordered elements of mass[middle+1..end]
        System.arraycopy(mass, start, mass1, 0, mass1.length);
        System.arraycopy(mass, middle + 1, mass2, 0, mass2.length);
        int i = 0;
        int j = 0;
        while (i < mass1.length && j < mass2.length) { //while we have element in anyone mass
            if (mass1[i].compareTo(mass2[j]) > 0) {    //find smallest element of two massive (cause we have ordered massive's its element of this massive's with smallest index)
                mass[start] = mass2[j];
                j++;
            } else {
                mass[start] = mass1[i];
                i++;
            }
            start++;
        }
        while (i < mass1.length) { // when we insert all elements from one of the massive's, we just insert last elements from last ordered massive
            mass[start] = mass1[i];
            i++;
            start++;
        }
        while (j < mass2.length) {
            mass[start] = mass2[j];
            j++;
            start++;
        }
    }

    /**
     * @param mass       massive of T elements for searching
     * @param searchElem search Elem
     * @param start      start position for search
     * @param end        end position for search
     * @param <T>        Elements type of massive
     * @return return -1 if element not exist in massive or otherwise index of search elem
     */
    public static <T extends Comparable<T>> int binarySearch(T[] mass, T searchElem, int start, int end) {
        if (start <= end) {
            int middle = (start + end) / 2;
            int resultSearch = mass[middle].compareTo(searchElem);
            if (resultSearch == 0) {
                return middle;
            }
            return resultSearch > 0 ? binarySearch(mass, searchElem, start, middle - 1) : binarySearch(mass, searchElem, middle + 1, end);
        }
        return -1;
    }

    /**
     * @param mass researched massive
     * @param elem researched element
     * @return return TRUE if  mass have two elements the sum of which equals to elem
     */
    public static boolean searchAlg(Integer[] mass, Integer elem) {
        Integer[] dest = new Integer[mass.length];
        System.arraycopy(mass, 0, dest, 0, dest.length);
        sortByMerge(dest, 0, dest.length - 1, Integer.class);
        int j = 0;
        for (Integer i : dest) {
            if (binarySearch(dest, elem - i, 0, j - 1) != -1 || binarySearch(dest, elem - i, j + 1, dest.length - 1) != -1) {
                return true;
            }
            j++;
        }
        return false;
    }
}
