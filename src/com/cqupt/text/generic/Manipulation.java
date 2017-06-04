package com.cqupt.text.generic;

/**
 * @author weigs
 * @date 2017/6/1 0001
 */
public class Manipulation {
    public static void main(String[] args) {
        HasF hasF = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hasF);
        manipulator.manipulate();
    }
}

class Manipulator<T extends HasF> {
    private T obj;
    public Manipulator(T t) {
        obj = t;
    }

    public void manipulate() {
        obj.f();
    }
}

class HasF{
    public void f() {
        System.out.println("HasF.f()");
    }
}
