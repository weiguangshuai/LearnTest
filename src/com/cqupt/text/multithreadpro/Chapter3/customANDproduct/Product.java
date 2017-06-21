package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Product {
    private String lock;

    public Product(String lock) {
        this.lock = lock;
    }

    public void setValue() {
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String value = System.currentTimeMillis() + "_"
                        +System.nanoTime();
                System.out.println("set的值是" + value);
                ValueObject.value = value;
                lock.notify();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
