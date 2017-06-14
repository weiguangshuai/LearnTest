package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadAA extends Thread {
    private MyService2 myService2;

    public ThreadAA(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.methodA();
    }
}
