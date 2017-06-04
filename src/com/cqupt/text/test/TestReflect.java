package com.cqupt.text.test;

/**
 * @author weigs
 * @date 2017/5/28 0028
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> class1 = null;
        Class<?> class2 = null;
        Class<?> class3 = null;

        class1 = Class.forName("com.cqupt.text.test.TestReflect");
        System.out.println(class1.getName());
        class2 = new TestReflect().getClass();
        System.out.println(class2.getName());

        TestReflect testReflect = (TestReflect) class1.newInstance();
        System.out.println(testReflect);

    }
}
