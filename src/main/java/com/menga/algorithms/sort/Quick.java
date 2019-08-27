package com.menga.algorithms.sort;

/**
 * Created by Marvel on 2019/8/15.
 */
public class Quick {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1); // 讲左半部分 a[lo .. j-1] 排序
        sort(a, j + 1, hi); // 讲右半部分 a[j+1 .. hi] 排序
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        // 将数组切分为 a[lo .. i-1], a[i], a[i+1 .. hi]
        int i = lo, j = hi + 1; // 左右扫描指针
        Comparable v = a[lo]; // 切分元素
        while (true) {
            while (SortDemo.less(a[++i], v)) {
                if (i == hi) break;
            }
            while (SortDemo.less(v, a[--j])) {
                if (j == lo) break;
            }
            if (i >= j) break;
            SortDemo.exchange(a, i, j);
        }
        SortDemo.exchange(a, lo, j);
        return j;
    }
}
