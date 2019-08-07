package com.menga.algorithms.graph.undigraph;

/**
 * Created by Marvel on 2019/8/5.
 */
public class GraphUtils {

    /**
     * 计算 v 的度数
     */
    public static int degree(Graph g, int v) {
        int degree = 0;
        for (int w : g.adj(v)) {
            degree += 1;
        }
        return degree;
    }

    /**
     * 计算所有顶点的最大度数
     */
    public static int maxDegree(Graph g) {
        int max = 0;
        for (int v = 0; v < g.vertexNum(); v++) {
            if (degree(g, v) > max) {
                max = degree(g, v);
            }
        }
        return max;
    }

    /**
     * 计算所有顶点的平均度数
     */
    public static double avgDegree(Graph g) {
        return 2 * g.edgeNum() / g.vertexNum();
    }

    /**
     * 计算自环的个数
     */
    public static int numberOfSelfLoops(Graph g) {
        int count = 0;
        for (int v = 0; v < g.vertexNum(); v++) {
            for (int w : g.adj(v)) {
                if (w == v) {
                    count++;
                }
            }
        }
        return count / 2; // 每条边都被记过两次
    }

    public static String toString(Graph g) {
        StringBuilder sb = new StringBuilder();
        sb.append(g.vertexNum()).append(" vertices,").append(g.edgeNum()).append(" edges\n");
        for (int v = 0; v < g.vertexNum(); v++) {
            sb.append(v).append(": ");
            for (int w : g.adj(v)) {
                sb.append(w).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
