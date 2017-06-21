package com.cqupt.text.exp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/6/5 0005
 */
public class Temperature {
    public static void main(String[] args) throws IOException {
        /*
        System.out.println("请输入华氏温度：");
        Scanner keyboard = new Scanner(System.in);
        double F = keyboard.nextDouble();
        System.out.println("摄氏温度为：");
        FtoC(F);

        System.out.println("请输入摄氏问题：");
        double C = keyboard.nextDouble();
        System.out.println("华氏温度为：");
        CtoF(C);
        */
        System.out.println("请输入需要转换的数值：");
        Scanner keyboard = new Scanner(System.in);
        double key = keyboard.nextDouble();
        if (key != 0) {
            System.out.print(key + "摄氏度等于");
            CtoF(key);
            System.out.print(key + "华氏度等于");
            FtoC(key);
        } else if (key == 0) {
            System.out.format("%10s %10s\n", "Celsius", "Fahrenheit");
            for (float i = -20, j = -4; i <= 25; i = i + 5, j = j + 9) {
                System.out.format("%10.2f %10.2f\n", i, j);
            }
        }
        printTemperature();

    }

    public static void FtoC(double F) {
        int C = (int) ((F - 30) / 1.8);
        System.out.println(C + "摄氏度");
    }

    public static void CtoF(double C) {
        int F = (int) (30 + C * 1.8);
        System.out.println(F + "华氏度");
    }

    public static void printTemperature() throws IOException {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("f:/demo/Filecopy.java",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.format("%10s %10s\n", "Celsius", "Fahrenheit");
        fileWriter.write("Celsius   Fahrenheit\n");
        for (float i = -20, j = -4; i <= 25; i = i + 5, j = j + 9) {
            System.out.format("%10.2f %10.2f\n", i, j);
            fileWriter.write(i+"    "+j+"\n");
        }
        fileWriter.close();
    }
}
