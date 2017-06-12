package com.cqupt.text.multithreadpro.Chapter2.volatileDemo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger();
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}
