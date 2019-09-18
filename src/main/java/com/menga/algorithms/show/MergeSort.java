package com.menga.algorithms.show;

/**
 * Created by Marvel on 2019/9/18.
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {

    private T[] aux;

    public void sort(T[] arr) {
        upToDownSort(arr);
    }

    /**
     * 归并方法
     * @param arr 待归并数组
     * @param head 首下标
     * @param mid 中间下标
     * @param tail 末尾下标
     */
    public void merge(T[] arr, int head, int mid, int tail) {
        int p1 = head; // 指向子数组 arr[head..mid] 的下标
        int p2 = mid + 1; // 指向子数组 arr[mid+1..tail] 的下标

        // 将 arr[head..tail] 复制到辅助数组 aux[head..tail]
        for (int i = head; i <= tail; i++) {
            aux[i] = arr[i];
        }

        // 将辅助子数组 aux[head..mid] 和 aux[mid+1..tail] 归并到 arr[head..tail]
        for (int i = head; i <= tail; i++) {
            if (p1 > mid) {
                arr[i] = aux[p2++]; // 左子数组已取完，直接取右子数组元素
            } else if (p2 > tail) {
                arr[i] = aux[p1++];
            } else if (less(aux[p2], aux[p1])) {
                arr[i] = aux[p2++]; // 当右子数组元素小于左子数组元素时，取右子数组元素
            } else {
                arr[i] = aux[p1++]; // 当右子数组元素大于或等于左子数组元素时，取左子数组元素
            }
        }
    }

    // 思考，如果把上面写成 less(aux[p1], aux[p2]) 会怎么样？
    // 会变得不稳定，因为当 aux[p1] == aux[p2] 时，就会去取 aux[p2]，但是应该要先取 aux[p1] 才是稳定的。

    /**
     * 自顶向下的归并排序
     */
    public void upToDownSort(T[] arr) {
        aux = (T[]) new Comparable[arr.length]; // 一次性分配空间
        upToDownSort(arr, 0, arr.length - 1);
    }

    public void upToDownSort(T[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int mid = head + (tail - head) / 2;
        upToDownSort(arr, head, mid); // 将左半边排序
        upToDownSort(arr, mid + 1, tail); // 将右半边排序
        merge(arr, head, mid, tail); // 归并结果
    }

    /**
     * 自底向上的归并排序
     */
    public void downToUpSort(T[] arr) {
        int N = arr.length;
        aux = (T[]) new Comparable[arr.length];

        for (int sz = 1; sz < N; sz = sz+sz) { // sz 子数组大小
            for (int i = 0; i < N - sz; i += sz+sz) { // i 子数组索引
                merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, N-1));
            }
        }
    }
}
