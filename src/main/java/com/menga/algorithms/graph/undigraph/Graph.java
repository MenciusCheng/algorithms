package com.menga.algorithms.graph.undigraph;

/**
 * 无向图
 *
 * Created by Marvel on 2019/8/5.
 */
public interface Graph {

    // 顶点数
    int vertexNum();

    // 边数
    int edgeNum();

    // 增加一条边 v-w
    void addEdge(int v, int w);

    // 和 v 相邻的所有顶点
    Iterable<Integer> adj(int v);

}
