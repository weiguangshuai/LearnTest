package com.cqupt.text.multithreadpro.Chapter4.ReentrantReadWriteLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        ThreadA a = new ThreadA(service);
        ThreadB b = new ThreadB(service);
        a.setName("A");
        b.setName("B");
        a.start();
        b.start();
    }
}
