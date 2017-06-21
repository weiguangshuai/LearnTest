package com.cqupt.text.multithreadpro.Chapter4.Condition;

import com.cqupt.text.multithreadpro.Chapter4.reentrantLock.MyService;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadA extends Thread{
    private MyService1 service1;

    public ThreadA(MyService1 myService1) {
        this.service1 = myService1;
    }

    @Override
    public void run() {
        service1.await();
    }
}
