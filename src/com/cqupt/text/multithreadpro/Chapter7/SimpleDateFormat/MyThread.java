package com.cqupt.text.multithreadpro.Chapter7.SimpleDateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author weigs
 * @date 2017/6/14 0014
 */
public class MyThread extends Thread {
    private SimpleDateFormat simpleDateFormat;
    private String dateString;

    public MyThread(SimpleDateFormat simpleDateFormat, String dateString) {
        this.simpleDateFormat = simpleDateFormat;
        this.dateString = dateString;
    }

    @Override
    public void run() {
        try {
            Date dateref = DateTools.parse("yyyy-MM-dd", dateString);
            String newDateString = DateTools.format("yyyy-MM-dd", dateref);
            if (!newDateString.equals(dateString)) {
                System.out.println("ThreadName=" + this.getName()
                        + "报错了 日期字符串：" + dateString +
                        "转化成的日期为：" + newDateString);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
