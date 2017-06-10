package com.cqupt.text.Thread.Executor;

import java.util.concurrent.Callable;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class TaskWithResult implements Callable<String>{
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    @Override
    public String call() throws Exception {
        return "result of TaskWithResult"+id;
    }
}
