package com.cqupt.text.IO.InputOutput;

import java.io.*;

/**
 * @author weigs
 * @date 2017/7/15 0015
 */
public class StoringAndRecoveringData {
    public static void main(String[] args) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("Data.txt"))
        );

        outputStream.writeDouble(3.142);
        outputStream.writeUTF("That was pi");
        outputStream.close();

        DataInputStream inputStream = new DataInputStream(
                new BufferedInputStream(new FileInputStream("Data.txt"))
        );

        System.out.println(inputStream.readDouble());
        System.out.println(inputStream.readUTF());
        inputStream.close();
    }
}
