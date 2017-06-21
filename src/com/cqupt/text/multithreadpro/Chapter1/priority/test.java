package com.cqupt.text.multithreadpro.Chapter1.priority;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread1 myThread1 = new MyThread1();
            //优先级最小
            myThread1.setPriority(1);
            myThread1.start();

            MyThread2 myThread2 = new MyThread2();
            //优先级最大
            myThread2.setPriority(10);
            myThread2.start();
        }
    }
}
