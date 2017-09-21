package com.cqupt.text.test;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/9/14 0014
 */

public class meituan3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = scanner.nextInt();
        }

        if (a[a.length - 1] == 1) {
            System.out.println("Alice");
        } else {
            System.out.println("Bob");
        }
    }
}
