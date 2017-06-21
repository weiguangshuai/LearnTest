package com.cqupt.text.multithreadpro.Chapter1;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class YieldDemo {
    public static void main(String[] args) {
        YieldThread yieldThread = new YieldThread();
        yieldThread.start();
    }
}

class YieldThread extends Thread {
    public void run() {
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 5000000; i++) {
//            Thread.yield();
            count = count + 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("用时："+(endTime - beginTime) + "毫秒！");
    }
}
