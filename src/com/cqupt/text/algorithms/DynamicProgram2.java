package com.cqupt.text.algorithms;


/**
 * @author weigs
 * @date 2017/8/21 0021
 */
public class DynamicProgram2 {
    public static void main(String[] args) {
        int[] a = {2, 1, 3, 4, 5, 3, 4, 5};
        System.out.println(coin(1));
    }


    private static int coin(int a) {
        if (a == 0) {
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        if (a < 3) {
            return coin(a - 1) + 1;
        }
        if (a >= 3 && a < 5) {
            return min(coin(a - 1) + 1, coin(a - 3) + 1);
        } else {
            return min(coin(a - 1) + 1, coin(a - 3) + 1, coin(a - 5) + 1);
        }
    }

    private static int min(int a, int b) {
        if (a > b)
            return b;
        return a;
    }

    private static int min(int a, int b, int c) {
        int min = a;
        if (b < min)
            min = b;
        if (c < min)
            min = c;
        return min;
    }
}
