package com.cqupt.text.multithreadpro.Chapter2.synchroniz;

import com.cqupt.text.multithreadpro.Chapter1.MyThread;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ServiceTest {
    public static void main(String[] args) {
        ServiceThread serviceThread = new ServiceThread();
        serviceThread.start();
    }
}
