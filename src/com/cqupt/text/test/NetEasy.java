package com.cqupt.text.test;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/8/12 0012
 */
public class NetEasy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputs = input.split(" ");
        //转换成int型
        int[] intInput = new int[inputs.length];
        for (int i = 0; i < 4; i++) {
            intInput[i] = Integer.parseInt(inputs[i]);
        }
        //将输入的值分别赋予x，f,d,p
        int x = intInput[0], f = intInput[1],
                d = intInput[2], p = intInput[3];
        //将手中的苹果看作是自己手中的钱
        if (d != 0 && x != 0 && f != 0 && p != 0) {
            int num = (d + f * p) / (x + p);
            System.out.println(num);
        }
    }
}
