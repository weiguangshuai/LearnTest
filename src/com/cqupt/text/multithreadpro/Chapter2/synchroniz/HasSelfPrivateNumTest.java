package com.cqupt.text.multithreadpro.Chapter2.synchroniz;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class HasSelfPrivateNumTest {
    public static void main(String[] args) {
        HasSelfPrivateNum hasSelfPrivateNum1 = new HasSelfPrivateNum();
        HasSelfPrivateNum hasSelfPrivateNum2 = new HasSelfPrivateNum();

        ThreadA threadA = new ThreadA(hasSelfPrivateNum1);
        threadA.start();

        ThreadB threadB = new ThreadB(hasSelfPrivateNum2);
        threadB.start();
    }
}
