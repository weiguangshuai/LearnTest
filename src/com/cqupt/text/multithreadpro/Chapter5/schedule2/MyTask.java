package com.cqupt.text.multithreadpro.Chapter5.schedule2;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class MyTask extends TimerTask{
    @Override
    public void run() {
        try {
            System.out.println("A begin timer" + new Date());
            Thread.sleep(5000);
            System.out.println("A end timer" + new Date());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
