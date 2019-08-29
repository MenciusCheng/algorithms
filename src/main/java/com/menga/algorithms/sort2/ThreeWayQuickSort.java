package com.menga.algorithms.sort2;

/**
 * 三向切分快速排序
 *
 * Created by Marvel on 2019/8/29.
 */
public class ThreeWayQuickSort<T extends Comparable<T>> extends QuickSort<T> {

    public void sort(T[] nums, int l, int h) {
        if (h <= l) {
            return;
        }
        int lt = l, i = l + 1, gt = h;
        T v = nums[l];
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) {
                swap(nums, lt++, i++);
            } else if (cmp > 0) {
                swap(nums, i, gt--);
            } else {
                i++;
            }
        }
        sort(nums, l, lt - 1);
        sort(nums, gt + 1, h);
    }
}
