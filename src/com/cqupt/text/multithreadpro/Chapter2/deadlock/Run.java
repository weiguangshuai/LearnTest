package com.cqupt.text.multithreadpro.Chapter2.deadlock;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Run {
    public static void main(String[] args) {
        try {
            DealThread dealThread = new DealThread();
            dealThread.setFlag("a");
            Thread threadA = new Thread(dealThread);
            threadA.start();
            Thread.sleep(100);
            dealThread.setFlag("b");
            Thread threadB = new Thread(dealThread);
            threadB.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
