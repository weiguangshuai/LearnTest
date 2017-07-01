package com.cqupt.text.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weigs
 * @date 2017/7/1 0001
 */
public class LambdaMap {

    public static void testMap() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
    }

    public static void testReduce() {
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500, 600);
        double bill = costBeforeTax.stream()
                .map((cost) -> cost + 0.12 * cost).reduce((sum, cost) -> sum + cost).get();
        System.out.println(bill);
    }

    public static void testFilter() {
        List<String> list = Arrays.asList("java", "perl", "python", "php", "c++");
        List<String> filter = list.stream().filter(x -> x.length() > 3).collect(Collectors.toList());
        System.out.println(filter);
        String language = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(language);
    }

    public static void main(String[] args) {
//        testMap();
//        testReduce();
        testFilter();
    }
}
