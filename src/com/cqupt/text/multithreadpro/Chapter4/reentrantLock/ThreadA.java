package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadA extends Thread {
    private MyService2 myService;

    public ThreadA(MyService2 myService) {
        this.myService = myService;
    }

    @Override
    public void run() {
        myService.methodA();
    }
}
