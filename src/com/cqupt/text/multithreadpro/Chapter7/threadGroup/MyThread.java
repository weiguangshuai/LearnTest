package com.cqupt.text.multithreadpro.Chapter7.threadGroup;

/**
 * 使线程具有有序性
 *
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyThread extends Thread {
    private Object lock;
    private String showChar;
    private int showNumPosition;
    //统计打印了几个字母
    private int printCount = 0;
    volatile private static int addNumber = 1;

    public MyThread(Object lock, String showChar, int showNumPosition) {
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run() {
        try {
            synchronized (lock) {
                while (true) {
                    if (addNumber % 3 == showNumPosition) {
                        System.out.println("ThreadName="
                                + Thread.currentThread().getName()
                                + "runCount=" + addNumber + " " + showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if (printCount == 3) {
                            break;
                        }
                    } else {
                        lock.wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
