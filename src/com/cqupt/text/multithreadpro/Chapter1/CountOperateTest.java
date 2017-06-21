package com.cqupt.text.multithreadpro.Chapter1;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class CountOperateTest {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        Thread thread = new Thread(countOperate);
        System.out.println("main begin thread isAlive=" + thread.isAlive());
        thread.setName("A");
        thread.start();
        System.out.println("main end thread isAlive=" + thread.isAlive());
    }
}
