package com.cqupt.text.multithreadpro.Chapter5.schedule;

import java.util.Date;
import java.util.TimerTask;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class MyTask extends TimerTask{
    @Override
    public void run() {
        System.out.println("任务执行了，时间为： " + new Date());
    }
}
