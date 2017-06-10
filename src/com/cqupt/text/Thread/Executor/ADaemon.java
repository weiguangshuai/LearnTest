package com.cqupt.text.Thread.Executor;

import java.util.concurrent.TimeUnit;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class ADaemon implements Runnable{
    @Override
    public void run() {
        try {
            System.out.println("starting ADaemon");
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            System.out.println("this should always run?");
        }
    }

}

class DaemondDontRunFinally{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ADaemon());
        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(200);
    }
}
