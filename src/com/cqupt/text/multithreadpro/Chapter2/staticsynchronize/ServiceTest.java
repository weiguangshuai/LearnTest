package com.cqupt.text.multithreadpro.Chapter2.staticsynchronize;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ServiceTest {
    public static void main(String[] args) {
        ServiceThreadA serviceThreadA = new ServiceThreadA();
        serviceThreadA.setName("A");
        serviceThreadA.start();

        ServiceThreadB serviceThreadB = new ServiceThreadB();
        serviceThreadB.setName("B");
        serviceThreadB.start();
    }
}
