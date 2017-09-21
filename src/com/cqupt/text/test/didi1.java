package com.cqupt.text.test;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/9/10 0010
 */
public class didi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] temp = new int[num];
        for (int i = 0; i < num; i++) {
            temp[i] = scanner.nextInt();
        }

        one(temp);
    }

    private static void one(int[] temp) {
        int sum = 0;
        int start = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) {
                sum++;
                start = i + 1;
                continue;
            }
            for (int j = start; j < i; j++) {
                int flag = 0;
                for (int k = j; k <= i; k++) {
                    flag = flag ^ temp[k];
                }
                if (flag == 0) {
                    sum++;
                    start = i + 1;
                    continue;
                }
            }
        }
        System.out.println(sum);
    }
}
