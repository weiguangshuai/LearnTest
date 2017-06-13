package com.cqupt.text.multithreadpro.Chapter3.customANDproduct.cAndP;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class ThreadC extends Thread {
    private C c;

    public ThreadC(C c) {
        this.c = c;
    }

    public void run() {
        while (true) {
            c.getValue();
        }
    }
}
