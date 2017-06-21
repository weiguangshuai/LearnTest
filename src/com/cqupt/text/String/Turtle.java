package com.cqupt.text.String;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author weigs
 * @date 2017/5/29 0029
 */
public class Turtle {
    private String name;
    private Formatter f;

    public Turtle(String name, Formatter f) {
        this.f = f;
        this.name = name;
    }

    public void move(int x, int y) {
        f.format("%s The Turtle is at (%d,%d)\n", name, x, y);
    }

    public static void main(String[] args) {
//        PrintStream out = System.out;
        Turtle turtle = new Turtle("Terry",
                new Formatter(System.out));
        turtle.move(1, 3);

        Formatter formatter = new Formatter(System.out);

    }
}
