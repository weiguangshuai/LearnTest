package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyService {
    private Lock lock = new ReentrantLock();

    public void testMethod() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName()
            +(" " + (i + 1)));
        }
        lock.unlock();
    }
}
