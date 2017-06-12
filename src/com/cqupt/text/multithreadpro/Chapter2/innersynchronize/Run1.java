package com.cqupt.text.multithreadpro.Chapter2.innersynchronize;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Run1 {
    public static void main(String[] args) {
        final OutClass1.InnterClass1 innterClass1 = new OutClass1.InnterClass1();
        final OutClass1.InnterClass2 innterClass2 = new OutClass1.InnterClass2();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                innterClass1.method1(innterClass2);
            }
        }, "T1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                innterClass1.method2();
            }
        }, "T2");

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                innterClass2.method1();
            }
        }, "T3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
