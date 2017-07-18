package com.cqupt.text.Collection.test;

import java.util.*;

/**
 * @author weigs
 * @date 2017/7/15 0015
 */
public class ListPerformance {
    static Random random = new Random();
    static int reps = 1000;
    static List<Test<List<Integer>>> tests =
            new ArrayList<>();
    static List<Test<LinkedList<Integer>>> qTests =
            new ArrayList<>();

    static {
        tests.add(new Test<List<Integer>>("add") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops;
                int listSize = testParam.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < listSize; j++)
                        container.add(j);
                }
                return loops * listSize;
            }
        });

        tests.add(new Test<List<Integer>>("get") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.get(random.nextInt(listSize));
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("set") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops * reps;
                int listSize = container.size();
                for (int i = 0; i < loops; i++)
                    container.set(random.nextInt(listSize), 47);
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("iteradd") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                final int LOOPS = 1000000;
                int half = container.size() / 2;
                ListIterator<Integer> integerListIterator =
                        container.listIterator(half);
                for (int i = 0; i < LOOPS; i++)
                    integerListIterator.add(47);
                return LOOPS;
            }
        });

        tests.add(new Test<List<Integer>>("insert") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops;
                for (int i = 0; i < loops; i++)
                    container.add(5, 47);
                return loops;
            }
        });

        tests.add(new Test<List<Integer>>("remove") {
            @Override
            int test(List<Integer> container, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    while (container.size() > 5)
                        container.remove(5);
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("addFirst") {
            @Override
            int test(LinkedList<Integer> container, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++)
                        container.addFirst(47);
                }
                return loops * size;
            }
        });

        qTests.add(new Test<LinkedList<Integer>>("addLast") {
            @Override
            int test(LinkedList<Integer> container, TestParam testParam) {
                int loops = testParam.loops;
                int size = testParam.size;
                for (int i = 0; i < loops; i++) {
                    container.clear();
                    for (int j = 0; j < size; j++)
                        container.addLast(47);
                }
                return loops * size;
            }
        });



    }
}
