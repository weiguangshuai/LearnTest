package com.cqupt.text.multithreadpro.Chaper6;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class LazyLoadRun {
    public static void main(String[] args) {
        LazyLoadThread thread1 = new LazyLoadThread();
        LazyLoadThread thread2 = new LazyLoadThread();
        LazyLoadThread thread3 = new LazyLoadThread();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
