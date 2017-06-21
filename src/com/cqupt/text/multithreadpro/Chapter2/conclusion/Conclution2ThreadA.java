package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclution2ThreadA extends Thread{
    private Conclusion2 conclusion2;
    private MyObject object;

    public Conclution2ThreadA(Conclusion2 conclusion2, MyObject object) {
        this.conclusion2 = conclusion2;
        this.object = object;
    }

    public void run() {
        conclusion2.testMehtod1(object);
    }
}
