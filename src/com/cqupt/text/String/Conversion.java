package com.cqupt.text.String;

import java.util.Formatter;

/**
 * @author weigs
 * @date 2017/5/29 0029
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter formatter = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        formatter.format("s:%s\n", u);
        formatter.format("c:%c\n",u);
        formatter.format("b:%b\n",u);

        int v = 111;
        System.out.println("v = 111");
        formatter.format("s:%s\n",v);
        formatter.format("c:%c\n",v);
    }
}
