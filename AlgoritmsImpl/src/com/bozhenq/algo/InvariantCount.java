package com.bozhenq.algo;

import java.lang.reflect.Array;

public class InvariantCount {

    public static <T extends Comparable<T>> int sortByMerge(T[] mass, Class<T> tClass) {
        return sortByMerge(mass,0,mass.length-1,tClass);
    }


    /**
     * @param mass   sorting massive
     * @param start  start element index for sort
     * @param end    end element index for sort
     * @param tClass class elements of sorting massive
     * @param <T>    Type of massive elements, should extends from Comparable
     */
    private static <T extends Comparable<T>> int sortByMerge(T[] mass, int start, int end, Class<T> tClass) {
        if (start < end) { // if its not 1 elem massive
            int middle = (start + end) / 2; // find middle element
            int left = sortByMerge(mass, start, middle, tClass); // recurs for mass[start.. middle], after this we have ordered massive on this position
            int right = sortByMerge(mass, middle + 1, end, tClass); //recurs for mass [middle+1.. end], after this we have ordered massive on this position
            return merge(mass, start, middle, end, tClass) + left + right; // merge this massive's
        }
        return 0;
    }

    /**
     * @param mass   sorting massive
     * @param start  start element index of ordered massive
     * @param middle middle element index of ordered massive
     * @param end    end element index of ordered massive
     * @param tClass class elements of sorting massive
     * @param <T>    Type of massive elements, should extends from Comparable
     */
    private static <T extends Comparable<T>> int merge(T[] mass, int start, int middle, int end, Class<T> tClass) {
        T[] mass1 = (T[]) Array.newInstance(tClass, middle - start + 1); // massive for ordered elements of mass[start..middle]
        T[] mass2 = (T[]) Array.newInstance(tClass, end - middle); // massive for ordered elements of mass[middle+1..end]
        System.arraycopy(mass, start, mass1, 0, mass1.length);
        System.arraycopy(mass, middle + 1, mass2, 0, mass2.length);
        int i = 0;
        int j = 0;
        int inv = 0;
        while (i < mass1.length && j < mass2.length) { //while we have element in anyone mass
            if (mass1[i].compareTo(mass2[j]) > 0) {    //find smallest element of two massive (cause we have ordered massive's its element of this massive's with smallest index)
                mass[start] = mass2[j];
                inv+=mass1.length-i;
                j++;
            } else {
                mass[start] = mass1[i];
                i++;
            }
            start++;
        }
        while (i < mass1.length) {
            // when we insert all elements from one of the massive's, we just insert last elements from last ordered massive
            mass[start] = mass1[i];
            if(mass[start].compareTo(mass[start-1])>0){
                inv+=mass2.length-j;
            }
            i++;
            start++;
        }
        while (j < mass2.length) {
            mass[start] = mass2[j];
            j++;
            start++;
        }
        return inv;
    }
}
