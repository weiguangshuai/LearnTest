package com.cqupt.text.multithreadpro.Chapter5.schedule2;

import java.util.TimerTask;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class MyTestA extends TimerTask {
    private int i;

    public MyTestA(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("第" + i + "次没有被cancel掉");
    }
}
