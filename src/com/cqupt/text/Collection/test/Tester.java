package com.cqupt.text.Collection.test;

import java.util.List;

/**
 * @author weigs
 * @date 2017/7/15 0015
 */
public class Tester<C> {
    public static int fieldWidth = 8;
    public static TestParam[] defaultParams =
            TestParam.array(10, 5000, 100, 5000, 1000, 5000, 10000, 500);
    protected C container;

    protected C initialize(int size) {
        return container;
    }

    private String headLine = "";
    private List<Test<C>> tests;

    private static String stringField() {
        return "%" + fieldWidth + "s";
    }

    private static String numberField() {
        return "%" + fieldWidth + "d";
    }

    private static int sizeWidth = 5;

    private static String sizeField = "%" + sizeWidth + "s";

    private TestParam[] paramList = defaultParams;

    public Tester(C container, List<Test<C>> tests) {
        this.container = container;
        this.tests = tests;
        if (container != null)
            headLine = container.getClass().getSimpleName();
    }

    public Tester(C container, List<Test<C>> tests, TestParam[] paramList) {
        this(container, tests);
        this.paramList = paramList;
    }

    public void setHeadLine(String newHeadLine) {
        headLine = newHeadLine;
    }

    public static <C> void run(C container, List<Test<C>> tests) {
        new Tester<C>(container, tests).timedTest();
    }

    public static <C> void run(C container, List<Test<C>> tests, TestParam[] paramList) {
        new Tester<C>(container, tests, paramList).timedTest();
    }

    private void displayHeader() {
        int width = fieldWidth * tests.size() + sizeWidth;
        int dashLength = width - headLine.length() - 1;
        StringBuilder head = new StringBuilder(width);
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        head.append(' ');
        head.append(headLine);
        head.append(' ');
        for (int i = 0; i < dashLength / 2; i++)
            head.append('-');
        System.out.println(head);
        System.out.format(sizeField, "size");
        for (Test test : tests)
            System.out.format(stringField(), test.name);
        System.out.println();
    }

    public void timedTest() {
        displayHeader();
        for (TestParam param : paramList) {
            System.out.format(sizeField, param.size);
            for (Test<C> test : tests) {
                C kontainer = initialize(param.size);
                long start = System.nanoTime();
                int reps = test.test(kontainer, param);
                long duration = System.nanoTime() - start;
                long timePerRep = duration / reps;
                System.out.format(numberField(), timePerRep);
            }
            System.out.println();
        }
    }
}
