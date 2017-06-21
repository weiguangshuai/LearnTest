package com.cqupt.text.multithreadpro.Chapter2.staticsynchronize;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ServiceThreadB extends Thread {
    public void run() {
        Service.printB();
    }
}
