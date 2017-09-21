package com.cqupt.text.test;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/8/31 0031
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.nextInt();
        }
        int max = 0;
        for (int i = 0; i < num; i++) {
            int len = 0;
            int sum = 0;
            for (int j = i; j < num; j++) {
                sum = sum + inputs[j];
                len++;
                if (sum % 5 == 0 && len > max) {
                    max = len;
                    System.out.println(max);
                }
            }
        }
    }
}
