package com.cqupt.text.offer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author weigs
 * @date 2017/9/19 0019
 */
public class Capital {
    public double Power(double base, int exponent) {
        double result = 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
            return result;
        } else if (exponent == 0) {
            return 1;
        } else {
            for (int i = 0; i < -exponent; i++) {
                result = result * base;
            }
            return 1 / result;
        }
    }

}
