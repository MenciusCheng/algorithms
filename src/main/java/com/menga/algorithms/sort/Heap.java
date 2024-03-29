package com.menga.algorithms.sort;

/**
 * 堆排序
 *
 * Created by Marvel on 2019/8/26.
 */
public class Heap<T extends Comparable<T>> {

    private T[] heap;
    private int N = 0;

    public Heap(int maxN) {
        this.heap = (T[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j) {
        return heap[i].compareTo(heap[j]) < 0;
    }

    private void swap(int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    /**
     * 上浮
     */
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            swap(k / 2, k);
            k = k / 2;
        }
    }

    /**
     * 下沉
     */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1))
                j++;
            if (!less(k, j))
                break;
            swap(k, j);
            k = j;
        }
    }

    /**
     * 插入元素
     * 将新元素放到数组末尾，然后上浮到合适的位置。
     */
    public void insert(T v) {
        heap[++N] = v;
        swim(N);
    }

    /**
     * 删除最大元素
     * 从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
     */
    public T delMax() {
        T max = heap[1];
        swap(1, N--);
        heap[N + 1] = null;
        sink(1);
        return max;
    }

//    public void sort(T[] nums) {
//        int N = nums.length - 1;
//        for (int k = N / 2; k >= 1; k--)
//            sink(nums, k, N);
//
//        while (N > 1) {
//            swap(nums, 1, N--);
//            sink(nums, 1, N);
//        }
//    }
}
