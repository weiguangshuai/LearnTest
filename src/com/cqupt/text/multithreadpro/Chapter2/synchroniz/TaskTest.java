package com.cqupt.text.multithreadpro.Chapter2.synchroniz;

/**
 * 验证同步代码块的正确性
 * @author weigs
 * @date 2017/6/10 0010
 */
public class TaskTest {
    public static void main(String[] args) {
        Task task = new Task();
        TaskThreadA taskThreadA = new TaskThreadA(task);
        taskThreadA.start();

        TaskThreadB taskThreadB = new TaskThreadB(task);
        taskThreadB.start();
    }
}
