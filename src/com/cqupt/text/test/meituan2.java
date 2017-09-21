package com.cqupt.text.test;

/**
 * @author weigs
 * @date 2017/8/31 0031
 */

import java.util.Arrays;
import java.util.Scanner;

public class meituan2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] s = new int[n];
        for (int i = 0; i < s.length; i++) {
            s[i] = scanner.nextInt();
        }
        Arrays.sort(s);
        int sum = 0;
        for (int i = 0; i < s.length - 1; i++) {
            sum += s[i];
        }
        if (sum < s[s.length - 1]) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }

        scanner.close();
    }

}

