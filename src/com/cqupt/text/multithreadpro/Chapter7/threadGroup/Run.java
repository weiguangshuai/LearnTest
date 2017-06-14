package com.cqupt.text.multithreadpro.Chapter7.threadGroup;

/**
 * 一级关联线程组
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Run {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        ThreadGroup group = new ThreadGroup("weigs线程组");
        Thread aThread = new Thread(group, threadA);
        Thread bThread = new Thread(group, threadB);

        aThread.start();
        bThread.start();

        System.out.println("活动的线程数为：" + group.activeCount());
        System.out.println("线程组的名称为：" + group.getName());
    }
}
