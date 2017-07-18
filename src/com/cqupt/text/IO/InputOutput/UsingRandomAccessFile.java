package com.cqupt.text.IO.InputOutput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author weigs
 * @date 2017/7/15 0015
 */
public class UsingRandomAccessFile {
    static String file = "rtest.dat";

    static void display() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        for (int i = 0; i < 7; i++)
            System.out.println("Value " + i + ": " + randomAccessFile.readDouble());
        System.out.println(randomAccessFile.readUTF());
        randomAccessFile.close();
    }

    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        for (int i = 0; i < 7; i++)
            randomAccessFile.writeDouble(i * 1.414);
        randomAccessFile.writeUTF("The end of the file");
        randomAccessFile.close();
        display();
        randomAccessFile = new RandomAccessFile(file, "rw");
        randomAccessFile.seek(5 * 8);
        randomAccessFile.writeDouble(47.0001);
        randomAccessFile.close();
        display();
    }
}
