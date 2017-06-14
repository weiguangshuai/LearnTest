package com.cqupt.text.multithreadpro.Chapter7.SimpleDateFormat;

import java.text.SimpleDateFormat;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class Test {
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String[] dateStringArray = new String[]{"2000-01-01", "2001-02-01", "2005-09-03",
                "2006-01-02"};
        MyThread[] threads = new MyThread[4];
        for (int i = 0; i < 4; i++) {
            threads[i] = new MyThread(simpleDateFormat, dateStringArray[i]);
        }
        for (int i = 0; i < 4; i++) {
            threads[i].start();
        }
    }
}
