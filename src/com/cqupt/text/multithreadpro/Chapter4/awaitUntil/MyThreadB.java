package com.cqupt.text.multithreadpro.Chapter4.awaitUntil;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyThreadB extends Thread {

    private Service service;

    public MyThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.notifyMethod();
    }
}
