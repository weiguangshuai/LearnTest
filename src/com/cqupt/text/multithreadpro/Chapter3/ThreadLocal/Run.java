package com.cqupt.text.multithreadpro.Chapter3.ThreadLocal;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run {
    public static void main(String[] args) {
        try {
            ThreadA threadA = new ThreadA();
            ThreadB threadB = new ThreadB();
            threadA.start();
            threadB.start();

            for (int i = 0; i < 100; i++) {
                Tools.threadLocal.set("Main" + (i + 1));
                System.out.println("main get value =" +
                        Tools.threadLocal.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
