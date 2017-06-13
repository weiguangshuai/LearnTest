package com.cqupt.text.multithreadpro.Chapter3.customANDproduct;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class C {
    private MyStack myStack;

    public C(MyStack myStack) {
        this.myStack = myStack;
    }

    public void popService() {
        System.out.println("pop=" + myStack.pop());
    }
}
