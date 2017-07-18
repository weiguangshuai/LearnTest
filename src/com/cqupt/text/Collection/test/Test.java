package com.cqupt.text.Collection.test;

/**
 * @author weigs
 * @date 2017/7/15 0015
 */
public abstract class Test<C> {
    String name;

    public Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParam testParam);
}
