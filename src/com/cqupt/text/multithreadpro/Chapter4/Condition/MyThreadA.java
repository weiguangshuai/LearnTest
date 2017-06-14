package com.cqupt.text.multithreadpro.Chapter4.Condition;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyThreadA extends Thread {
    private MyService2 myService2;

    public MyThreadA(MyService2 myService2) {
        this.myService2 = myService2;
    }

    @Override
    public void run() {
        myService2.awaitA();
    }

}
