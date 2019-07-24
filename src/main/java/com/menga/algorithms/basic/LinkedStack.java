package com.menga.algorithms.basic;

import java.util.Iterator;

/**
 * 链表实现的栈
 *
 * Created by Marvel on 2019/7/23.
 */
public class LinkedStack<E> implements Stack<E> {

    private Node<E> first;
    private int n;

    public void push(E e) {
        Node<E> oldFirst = first;
        first = new Node<E>(e, oldFirst);
        n += 1;
    }

    public E pop() {
        if (isEmpty()) {
            return null;
        }
        E item = first.getItem();
        first = first.getNext();
        n -= 1;
        return item;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node it = first;
        while (it != null) {
            sb.append(it.getItem()).append(" ");
            it = it.getNext();
        }
        return sb.toString();
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

    public static void main(String[] args) {
        Stack<String> s = new LinkedStack<String>();
        s.push("weiweicat");
        s.push("am");
        s.push("heihei");
        s.pop();
        s.push("I");
        System.out.println(s);
    }
}
