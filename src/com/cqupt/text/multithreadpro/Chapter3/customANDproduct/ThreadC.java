package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class ThreadC extends Thread{
    private Custom custom;

    public ThreadC(Custom custom) {
        this.custom = custom;
    }

    public void run() {
        while (true) {
            custom.getValue();
        }
    }
}
