package com.cqupt.text.test;

import java.util.Scanner;

/**
 * 招商银行
 *
 * @author weigs
 * @date 2017/9/21 0021
 */
public class bank2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        safeCode(input);
    }

    private static void safeCode(String str) {
        if (str.length() > 20) {
            System.out.println(str.length() - 20);
            return;
        } else if (str.length() < 6) {
            System.out.println(6 - str.length());
            return;
        }

        char[] chars = str.toCharArray();
        int sum = 0;
        int upnum = 0;
        int lownum = 0;
        int dignum = 0;
        for (char c : chars) {
            if (Character.isUpperCase(c))
                upnum++;
            if (Character.isLowerCase(c))
                lownum++;
            if (Character.isDigit(c))
                dignum++;

        }

        if (upnum == 0)
            sum++;
        if (lownum == 0)
            sum++;
        if (dignum == 0)
            sum++;

        int maxLen = 0;
        int i = 0;
        int len = 1;
        while (i < chars.length - 1) {
            if (chars[i] == chars[++i]) {
                len++;
            } else if (len >= 3) {
                maxLen = maxLen + len - 2;
                len = 1;

            }
        }

        sum = sum + maxLen;
        System.out.println(sum);
    }
}
