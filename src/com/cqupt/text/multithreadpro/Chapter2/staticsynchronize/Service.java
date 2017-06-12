package com.cqupt.text.multithreadpro.Chapter2.staticsynchronize;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Service {
    synchronized public static void printA() {
        try {
            System.out.println("线程名称：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "进入PrintA");
            Thread.sleep(3000);
            System.out.println("线程名称：" + Thread.currentThread().getName()
                    + "在" + System.currentTimeMillis() + "离开printA");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized public static void printB() {
        System.out.println("线程名称：" + Thread.currentThread().getName()
                + "在" + System.currentTimeMillis() + "进入printB");
        System.out.println("线程名称：" + Thread.currentThread().getName()
                + "在" + System.currentTimeMillis() + "离开printB");
    }
}
