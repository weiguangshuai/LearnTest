package com.cqupt.text.multithreadpro.Chapter1;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class MyThread extends Thread {
    private int count = 5;

    synchronized public void run() {
        count--;
        System.out.println(this.currentThread().getName() + ": " + count);
    }
}

class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread Athread = new Thread(myThread, "A");
        Thread Bthread = new Thread(myThread, "B");
        Thread Cthread = new Thread(myThread, "C");
        Thread Dthread = new Thread(myThread, "D");
        Thread Ethread = new Thread(myThread, "E");
        Athread.start();
        Bthread.start();
        Cthread.start();
        Dthread.start();
        Ethread.start();
    }
}
