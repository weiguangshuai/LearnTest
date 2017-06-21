package com.cqupt.text.multithreadpro.Chapter5.schedule2;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class Test5 {
    static class MyTask extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(6000);
                System.out.println("  end timer=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        System.out.println("当前时间：" + System.currentTimeMillis());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(myTask, 3000, 2000);
    }
}
