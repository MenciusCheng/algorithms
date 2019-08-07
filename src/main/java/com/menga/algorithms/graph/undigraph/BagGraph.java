package com.menga.algorithms.graph.undigraph;

import com.menga.algorithms.basic.Bag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marvel on 2019/8/5.
 */
public class BagGraph implements Graph {

    private final int vertexNum;
    private int edgeNum;
    private Bag<Integer>[] adj;

    public BagGraph(int vertexNum) {
        this.vertexNum = vertexNum;
        this.edgeNum = 0;
        this.adj = (Bag<Integer>[]) new Bag[vertexNum]; // 创建邻接表
        for (int v = 0; v < vertexNum; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int vertexNum() {
        return vertexNum;
    }

    public int edgeNum() {
        return edgeNum;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        edgeNum += 1;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(BagGraph.class.getResource("tinyG.txt").getFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        List<Integer> lines = new ArrayList<Integer>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] splits = line.split(" ");
            for (String s : splits) {
                lines.add(Integer.valueOf(s));
            }
        }

        // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
        // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
        // 因此只要一个 close() 调用即可
        bufferedReader.close();

        Graph graph = new BagGraph(lines.get(0));
        Integer edgeNum = 2 + lines.get(1) * 2;
        for (int i = 2; i < edgeNum - 1; i += 2) {
            System.out.println("addEdge v=" + lines.get(i) + ", w=" + lines.get(i + 1));
            graph.addEdge(lines.get(i), lines.get(i + 1));
        }
        System.out.println(GraphUtils.toString(graph));
    }
}
