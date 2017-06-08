package com.cqupt.text.InnerClass;

/**
 * @author weigs
 * @date 2017/6/8 0008
 */
public class DotNew {
    public class Inner {

    }

    public static void main(String[] args) {
        DotNew dotNew = new DotNew();
        DotNew.Inner dni = dotNew.new Inner();
    }
}
