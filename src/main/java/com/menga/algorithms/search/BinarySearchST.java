package com.menga.algorithms.search;

/**
 * 算法 3.2 二分查找（基于有序数组）
 *
 * Created by Marvel on 2019/7/31.
 */
public class BinarySearchST<K extends Comparable<K>, V> {
    private K[] keys;
    private V[] values;
    private int size;

    public BinarySearchST(int capacity) {
        // 调整数组大小的代码参照算法 1.1
        keys = (K[]) new Comparable[capacity];
        values = (V[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < size() && keys[i].compareTo(key) == 0) {
            return values[i];
        } else {
            return null;
        }
    }

    public int rank(K key) {
        int head = 0, tail = size() - 1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                tail = mid - 1;
            } else if (cmp > 0) {
                head = mid + 1;
            } else {
                return mid;
            }
        }
        return head;
    }

    public void put(K key, V value) {
        // 查找键，找到则更新值，否则创建新的元素
        int i = rank(key);
        if (i < size() && keys[i].compareTo(key) == 0) {
            values[i] = value;
        } else {
            for (int j = size(); j > i; j--) {
                keys[j] = keys[j - 1];
                values[j] = values[j - 1];
            }
            keys[i] = key;
            values[i] = value;
            size += 1;
        }
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void delete(K key) {
        put(key, null);
    }

    public void print() {
        System.out.print("keys  =");
        for (K key : keys) {
            System.out.print(key);
        }
        System.out.print("\nvalues=");
        for (V value : values) {
            System.out.print(value);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> bs = new BinarySearchST<String, Integer>(9);

        String s = "GOODMANYES";
        for (int i = 0; i < s.length(); i++) {
            bs.put(s.substring(i, i + 1), i);
        }

//        for (int i = 0; i < s.length(); i++) {
//            System.out.println("key = " + s.substring(i, i + 1) + ", value = " + bs.get(s.substring(i, i + 1)));
//        }
        bs.print();
    }
}
