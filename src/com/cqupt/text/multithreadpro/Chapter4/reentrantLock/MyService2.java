package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyService2 {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodA begin ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("methodB begin ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
            Thread.sleep(5000);
            System.out.println("methodB end ThreadName="
                    + Thread.currentThread().getName() + " time="
                    + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
