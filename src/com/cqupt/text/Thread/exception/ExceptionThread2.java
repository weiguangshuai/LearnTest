package com.cqupt.text.Thread.exception;

import java.util.concurrent.ThreadFactory;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class ExceptionThread2 implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run() by " + thread);
        System.out.println("eh=" + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHander implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught" + e);
    }
}

class HanderThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + "creating new Thread");
        Thread thread = new Thread(r);
        System.out.println("created " + thread);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHander());
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        return thread;
    }
}
