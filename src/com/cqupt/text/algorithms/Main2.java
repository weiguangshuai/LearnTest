package com.cqupt.text.algorithms;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/8/26 0026
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int[] num = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            num[i] = Integer.parseInt(inputs[i]);
        }
        int k = sc.nextInt();
        sort(num);
        System.out.println(num[num.length - k]);
    }

    private static void sort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int tmp = a[i];
            int j = 0;
            for (j = i - 1; j >= 0 && a[j] > tmp; j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }
}
