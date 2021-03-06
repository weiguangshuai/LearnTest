package com.cqupt.text.Thread.Executor;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#"+id+"("+
                (countDown > 0?countDown:"liftoff!")+") ";
    }
    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
