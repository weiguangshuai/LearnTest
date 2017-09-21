package com.cqupt.text.test;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/9/14 0014
 */
public class meituan1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        long[] number = new long[num];
        for (int i = 0; i < num; i++) {
            number[i] = scanner.nextLong();
        }
        if (num == 1) {
            if (number[0] % 7 == 0) {
                System.out.println(1);
            }
            System.out.println(0);
        }

        int sum = 0;
        for (int i = 0; i < num - 1; i++) {
            for (int j = i + 1; j < num; j++) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(number[i]);
                sb1.append(number[j]);
                if (Long.parseLong(sb1.toString()) % 7 == 0) {
                    sum++;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(number[j]);
                sb2.append(number[i]);
                if (Long.parseLong(sb2.toString()) % 7 == 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
