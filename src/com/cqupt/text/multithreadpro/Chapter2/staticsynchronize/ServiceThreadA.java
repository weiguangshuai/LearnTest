package com.cqupt.text.multithreadpro.Chapter2.staticsynchronize;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ServiceThreadA extends Thread{
    public void run() {
        Service.printA();
    }
}
