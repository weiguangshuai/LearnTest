package com.cqupt.text.JVM.Chapter2;

/**
 * @author weigs
 * @date 2017/6/20 0020
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable a) {
            System.out.println("stack length:" + sof.stackLength);
            throw a;
        }
    }
}
