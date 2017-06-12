package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class ThreadP extends Thread{
    private Product product;

    public ThreadP(Product product) {
        this.product = product;
    }

    public void run() {
        while (true) {
            product.setValue();
        }
    }
}
