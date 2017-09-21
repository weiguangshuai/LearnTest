package com.cqupt.text.test;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/9/15 0015
 */
public class zbj1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] input = new int[num];
        for (int i = 0; i < num; i++) {
            input[i] = scanner.nextInt();
        }

        for (int i = 0; i < num; i++) {
            System.out.println(array(input[i]));

        }
    }

    public static int array(int n) {
        if (n <= 2) {
            return n % 32767;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = 2 * second + first;
            first = second;
            second = result;
        }
        return result % 32767;
    }
}
