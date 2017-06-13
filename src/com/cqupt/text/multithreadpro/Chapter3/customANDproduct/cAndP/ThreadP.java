package com.cqupt.text.multithreadpro.Chapter3.customANDproduct.cAndP;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class ThreadP extends Thread{
    private P p;

    public ThreadP(P p) {
        this.p = p;
    }

    public void run() {
        while (true) {
            p.setValue();
        }
    }
}
