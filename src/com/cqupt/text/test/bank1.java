package com.cqupt.text.test;

import java.util.Scanner;

/**
 * 招商银行
 *
 * @author weigs
 * @date 2017/9/21 0021
 */
public class bank1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] input = new int[num][2];
        for (int i = 0; i < num; i++) {
            input[i][0] = scanner.nextInt();
            input[i][1] = scanner.nextInt();
        }

        maxEmployee(input, num);
    }

    private static void maxEmployee(int[][] a, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < i; j++) {
                if (!(a[j][0] >= a[i][1] || a[j][1] >= a[i][0])) {
                    sum++;
                }
            }
            if (sum > max)
                max = sum;
        }
        System.out.println(max);
    }
}
