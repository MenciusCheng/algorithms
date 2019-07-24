package com.menga.algorithms.basic;

import java.util.Iterator;

/**
 * 链表实现的队列
 *
 * Created by Marvel on 2019/7/23.
 */
public class LinkedQueue<E> implements Queue<E> {
    private Node<E> first;
    private Node<E> last;
    private int n;

    public void enqueue(E e) {
        Node<E> oldLast = last;
        last = new Node<E>(e, null);
        if (first == null) {
            first = last;
        } else {
            oldLast.setNext(last);
        }
        n += 1;
    }

    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E item = first.getItem();
        first = first.getNext();
        if (first == null) {
            last = null;
        }
        n -= 1;
        return item;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public Iterator<E> iterator() {
        return new NodeIterator<E>(first);
    }
}
