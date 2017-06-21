package com.cqupt.text.multithreadpro.Chapter3.customANDproduct.cAndP;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        String lock = new String("");
        P p = new P(lock);
        C c = new C(lock);

        ThreadP[] ps = new ThreadP[2];
        ThreadC[] cs = new ThreadC[2];

        for (int i = 0; i < 2; i++) {
            ps[i] = new ThreadP(p);
            ps[i].setName("生产者" + (i + 1));
            cs[i] = new ThreadC(c);
            cs[i].setName("消费者" + (i + 1));
            ps[i].start();
            cs[i].start();
        }

//        Thread.sleep(5000);
//        Thread[] threads =
//                new Thread[Thread.currentThread().getThreadGroup().activeCount()];
//        Thread.currentThread().getThreadGroup().enumerate(threads);
//        for (int i = 0; i < threads.length; i++) {
//            System.out.println(threads[i].getName() + " "
//                    + threads[i].getState());
//        }

    }
}
