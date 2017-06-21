package com.cqupt.text.multithreadpro.Chapter2.dirtyread;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ThreadA extends Thread {
    private PublicVar publicVar;

    public ThreadA(PublicVar publicVar) {
        this.publicVar = publicVar;
    }

    public void run() {
        publicVar.setValue("B", "BB");
    }
}
