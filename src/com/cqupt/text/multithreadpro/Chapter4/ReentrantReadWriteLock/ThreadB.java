package com.cqupt.text.multithreadpro.Chapter4.ReentrantReadWriteLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadB extends Thread {

    private Service service;

    public ThreadB(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.read();
    }
}
