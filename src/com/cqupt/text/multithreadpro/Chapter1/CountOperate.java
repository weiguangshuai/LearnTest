package com.cqupt.text.multithreadpro.Chapter1;

/**
 * 使用Thread.currentThread().isAlive()和使用this.isAlive()的区别
 * @author weigs
 * @date 2017/6/9 0009
 */
public class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate-----begin");
        System.out.println("Thread.currentThread().getName()=" +
                Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" +
                Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("CountOperate---end");
    }

    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName()="+
            Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()="+
            Thread.currentThread().isAlive());
        System.out.println("this.getName="+this.getName());
        System.out.println("this.isAlive()="+this.isAlive());
        System.out.println("run---end");
    }
}
