package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion3ThreadA extends Thread{
    private Conclusion3 conclusion3;
    private MyObject object;

    public Conclusion3ThreadA(Conclusion3 conclusion3, MyObject object) {
        this.conclusion3 = conclusion3;
        this.object = object;
    }

    public void run() {
        conclusion3.testMehtod1(object);
    }
}
