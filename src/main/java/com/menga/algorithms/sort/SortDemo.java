package com.menga.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvel on 2019/7/30.
 */
public class SortDemo {

    public static void sort(Comparable[] a) {
//        SelectionSort.sort(a);
//        InsertionSort.sort(a);
        new Shell().sort(a);
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        StringBuffer sb = new StringBuffer();
        for (Comparable item : a) {
            sb.append(item).append(" ");
        }
        System.out.println(sb);
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (less(a[i + 1], a[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = { "a", "c", "d", "e", "b", "h", "z", "u", "s", "q", "k" };

        sort(a);
        System.out.println("isSorted: " + String.valueOf(isSorted(a)));
        show(a);
    }
}
