package com.cqupt.text.multithreadpro.Chapter2.innersynchronize;

/**
 * 内部类两个同步方法，使用不同的锁，打印的结果也是异步
 * @author weigs
 * @date 2017/6/11 0011
 */
public class OutClass {
    static class Inner {
        public void method1() {
            synchronized ("其他的锁") {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " i=" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized void method2() {
            for (int i = 11; i <= 20; i++) {
                System.out.println(Thread.currentThread().getName() + " i=" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
