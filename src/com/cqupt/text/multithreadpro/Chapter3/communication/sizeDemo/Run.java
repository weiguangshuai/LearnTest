package com.cqupt.text.multithreadpro.Chapter3.communication.sizeDemo;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Run {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();

            Thread.sleep(100);

            ThreadB b = new ThreadB(lock);
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
