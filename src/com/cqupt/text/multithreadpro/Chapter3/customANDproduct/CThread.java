package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class CThread extends Thread{
    private C c;

    public CThread(C c) {
        this.c = c;
    }

    public void run() {
        while (true) {
            c.popService();
        }
    }
}
