package com.cqupt.text.IO.InputOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author weigs
 * @date 2017/7/16 0016
 */
public class OSExecute {
    public static void command(String command) throws IOException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
        String s;
        while ((s = bufferedReader.readLine()) != null)
            System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        command("perl f:\\demo.pl");
    }
}
