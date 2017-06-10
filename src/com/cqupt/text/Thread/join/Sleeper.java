package com.cqupt.text.Thread.join;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class Sleeper extends Thread{
    private int duration;
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName()+" was interrupted. "+
            "isInterrupted(): "+isInterrupted());
            return;
        }
        System.out.println(getName() + " has awakened");
    }
}
