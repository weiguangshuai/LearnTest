package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion1Test {
    public static void main(String[] args) {
        Conclusion1 conclusion1 = new Conclusion1();
        MyObject object = new MyObject();

        Conclution1ThreadA threadA =
                new Conclution1ThreadA(conclusion1, object);
        threadA.setName("A");
        threadA.start();
        Conclusion1ThreadB threadB =
                new Conclusion1ThreadB(conclusion1, object);
        threadB.setName("B");
        threadB.start();
    }
}
