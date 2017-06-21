package com.cqupt.text.multithreadpro.Chapter3.ThreadLocal;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class ThreadA extends Thread{

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100; i++) {
                Tools.threadLocal.set("ThreadA" + (i + 1));
                System.out.println("ThreadA get Value=" + Tools.threadLocal.get());
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
