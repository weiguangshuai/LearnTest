package com.cqupt.text.Thread.exception;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool(
                new HanderThreadFactory()
        );
        executorService.execute(new ExceptionThread2());
    }
}
