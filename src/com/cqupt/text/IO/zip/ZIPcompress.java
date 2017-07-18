package com.cqupt.text.IO.zip;

import java.io.*;
import java.util.zip.*;

/**
 * @author weigs
 * @date 2017/7/18 0018
 */
public class ZIPcompress {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("test.zip");
        CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
        ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(zipOutputStream);
        zipOutputStream.setComment("A test of Java Zipping");
        for (int i = 0; i < 3; i++ ) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("f:/"+i+".txt"));
            zipOutputStream.putNextEntry(new ZipEntry("f:/"+i+".txt"));
            int c;
            while ((c = bufferedReader.read()) != -1)
                bufferedOutputStream.write(c);
            bufferedReader.close();
            bufferedOutputStream.flush();
        }
        bufferedOutputStream.close();
        System.out.println("Checksum" + checkedOutputStream.getChecksum().getValue());
        System.out.println("Reading file");
        FileInputStream fileInputStream = new FileInputStream("test.zip");
        CheckedInputStream checkedInputStream = new CheckedInputStream(fileInputStream, new Adler32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(zipInputStream);
        ZipEntry zipEntry;
        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            System.out.println("reading file" + zipEntry);
            int x;
            while ( (x = bufferedInputStream.read()) != -1)
                System.out.write(x);
        }
    }
}
