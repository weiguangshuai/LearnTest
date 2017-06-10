package com.cqupt.text.multithreadpro.Chapter2.synchroniz;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class TaskThreadB extends Thread{
    private Task task;

    public TaskThreadB(Task task) {
        this.task = task;
    }

    public void run() {
        task.doLongTimeTask();
    }
}
