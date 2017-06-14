package com.cqupt.text.multithreadpro.Chaper6;

/**
 * @author weigs
 * @date 2017/6/13 0013
 */
public class LazyLoad {
    private static LazyLoad lazyLoad;

    public LazyLoad() {

    }

    public static LazyLoad getInstance() {
        try {
            if (lazyLoad != null) {

            } else {
                Thread.sleep(3000);
                synchronized (LazyLoad.class) {
                    if (lazyLoad == null) {
                        lazyLoad = new LazyLoad();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return lazyLoad;
    }
}
