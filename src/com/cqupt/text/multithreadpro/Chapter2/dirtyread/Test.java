package com.cqupt.text.multithreadpro.Chapter2.dirtyread;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        PublicVar publicVar = new PublicVar();
        ThreadA threadA = new ThreadA(publicVar);
        threadA.start();
        Thread.sleep(200);
        publicVar.getValue();
    }
}
