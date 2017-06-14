package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyThread extends Thread {
    private MyService service;

    public MyThread(MyService myService) {
        this.service = myService;
    }

    @Override
    public void run() {
        service.testMethod();
    }
}
