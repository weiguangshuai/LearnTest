package com.cqupt.text.multithreadpro.Chapter3.stream;

import java.io.PipedOutputStream;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class ThreadWrite extends Thread{

    private WriteData writeData;
    private PipedOutputStream outputStream;

    public ThreadWrite(WriteData writeData, PipedOutputStream outputStream) {
        this.outputStream = outputStream;
        this.writeData = writeData;
    }

    public void run() {
        writeData.writeMethod(outputStream);
    }
}
