package com.cqupt.text.multithreadpro.Chapter5.schedule2;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class TestA {
    public static void main(String[] args) {
        int i = 0;
        Calendar calendar = Calendar.getInstance();
        Date runDate = calendar.getTime();
        while (true) {
            i++;
            Timer timer = new Timer();
            MyTestA myTestA = new MyTestA(i);
            timer.schedule(myTestA, runDate);
            timer.cancel();
        }
    }
}
