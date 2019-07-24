package com.menga.algorithms.basic;

/**
 * 模拟投硬币
 *
 * Created by Marvel on 2019/7/23.
 */
public class Flips {

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        int t = 1000000;
        for (int i = 0; i < t; i++) {
            if (Math.random() < 0.5) {
                heads.increment();
            } else {
                tails.increment();
            }
        }
        System.out.println(heads);
        System.out.println(tails);
        System.out.println("delta: " + Math.abs(heads.tally() - tails.tally()));
    }
}
