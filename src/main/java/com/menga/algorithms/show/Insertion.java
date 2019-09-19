package com.menga.algorithms.show;

/**
 * 插入排序
 *
 * Created by Marvel on 2019/8/29.
 */
public class Insertion<T extends Comparable<T>> extends AbstractSort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public void sortShow(T[] nums) {
        printIndex(nums);
        System.out.print("   \t   \t|\t");
        print(nums);
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(nums[j], nums[j - 1]); j--) {
                System.out.print("i=" + i + "\tj=" + j + "\t|\t");
                swap(nums, j, j - 1);
                print(nums);
            }
        }
    }
}
