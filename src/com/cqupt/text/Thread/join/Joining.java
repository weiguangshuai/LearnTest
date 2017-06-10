package com.cqupt.text.Thread.join;

/**
 * @author weigs
 * @date 2017/6/9 0009
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper
                sleeper = new Sleeper("sleepy", 1500),
                grumpy = new Sleeper("grumpy", 1500);

        Joiner
                dopey = new Joiner("dopey", sleeper),
                doc = new Joiner("doc", grumpy);
        grumpy.isInterrupted();
    }
}
