package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * 当多个线程同时执行synchronized(x){}同步代码块时呈同步效果
 *
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion1 {
    public void testMehtod1(MyObject object) {
        synchronized (object) {
            try {
                System.out.println("testMethod1______getLock time=" +
                        System.currentTimeMillis() + " run ThreadName=" +
                        Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("testMethod2 releaseLock time="
                +System.currentTimeMillis() + " run ThreadName="
                + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
