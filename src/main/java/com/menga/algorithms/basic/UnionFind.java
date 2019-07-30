package com.menga.algorithms.basic;

/**
 * 1.5 案例研究：union-find 算法
 *
 * Created by Marvel on 2019/7/25.
 */
public class UnionFind {

    private int size; // 分量数量
    private int[] id; // 分量 id

    /**
     * 以整数标识（0 到 size - 1）初始化 size 个触点
     */
    UnionFind(int size) {
        this.size = size;
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    /**
     * 在 p 和 q 之间添加一条连接
     */
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId != qId) {
            for (int i = 0; i < id.length; i++) {
                if (id[i] == pId) {
                    id[i] = qId;
                }
            }
            size -= 1;
        }
    }

    /**
     * p 所在的分量的标识符 (0 到 size - 1)
     */
    public int find(int p) {
        return id[p];
    }

    /**
     * p 和 q 是否存在于同一个分量中
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * 连通分量的数量
     */
    public int count() {
        return size;
    }

    public static void main(String[] args) {

    }
}
