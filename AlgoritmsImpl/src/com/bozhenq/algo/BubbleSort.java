package com.bozhenq.algo;


public class BubbleSort {
    /**
     *
     * @param mass massive for sorting
     * @param <T> type of massive elements
     */
    public static <T extends Comparable<T>>void sort(T[] mass) {
        for(int i=0;i<mass.length-2;i++){
           for(int j=mass.length-1;j>=i+1;j--){
               if(mass[j].compareTo(mass[j-1])<0){
                   T buff = mass[j];
                   mass[j] = mass[j-1];
                   mass[j-1] = buff;
               }
           }
        }
    }
}
