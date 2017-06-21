package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Run {
    public static void main(String[] args) {
        String lock = new String("");
        Product product = new Product(lock);
        Custom custom = new Custom(lock);

        ThreadP pthread = new ThreadP(product);
        ThreadC cthread = new ThreadC(custom);

        pthread.start();
        cthread.start();
    }

}
