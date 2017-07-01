package com.cqupt.text.lambda;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

/**
 * @author weigs
 * @date 2017/6/30 0030
 */
public class LambdaTest1 {
    public static void main(String[] args) throws InterruptedException {
        /*
        new Thread(()-> System.out.println("Hello World")).start();
        TimeUnit.SECONDS.sleep(1);
        System.out.println("main-hello world");
        */
        String[] datas = new String[]{"peng", "zhao", "li"};
        Arrays.sort(datas, (v1, v2) -> Integer.compare(v1.length(), v2.length()));
//        Stream.of(datas).forEach(param -> System.out.println(param));
        Stream.of(datas).forEach(System.out::println);
    }
}
