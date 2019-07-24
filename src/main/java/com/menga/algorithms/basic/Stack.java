package com.menga.algorithms.basic;

/**
 * 栈
 *
 * Created by Marvel on 2019/7/23.
 */
public interface Stack<E> extends Iterable<E> {
    void push(E e);
    E pop();
    boolean isEmpty();
    int size();
}
