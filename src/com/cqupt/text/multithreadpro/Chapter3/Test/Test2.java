package com.cqupt.text.multithreadpro.Chapter3.Test;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            String lock = new String();
            System.out.println("syn上面");
            synchronized (lock) {
                System.out.println("syn第一行");
                lock.wait();
                System.out.println("wait下的代码");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
