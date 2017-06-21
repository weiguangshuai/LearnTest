package com.cqupt.text.multithreadpro.Chapter4.fairLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Service {
    private ReentrantLock lock;

    public Service(boolean isFair) {
        lock = new ReentrantLock(isFair);
    }

    public void serviceMethod() {
        try {
            lock.lock();
            System.out.println("ThreadName=" + Thread.currentThread().getName()
                    + "获得锁定");

        } finally {
            lock.unlock();
        }
    }
}
