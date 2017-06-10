package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion3ThreadB extends Thread{
    private MyObject object;

    public Conclusion3ThreadB(MyObject object) {
        this.object = object;
    }

    public void run() {
        object.speedPrintString();
    }
}
