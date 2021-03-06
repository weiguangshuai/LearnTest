package com.cqupt.text.multithreadpro.Chapter7.threadGroup;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadA extends Thread{

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("ThreadName=" + Thread.currentThread()
                .getName());
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
