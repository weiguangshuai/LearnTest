package com.cqupt.text.RTTI;

/**
 * @author weigs
 * @date 2017/5/30 0030
 */
public class Cat extends Animal {
    public void fun1(String a) {
        System.out.println("Cat的fun1方法");
        fun2();
    }

    public void fun2() {
        System.out.println("Cat的fun2方法");
    }
}
