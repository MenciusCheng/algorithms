package com.menga.algorithms.show;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 *
 * Created by Marvel on 2019/8/29.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] arr) {
        shuffle(arr); // 打乱数组
        sort(arr, 0, arr.length - 1);
    }

    private void sort(T[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int p = partition(arr, head, tail); // 切分
        sort(arr, head, p - 1); // 将左半部分 arr[head..p-1] 排序
        sort(arr, p + 1, tail); // 将右半部分 arr[p+1..tail] 排序
    }

    private void shuffle(T[] arr) {
        List<T> list = Arrays.asList(arr);
        Collections.shuffle(list);
        list.toArray(arr);
    }

    /**
     * 切分
     */
    private int partition(T[] arr, int head, int tail) {
        // 左右扫描指针
        int p1 = head, p2 = tail + 1;
        // 切分元素
        T value = arr[head];
        while (true) {
            // 左指针向右扫描，直到遇到大于等于切分元素的元素
            while (less(arr[++p1], value) && p1 != tail) ;
            // 右指针向左扫描，直到遇到小于等于切分元素的元素
            while (less(value, arr[--p2]) && p2 != head) ;
            if (p1 >= p2) {
                // 左右指针相遇时，退出主循环
                break;
            }
            swap(arr, p1, p2);
        }
        swap(arr, head, p2);

        return p2;
    }
}
