package com.menga.algorithms.show;

/**
 * Created by Marvel on 2019/9/17.
 */
public class SortDemo {

    public static void main(String[] args) {
//        Integer[] a = {6, 4, 1, 2};
//        new Insertion<Integer>().sortShow(a);

//        Integer[] a2 = {5, 11, 7, 9, 2, 3, 12, 8, 6, 1, 4, 10};
//        new Insertion<Integer>().sortShow(a2);
//        System.out.println("--------------");

        Integer[] a = {5, 11, 7, 9, 2, 3, 12, 8, 6, 1, 4, 10};
//        new Shell<Integer>().sortShow(a);

//        print(a);
//        new MergeSort<Integer>().upToDownSort(a);
        new QuickSort<Integer>().sortShow(a);
//        print(a);
    }

    public static void print(Object[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            System.out.print("\t");
        }
        System.out.println();
    }
}
