package com.cqupt.text.multithreadpro.Chapter3.communication.sizeDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weigs
 * @date 2017/6/11 0011
 */
public class MyList {
    private static List list = new ArrayList();

    public static void add() {
        list.add("weigs");
    }

    public static int size() {
        return list.size();
    }
}
