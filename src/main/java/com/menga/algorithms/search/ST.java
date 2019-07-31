package com.menga.algorithms.search;

/**
 * 3.1.2 一个简单的泛型符号表 API
 *
 * Created by Marvel on 2019/7/31.
 */
public interface ST<K, V> {

    void put(K key, V value);

    V get(K key);

    void delete(K key);

    boolean contains(K key);

    boolean isEmpty();

    int size();

    Iterable<K> keys();
}
