package com.cqupt.text.multithreadpro.Chapter3.stream;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class WriteData {

    public void writeMethod(PipedOutputStream outputStream) {
        try {
            System.out.println("write :");
            for (int i = 0; i < 300; i++) {
                String outData = "" + (i + 1);
                outputStream.write(outData.getBytes());
            }
            System.out.println();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
