package com.menga.algorithms.sort;

/**
 * 选择排序
 *
 * Created by Marvel on 2019/7/30.
 */
public class SelectionSort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            System.out.println("i = " + i);
            // 最小元素的索引
            int min = i;
            for (int j = i + 1; j < n; j++) {
                System.out.print(a[min].toString() + " <> " + a[j].toString() + ", ");
                if (SortDemo.less(a[j], a[min])) min = j;
            }
            if (i != min) {
                SortDemo.exchange(a, i, min);
            }
            System.out.println();
        }
    }
}
