package com.bozhenq.algo;

public class BinarySummat {
    /**
     * @param a first presenter massive of binary number
     * @param b second presenter massive of binary number
     * @return result presenter massive of binary summ this numbers
     */
    public static int[] binarySumatra(int[] a, int[] b) {
        if (a.length != b.length)
            throw new RuntimeException("A length should be like B length");
        int[] c = new int[a.length + 1];
        int summ = 0;
        for (int i = a.length - 1; i >= 0; i--) {
            summ += a[i] + b[i];
            c[i + 1] = summ % 2;
            summ = summ / 2;
        }
        c[0] = summ;
        return c;
    }
}
