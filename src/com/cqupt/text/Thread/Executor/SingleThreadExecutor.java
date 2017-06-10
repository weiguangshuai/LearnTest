package com.cqupt.text.Thread.Executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 如果像SingleThreadExecutro提交多个任务，那么任务将排队
 * @author weigs
 * @date 2017/6/9 0009
 */
public class SingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        executorService.shutdown();
    }
}
