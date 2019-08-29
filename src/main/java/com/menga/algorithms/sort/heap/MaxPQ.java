package com.menga.algorithms.sort.heap;

/**
 * 优先队列
 *
 * Created by Marvel on 2019/8/27.
 */
public interface MaxPQ<T extends Comparable<T>> {

    void insert(T t);

    T max();

    T delMax();

    boolean isEmpty();

    int size();
}
