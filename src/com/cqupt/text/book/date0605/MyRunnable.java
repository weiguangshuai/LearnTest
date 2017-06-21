package com.cqupt.text.book.date0605;

/**
 * @author weigs
 * @date 2017/6/5 0005
 */
public class MyRunnable implements Runnable {
    private static int count = 1;
    private final int num = count++;

    @Override
    public void run() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        go();
    }

    public void go() {
        doMore();
    }

    public void doMore() {
        System.out.println("doMore:"+num);
    }


}

class ThreadTest{
    public static void main(String[] args) {
        for (int i =0; i < 1000; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
            System.out.println("main is back");
            System.out.println("------------------------");
        }
    }
}
