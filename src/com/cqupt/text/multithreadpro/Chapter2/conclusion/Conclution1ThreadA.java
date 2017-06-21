package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclution1ThreadA extends Thread {
    private Conclusion1 conclusion1;
    private MyObject object;

    public Conclution1ThreadA(Conclusion1 conclusion1, MyObject object) {
        this.conclusion1 = conclusion1;
        this.object = object;
    }

    public void run() {
        conclusion1.testMehtod1(object);
    }
}
