package com.menga.algorithms.show;

/**
 * Created by Marvel on 2019/8/29.
 */
public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] arr);

    protected boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(T[] a, int i, int j) {
        T t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public void print(T[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            System.out.print("\t");
        }
        System.out.println();
    }

    public void printIndex(T[] a) {
        System.out.print(" \t \t \t");
        for (int i = 0; i < a.length; i++) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
        System.out.print("---\t---\t-\t");
        for (int i = 0; i < a.length; i++) {
            System.out.print("-");
            System.out.print("\t");
        }
        System.out.println();
    }
}
