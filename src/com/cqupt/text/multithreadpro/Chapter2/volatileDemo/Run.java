package com.cqupt.text.multithreadpro.Chapter2.volatileDemo;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止它 stopThread="
                + Thread.currentThread().getName());
        Thread.sleep(1000);
        printString.setContinuePrint(false);
    }
}
