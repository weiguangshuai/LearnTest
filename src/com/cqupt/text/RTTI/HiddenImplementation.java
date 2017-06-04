package com.cqupt.text.RTTI;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author weigs
 * @date 2017/5/31 0031
 */
public class HiddenImplementation {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ADemo a = HiddenC.makeA();
        a.f();
        System.out.println(a.getClass().getName());
        if (a instanceof CDemo) {
            CDemo c = (CDemo)a;
            c.u();
        }

        callHiddenMethod(a, "g");
        callHiddenMethod(a, "f");
        callHiddenMethod(a, "u");
        callHiddenMethod(a, "v");
        callHiddenMethod(a, "w");
    }

    static void callHiddenMethod(Object a, String methodName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method g = a.getClass().getDeclaredMethod(methodName);
        g.setAccessible(true);
        g.invoke(a);
    }
}

interface ADemo {
    void f();
}

class CDemo implements ADemo {

    @Override
    public void f() {
        System.out.println("public CDemo.f()");
    }

    public void g() {
        System.out.println("public CDemo.g()");
    }

    void u() {
        System.out.println("package CDemo.u()");
    }

    protected void v() {
        System.out.println("protected CDemo.v()");
    }

    private void w() {
        System.out.println("private CDemo.w()");
    }
}

class HiddenC{
    public static ADemo makeA() {
        return new CDemo();
    }
}
