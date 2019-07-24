package com.menga.algorithms.basic;

import java.util.Iterator;

/**
 * 背包
 *
 * Created by Marvel on 2019/7/23.
 */
public class Bag<E> implements Iterable<E> {
    private Node<E> first;

    public void add(E e) {
        Node<E> oldFirst = first;
        first = new Node<E>(e, oldFirst);
    }

    public Iterator<E> iterator() {
        return new NodeIterator<E>(first);
    }

    public static void main(String[] args) {
        Bag<String> b = new Bag<String>();
        b.add("weiweicat");
        b.add("am");
        b.add("I");
        for(String i : b) {
            System.out.println(i);
        }
    }
}
