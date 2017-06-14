package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadBB extends Thread{
    private MyService2 myService2;

    public ThreadBB(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.methodB();
    }
}
