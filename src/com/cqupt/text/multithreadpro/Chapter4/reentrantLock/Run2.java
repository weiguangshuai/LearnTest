package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run2 {
    public static void main(String[] args) throws InterruptedException {
        MyService2 myService2 = new MyService2();
        ThreadA a = new ThreadA(myService2);
        a.setName("A");
        a.start();

        ThreadAA aa = new ThreadAA(myService2);
        aa.setName("AA");
        aa.start();
        Thread.sleep(100);

        ThreadB b = new ThreadB(myService2);
        b.setName("B");
        b.start();

        ThreadBB bb = new ThreadBB(myService2);
        bb.setName("BB");
        bb.start();
    }
}
