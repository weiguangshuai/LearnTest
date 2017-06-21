package com.cqupt.text.InnerClass;

/**
 * @author weigs
 * @date 2017/6/8 0008
 */
public interface ClassInInterface {
    void howdy();
    class Test implements ClassInInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
