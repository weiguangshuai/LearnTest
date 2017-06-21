package com.cqupt.text.multithreadpro.Chapter1;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class ExceptionThread extends Thread{
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.isInterrupted()) {
                    System.out.println("已经是停止状态，我要退出了");
                    throw new InterruptedException();
                }
                System.out.println("i=" + i);
            }
            System.out.println("线程还没有真正结束");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName()+"catch");
            e.printStackTrace();
        }
    }
}

class ExceptionRun{
    public static void main(String[] args) {
        try {
            ExceptionThread thread = new ExceptionThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
