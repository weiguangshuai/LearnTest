package com.cqupt.text.lambda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weigs
 * @date 2017/7/1 0001
 */
public class LambdaDistinct {
    public static void main(String[] args) {
//        testDistinct();
        testStream();
    }

    public static void testDistinct() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 4, 3, 23, 3);
        List<Integer> distincted = list.stream().map(i -> i)
                .distinct().collect(Collectors.toList());
        System.out.println(distincted);
    }

    public static void testStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 25, 6, 3, 4, 23, 12, 11, 222);
        IntSummaryStatistics stats = list.stream().mapToInt(x -> x)
                .summaryStatistics();
        System.out.println("max num：" + stats.getMax());
        System.out.println("min num: " + stats.getMin());
        System.out.println("sum num: " + stats.getSum());
        System.out.println("avg num:"+stats.getAverage());
    }
}
