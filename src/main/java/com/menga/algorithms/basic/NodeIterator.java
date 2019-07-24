package com.menga.algorithms.basic;

import java.util.Iterator;

/**
 * 链表迭代器
 *
 * Created by Marvel on 2019/7/23.
 */
public class NodeIterator<E> implements Iterator<E> {
    private Node<E> current;

    public NodeIterator(Node<E> current) {
        this.current = current;
    }

    public boolean hasNext() {
        return current != null;
    }

    public E next() {
        E item = current.getItem();
        current = current.getNext();
        return item;
    }

    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
}
