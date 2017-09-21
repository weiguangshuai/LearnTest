package com.cqupt.text.algorithms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" ");
        int[] num = new int[inputs.length];
        for (int i = 0; i < inputs.length; i++) {
            num[i] = Integer.parseInt(inputs[i]);
        }
        int maxFar = Integer.MIN_VALUE, max = 0;
        for (int i = 0; i < inputs.length; i++) {
            max = Math.max(max + num[i], num[i]);
            maxFar = Math.max(max, maxFar);
        }
        System.out.println(maxFar);
    }
}

