package com.cqupt.text.multithreadpro.Chapter2.volatileDemo;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class AddCountThreadTest {
    public static void main(String[] args) {
        AddCountThread countThread = new AddCountThread();

        Thread thread1 = new Thread(countThread);
        thread1.start();

        Thread thread2 = new Thread(countThread);
        thread2.start();

        Thread thread3 = new Thread(countThread);
        thread3.start();

        Thread thread4 = new Thread(countThread);
        thread4.start();
    }
}
