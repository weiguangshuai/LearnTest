package com.cqupt.text.multithreadpro.Chapter4.awaitUntil;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.start();

        Thread.sleep(2000);

        MyThreadB myThreadB = new MyThreadB(service);
        myThreadB.start();
    }
}
