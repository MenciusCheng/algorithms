package com.menga.algorithms.show;

/**
 * 希尔排序
 *
 * Created by Marvel on 2019/8/29.
 */
public class Shell<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public void sortShow(T[] nums) {

        int N = nums.length;
        int h = 1;

        while (h < N / 3) {
            h = 3 * h + 1; // 1, 4, 13, 40, ...
        }

        while (h >= 1) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(nums[j], nums[j - h]); j -= h) {
                    System.out.print("h=" + h + "\ti=" + i + "\tj=" + j + "\t|\t");
                    swap(nums, j, j - h);
                    print(nums);
                }
            }
            h = h / 3;
        }
    }
}
