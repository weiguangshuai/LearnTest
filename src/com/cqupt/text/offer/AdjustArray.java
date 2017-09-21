package com.cqupt.text.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author weigs
 * @date 2017/9/19 0019
 */
public class AdjustArray {
    public void reOrderArray(int[] array) {

        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for (int i : array) {
            if (i % 2 == 0)
                even.add(i);
            else
                odd.add(i);
        }
        int temp = 0;
        for (int j : odd) {
            array[temp++] = j;
        }
        for (int j : even) {
            array[temp++] = j;
        }

    }
}
