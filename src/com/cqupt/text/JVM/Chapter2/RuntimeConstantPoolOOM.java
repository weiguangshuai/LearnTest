package com.cqupt.text.JVM.Chapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出
 * @author weigs
 * @date 2017/6/20 0020
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
