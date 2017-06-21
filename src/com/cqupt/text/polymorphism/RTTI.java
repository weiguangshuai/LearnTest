package com.cqupt.text.polymorphism;

import java.io.File;

/**
 * @author weigs
 * @date 2017/6/7 0007
 */
public class RTTI {
    public static void main(String[] args) {
        Usefull[] x = {new Usefull(),new MoreUsefull()};

        x[0].f();
        x[1].g();

        ((MoreUsefull)x[1]).u();
        ((MoreUsefull)x[0]).u();//运行时抛出异常
    }
}

class Usefull {
    public void f() {
    }

    public void g() {
    }
}

class MoreUsefull extends Usefull {
    public void f() {
    }

    public void g() {
    }

    public void u() {

    }

    public void v() {

    }

    public void w() {

    }
}
