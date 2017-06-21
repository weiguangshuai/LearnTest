package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion2Test {
    public static void main(String[] args) throws InterruptedException {
        Conclusion2 conclusion2 = new Conclusion2();
        MyObject object = new MyObject();

        Conclution2ThreadA threadA = new Conclution2ThreadA(conclusion2, object);
        threadA.setName("A");
        threadA.start();

        Thread.sleep(100);

        Conclusion2ThreadB conclusion2ThreadB = new Conclusion2ThreadB(object);
        conclusion2ThreadB.setName("B");
        conclusion2ThreadB.start();
    }
}
