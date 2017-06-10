package com.cqupt.text.Thread.join;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class Joiner extends Thread{
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println(getName() + " join completed");
    }
}
