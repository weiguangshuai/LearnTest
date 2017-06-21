package com.cqupt.text.Thread.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class CacheThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
