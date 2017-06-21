package com.cqupt.text.String;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author weigs
 * @date 2017/5/30 0030
 */
public class PatternTest {
    public static void main(String[] args) throws FileNotFoundException {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher("111dddddddd");
        while (matcher.find()) {
            System.out.println(matcher.group());
            if (matcher.matches()) {
                System.out.println("matches() start = " + matcher.start() +
                        " end = " + matcher.end());
            }
            if (matcher.lookingAt()) {
                System.out.println("matches() start = " + matcher.start() +
                        " end = " + matcher.end());
            }
        }

        //读取文件
        Scanner scanner = new Scanner(new File("f:/exp/demo.txt"));
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}
