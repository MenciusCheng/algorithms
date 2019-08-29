package com.menga.algorithms.sort2;

/**
 * Created by Marvel on 2019/8/29.
 */
public class TestSort {

    public static void main(String[] args) {
        Integer[] arr = {3, 6, 2, 1, 4, 8, 5};
        TestSort.print(arr);

        Sort<Integer> s = new Insertion<Integer>();
        s.sort(arr);

//        TestSort.print(arr);
    }

    public static void print(Object[] arr) {
        for (Object i : arr) {
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
    }
}
