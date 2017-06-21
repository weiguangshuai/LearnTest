package com.cqupt.text.JVM.Chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * java堆溢出
 * @author weigs
 * @date 2017/6/20 0020
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }
}
