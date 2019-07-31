package com.menga.algorithms.sort;

/**
 * 插入排序
 *
 * Created by Marvel on 2019/7/30.
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            //
            for (int j = i; j > 0 && SortDemo.less(a[j], a[j - 1]); j--) {
                SortDemo.exchange(a, j, j - 1);
            }
        }
    }

}
