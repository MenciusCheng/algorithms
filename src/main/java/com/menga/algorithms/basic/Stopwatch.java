package com.menga.algorithms.basic;

/**
 * 计时器
 *
 * Created by Marvel on 2019/7/24.
 */
public class Stopwatch {
    private long startAt;

    public Stopwatch() {
        startAt = System.currentTimeMillis();
    }

    /**
     * 打印过去的时间
     */
    public void pElapsedTime() {
        long endAt = System.currentTimeMillis();
        Integer elapsedTime = (int)(endAt - startAt);
        StringBuilder sb = new StringBuilder();

        Integer second = elapsedTime / 1000;
        if (second > 0) {
            sb.append(second).append(" second ");
        }
        Integer millisecond = elapsedTime % 1000;
        sb.append(millisecond).append(" millisecond");

        System.out.println(sb);
    }

    public static void main(String[] args) throws InterruptedException {
        Stopwatch stopwatch = new Stopwatch();
        Thread.sleep(1300);
        stopwatch.pElapsedTime();
    }
}
