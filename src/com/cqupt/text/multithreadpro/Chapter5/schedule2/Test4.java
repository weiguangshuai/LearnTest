package com.cqupt.text.multithreadpro.Chapter5.schedule2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class Test4 {
    static class MyTask extends TimerTask {

        @Override
        public void run() {
            try {
                System.out.println("begin timer=" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("  end timer=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(myTask, runDate, 3000);
    }
}
