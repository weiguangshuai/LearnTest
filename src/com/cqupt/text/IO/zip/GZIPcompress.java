package com.cqupt.text.IO.zip;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 压缩文件/读取文件
 *
 * @author weigs
 * @date 2017/7/18 0018
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(
                new FileReader("f:/demo.txt"));
        BufferedOutputStream bufferedOutputStream =
                new BufferedOutputStream(
                        new GZIPOutputStream(new FileOutputStream("test.gz")));
        System.out.println("Writing file");
        int c;
        while ((c = in.read()) != -1)
            bufferedOutputStream.write(c);
        in.close();
        bufferedOutputStream.close();

        System.out.println("Reading file");
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(new GZIPInputStream(
                        new FileInputStream("test.gz")
                ))
        );

        String s;
        while ((s = bufferedReader.readLine()) != null)
            System.out.println(s);
    }
}
