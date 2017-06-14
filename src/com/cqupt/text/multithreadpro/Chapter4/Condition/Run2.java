package com.cqupt.text.multithreadpro.Chapter4.Condition;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        MyService2 myService2 = new MyService2();
        MyThreadA a = new MyThreadA(myService2);
        a.setName("A");
        a.start();

        MyThreadB b = new MyThreadB(myService2);
        b.setName("B");
        b.start();
        Thread.sleep(3000);
        myService2.signalA();
    }
}
