package com.cqupt.text.multithreadpro.Chapter5.schedule2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * schedule方法不具有追赶执行性
 *
 * @author weigs
 * @date 2017/6/13 0013
 */
public class Test6 {
    static class MyTask extends TimerTask {

        @Override
        public void run() {
            System.out.println("begin timer=" + new Date());
            System.out.println("  end timer=" + new Date());
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        System.out.println("现在执行时间：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.SECOND, calendar.get(Calendar.SECOND) - 20);
        Date runDate = calendar.getTime();
        System.out.println("计划执行时间：" + runDate);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, runDate, 2000);
    }
}
