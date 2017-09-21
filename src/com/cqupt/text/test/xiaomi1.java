package com.cqupt.text.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/9/18 0018
 */
public class xiaomi1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        while (true) {
            String s = scanner.nextLine();
            list.add(s);
            if (!s.isEmpty())
                break;
        }
        list.remove(list.size() - 1);


    }

    public static String result(String s) {
        char[] chars = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int[] state = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            if (Character.isLowerCase(chars[i]))
                state[i] = 0;
            else if (Character.isUpperCase(chars[i]))
                state[i] = 1;
            else if (Character.isDigit(chars[i]))
                state[i] = 2;
            else if (chars[i] == '.')
                state[i] = 3;
        }
        stringBuilder.append('_');

        for (int i = 0; i < chars.length; i++) {
            if (i == 0) {
                if (state[i] == 2) {
                    stringBuilder.append("_");
                    stringBuilder.append(chars[i]);
                }
                if (state[i] == 3) {
                    stringBuilder.append("_");
                }
                stringBuilder.append(chars[i]);
            } else if (i == 1) {
                if (state[i] == 0) {
                    if (state[i - 1] == 2) {
                        stringBuilder.append("_");
                    }
                    stringBuilder.append(chars[i]);
                } else if (state[i] == 1) {
                    if (state[i - 1] == 0) {
                        stringBuilder.append("_");
                    }
                    stringBuilder.append(chars[i]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
