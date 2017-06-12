package com.cqupt.text.multithreadpro.Chapter3.communication;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class MyThread2 extends Thread {
    private Object lock;

    public MyThread2(Object lock) {
        this.lock = lock;
    }

    public void run() {
        synchronized (lock) {
            System.out.println("开始notify time=" + System.currentTimeMillis());
            lock.notify();
            System.out.println("结束 notify time=" + System.currentTimeMillis());
        }
    }
}
