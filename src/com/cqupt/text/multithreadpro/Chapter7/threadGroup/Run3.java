package com.cqupt.text.multithreadpro.Chapter7.threadGroup;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run3 {
    public static void main(String[] args) {
        Object lock = new Object();
        MyThread a = new MyThread(lock, "A", 1);
        MyThread b = new MyThread(lock, "B", 2);
        MyThread c = new MyThread(lock, "C", 0);
        a.start();
        b.start();
        c.start();
    }
}
