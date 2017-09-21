package com.cqupt.text.offer;

import java.util.Stack;

/**
 * @author weigs
 * @date 2017/9/8 0008
 */
public class Binary {
    public static void main(String[] args) {
        Binary binary = new Binary();
        System.out.println(binary.NumberOf1(-2147483647));
    }

    public int NumberOf0(int n) {
        int t = 0;
        char[] ch = Integer.toBinaryString(n).toCharArray();
        for (char aCh : ch) {
            if (aCh == '1') {
                t++;
            }
        }
        return t;
    }

    private int NumberOf1(int n) {
        Stack<Integer> stack = new Stack<>();
        int result = Math.abs(n);
        int remainder = 0;
        while (result > 0) {
            remainder = result % 2;
            stack.push(remainder);
            result = result / 2;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
        int sum = 0;
        char[] chars = sb.toString().toCharArray();
        for (char aChar : chars) {
            if (n > 0) {
                if (aChar == '1')
                    sum++;
            } else {
                if (aChar == '0')
                    sum++;
            }
        }
        return sum;
    }
}