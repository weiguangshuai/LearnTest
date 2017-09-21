package com.cqupt.text.array;

import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * @author weigs
 * @date 2017/6/4 0004
 */
public class AutoBoxingArrays {
    public static void main(String[] args) {
        Integer[][] a = {{1, 1, 1, 1}, {1, 1, 1}};
        System.out.println(Arrays.deepToString(a));

        Integer[] b = new Integer[4];
        Arrays.fill(b, 1);
        System.out.println(Arrays.deepToString(b));
    }
}
