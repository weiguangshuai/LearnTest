package com.cqupt.text.multithreadpro.Chapter5.schedule;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("当前时间为：" + new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);

        Date runDate = calendar.getTime();
        MyTask myTask = new MyTask();
        Timer timer = new Timer();
        timer.schedule(myTask, runDate);
    }
}
