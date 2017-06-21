package com.cqupt.text.multithreadpro.Chaper6;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class LazyLoadThread extends Thread{

    public void run() {
        System.out.println(LazyLoad.getInstance().hashCode());
    }
}
