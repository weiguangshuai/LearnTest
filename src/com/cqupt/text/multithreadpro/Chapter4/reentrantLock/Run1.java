package com.cqupt.text.multithreadpro.Chapter4.reentrantLock;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run1 {

    public static void main(String[] args) {
        MyService service = new MyService();
        MyThread a1 = new MyThread(service);
        MyThread a2 = new MyThread(service);
        MyThread a3 = new MyThread(service);
        MyThread a4 = new MyThread(service);
        MyThread a5 = new MyThread(service);

        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}
