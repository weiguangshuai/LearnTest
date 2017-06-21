package com.cqupt.text.multithreadpro.Chapter3.stream;

import java.io.PipedInputStream;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class ThreadRead extends Thread{
    private ReadData readData;
    private PipedInputStream inputStream;

    public ThreadRead(ReadData readData, PipedInputStream inputStream) {
        this.inputStream = inputStream;
        this.readData = readData;
    }

    public void run() {
        readData.readMethod(inputStream);
    }
}
