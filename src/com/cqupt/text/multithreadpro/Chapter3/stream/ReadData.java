package com.cqupt.text.multithreadpro.Chapter3.stream;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class ReadData {

    public void readMethod(PipedInputStream inputStream) {
        try {
            System.out.println("read :");
            byte[] bytes = new byte[20];
            int readLength = inputStream.read(bytes);
            while (readLength != -1) {
                String newData = new String(bytes, 0, readLength);
                System.out.println(newData);
                readLength = inputStream.read(bytes);
            }
            System.out.println();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
