package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class MyStackRun {
    public static void main(String[] args) {
        //一生产一消费
        /*
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c = new C(myStack);
        PThread pThread = new PThread(p);
        CThread cThread = new CThread(c);
        pThread.start();
        cThread.start();
        */
        //一生产多消费
        /*
        MyStack myStack = new MyStack();
        P p = new P(myStack);
        C c1 = new C(myStack);
        C c2 = new C(myStack);
        C c3 = new C(myStack);
        C c4 = new C(myStack);
        C c5 = new C(myStack);

        PThread pThread = new PThread(p);
        pThread.start();

        CThread cThread1 = new CThread(c1);
        CThread cThread2 = new CThread(c2);
        CThread cThread3 = new CThread(c3);
        CThread cThread4 = new CThread(c4);
        CThread cThread5 = new CThread(c5);
        cThread1.start();
        cThread2.start();
        cThread3.start();
        cThread4.start();
        cThread5.start();
        */
        //多生产与一消费
        MyStack myStack = new MyStack();
        P p1 = new P(myStack);
        P p2 = new P(myStack);
        P p3 = new P(myStack);
        P p4 = new P(myStack);
        P p5 = new P(myStack);
        P p6 = new P(myStack);

        PThread thread1 = new PThread(p1);
        PThread thread2 = new PThread(p2);
        PThread thread3 = new PThread(p3);
        PThread thread4 = new PThread(p4);
        PThread thread5 = new PThread(p5);
        PThread thread6 = new PThread(p6);
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

        C c = new C(myStack);
        CThread cThread = new CThread(c);
        cThread.start();

    }
}
