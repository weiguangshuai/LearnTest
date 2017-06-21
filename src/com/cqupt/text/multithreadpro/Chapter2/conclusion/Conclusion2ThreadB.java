package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion2ThreadB extends Thread{
    private MyObject object;

    public Conclusion2ThreadB(MyObject object) {
        this.object = object;
    }

    public void run() {
        object.speedPrintString();
    }
}
