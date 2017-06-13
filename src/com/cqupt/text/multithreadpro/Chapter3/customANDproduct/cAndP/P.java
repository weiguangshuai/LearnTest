package com.cqupt.text.multithreadpro.Chapter3.customANDproduct.cAndP;

import com.cqupt.text.multithreadpro.Chapter3.customANDproduct.ThreadC;
import com.cqupt.text.multithreadpro.Chapter3.customANDproduct.ValueObject;

/**
 * 生产者
 *
 * @author weigs
 * @date 2017/6/12 0012
 */
public class P {
    private String lock;

    public P(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                while (!ValueObject.value.equals("")) {
                    System.out.println("生产者 "
                            + Thread.currentThread().getName() + "wating了");
                    lock.wait();
                }
                System.out.println("生产者 " + Thread.currentThread().getName()
                        + "runnable了");
                String value = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
