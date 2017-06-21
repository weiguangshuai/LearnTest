package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class MyObject {
    //验证结论2使用的方法
    /*
    synchronized public void speedPrintString() {
        System.out.println("testMethod1______getLock time=" +
                System.currentTimeMillis() + " run ThreadName=" +
                Thread.currentThread().getName());
        System.out.println("------------------");
        System.out.println("testMethod2 releaseLock time="
                +System.currentTimeMillis() + " run ThreadName="
                + Thread.currentThread().getName());
    }
    */

    //验证结论3使用的方法
    public void speedPrintString() {
        synchronized (this) {
            System.out.println("testMethod1______getLock time=" +
                    System.currentTimeMillis() + " run ThreadName=" +
                    Thread.currentThread().getName());
            System.out.println("------------------");
            System.out.println("testMethod2 releaseLock time="
                    + System.currentTimeMillis() + " run ThreadName="
                    + Thread.currentThread().getName());
        }
    }
}
