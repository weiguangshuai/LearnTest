package com.cqupt.text.multithreadpro.Chapter3.Test;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class Test1 {
    public static void main(String[] args) {
        try {
            String newString = new String("");
            newString.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
