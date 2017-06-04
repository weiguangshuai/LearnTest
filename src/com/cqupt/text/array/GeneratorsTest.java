package com.cqupt.text.array;

import com.cqupt.text.generic.Generator;

/**
 * @author weigs
 * @date 2017/6/4 0004
 */
public class GeneratorsTest {

    public static int size = 10;

    public static void test(Class<?> clazz) {
        for (Class<?> type : clazz.getClasses()) {
            System.out.println(type.getSimpleName() + ": ");
            try {
                Generator<?> g = (Generator<?>) type.newInstance();
                for (int i = 0; i < size; i++) {
                    System.out.println(g.next() + " ");
                }
                System.out.println();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        test(CountingGenerator.class);
    }

}
