package com.cqupt.text.multithreadpro.Chapter2.conclusion;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class Conclusion3Test {
    public static void main(String[] args) {
        Conclusion3 conclusion3 = new Conclusion3();
        MyObject object = new MyObject();

        Conclusion3ThreadA threadA =
                new Conclusion3ThreadA(conclusion3, object);
        threadA.setName("A");
        threadA.start();

        Conclusion3ThreadB threadB =
                new Conclusion3ThreadB(object);
        threadB.setName("B");
        threadB.start();

    }
}
