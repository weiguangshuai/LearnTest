package com.cqupt.text.multithreadpro.Chapter2.innersynchronize;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Run {
    public static void main(String[] args) {
        final OutClass.Inner inner = new OutClass.Inner();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method1();
            }
        }, "A");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                inner.method2();
            }
        }, "B");

        thread1.start();
        thread2.start();
    }
}
