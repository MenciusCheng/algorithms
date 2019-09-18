package com.menga.algorithms.show;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 快速排序
 *
 * Created by Marvel on 2019/8/29.
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        print(nums);
        shuffle(nums);
        print(nums);
        sort(nums, 0, nums.length - 1);
    }

    private void sort(T[] nums, int head, int tail) {
        if (tail <= head)
            return;
        int p = partition(nums, head, tail); // 切分
        sort(nums, head, p - 1); // 将左半部分 arr[head..p-1] 排序
        sort(nums, p + 1, tail); // 将右半部分 arr[p+1..tail] 排序
    }

    private void shuffle(T[] nums) {
        List<T> list = Arrays.asList(nums);
        Collections.shuffle(list);
        list.toArray(nums);
    }

    /**
     * 切分
     */
    private int partition(T[] nums, int head, int tail) {
        // 将数组切分为 a[head..i-1], a[i], a[i+1..tail]
        // 左右扫描指针
        int p1= head, p2 = tail + 1;
        // 切分元素
        T v = nums[head];
        while (true) {
            while (less(nums[++p1], v) && p1 != tail) ;
            while (less(v, nums[--p2]) && p2 != head) ;
            if (p1 >= p2)
                break;
            swap(nums, p1, p2);
            print(nums, p1, p2);
        }
        swap(nums, head, p2);
        print(nums, p1, p2);

        return p2;
    }
}
