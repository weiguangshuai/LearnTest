package com.cqupt.text.test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/9/10 0010
 */
public class didi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        if (number <= 0)
            System.out.println(0);
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while (list.size() < number)//循环的条件
        {
            int m2 = list.get(i2) * 2;
            int m3 = list.get(i3) * 3;
            int m5 = list.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            list.add(min);
            if (min == m2)
                i2++;
            if (min == m3)
                i3++;
            if (min == m5)
                i5++;
        }
        System.out.println(list.get(list.size() - 1));
    }
}
