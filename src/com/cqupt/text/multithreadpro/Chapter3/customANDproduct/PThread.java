package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class PThread extends Thread{
    private P p;

    public PThread(P p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            p.pushService();
        }
    }
}
