package com.cqupt.text.RTTI;

/**
 * @author weigs
 * @date 2017/5/30 0030
 */
public class B extends A{
    public String show(B b) {
        return "B and B";
    }
    public String show (A a){
        return "B and A";
    }
}
