package com.cqupt.text.multithreadpro.Chapter4.awaitUntil;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyThreadA extends Thread{

    private Service service;

    public MyThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.waitMethod();
    }
}
