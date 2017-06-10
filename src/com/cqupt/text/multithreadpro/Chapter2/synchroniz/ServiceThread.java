package com.cqupt.text.multithreadpro.Chapter2.synchroniz;

/**
 * @author weigs
 * @date 2017/6/10 0010
 */
public class ServiceThread extends Thread {
    public void run() {
        Service service = new Service();
        service.service1();
    }
}
