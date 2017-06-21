package com.cqupt.text.multithreadpro.Chapter2.synchroniz;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ThreadA extends Thread{
    private HasSelfPrivateNum hasSelfPrivateNum;

    public ThreadA(HasSelfPrivateNum hasSelfPrivateNum) {
        this.hasSelfPrivateNum = hasSelfPrivateNum;
    }

    public void run() {
        hasSelfPrivateNum.add("a");
    }
}
