package com.cqupt.text.multithreadpro.Chapter4.Condition;

import com.cqupt.text.multithreadpro.Chapter4.reentrantLock.MyService;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run1 {
    public static void main(String[] args) throws InterruptedException {
        MyService1 myService1 = new MyService1();
        ThreadA threadA = new ThreadA(myService1);
        threadA.start();
        Thread.sleep(3000);
        myService1.signal();
    }
}
