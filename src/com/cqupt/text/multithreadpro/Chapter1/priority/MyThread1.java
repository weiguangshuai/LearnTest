package com.cqupt.text.multithreadpro.Chapter1.priority;

import java.util.Random;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class MyThread1 extends Thread {
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random = new Random();
                random.nextInt();
                addResult = addResult + 1;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-------thread 1 use time=" + (endTime - beginTime));
    }
}
