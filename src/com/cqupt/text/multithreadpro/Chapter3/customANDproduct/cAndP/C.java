package com.cqupt.text.multithreadpro.Chapter3.customANDproduct.cAndP;

import com.cqupt.text.multithreadpro.Chapter3.customANDproduct.ValueObject;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class C {
    private String lock;

    public C(String lock) {
        this.lock = lock;
    }

    public void getValue() {
        try {
            synchronized (lock) {
                while (ValueObject.value.equals("")) {
                    System.out.println("消费者 "
                            + Thread.currentThread().getName() + " waiting了");
                    lock.wait();
                }
                System.out.println("消费者 " + Thread.currentThread().getName()
                        + " runnable了");
                ValueObject.value = "";
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
