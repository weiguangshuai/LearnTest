package com.cqupt.text.Thread.Executor;

import java.util.concurrent.ThreadFactory;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class DaemonThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
    }
}
