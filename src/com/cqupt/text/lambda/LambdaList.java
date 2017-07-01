package com.cqupt.text.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @author weigs
 * @date 2017/7/1 0001
 */
public class LambdaList {
    public static void main(String[] args) {

        List<String> features = Arrays.asList("java", "perl",
                "python", "c");

        //一般方法遍历
        for (String s : features) {
            System.out.println(s);
        }

        //lambda表达式遍历
        features.forEach(e -> System.out.println(e));
    }


}
