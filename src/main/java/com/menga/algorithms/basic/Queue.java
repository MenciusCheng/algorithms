package com.menga.algorithms.basic;

/**
 * 队列
 *
 * Created by Marvel on 2019/7/23.
 */
public interface Queue<E> extends Iterable<E> {
    void enqueue(E e);
    E dequeue();
    boolean isEmpty();
    int size();
}
