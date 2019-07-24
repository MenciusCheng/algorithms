package com.menga.algorithms.basic;

/**
 * 计数器
 *
 * Created by Marvel on 2019/7/23.
 */
public class Counter {

    private String name;
    private Integer count = 0;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        count += 1;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Counter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", count=").append(count);
        sb.append('}');
        return sb.toString();
    }
}
