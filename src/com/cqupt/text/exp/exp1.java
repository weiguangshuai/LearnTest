package com.cqupt.text.exp;

import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/6/5 0005
 */
public class exp1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("This program makes caculations related to your height." +
                "\n Type 1 to give your height in feet and inchs or" +
                "\n Type 2 to give your height in centimetres.");
        int unitSelection = keyboard.nextInt();
        if (unitSelection == 1) {
            System.out.println("请输入英尺：");
            double feet = keyboard.nextDouble();
            System.out.println("请输入英寸：");
            double inch = keyboard.nextDouble();
            double centimetre = feet * 30.48 + inch * 2.54;
            System.out.println("你的身高为" + centimetre + "cm");
        } else if (unitSelection == 2) {
            System.out.println("请输入你的身高：");
            double centimetre = keyboard.nextDouble();
            double feet = centimetre / 30.48;
            double inch = centimetre % 30.48 / 2.54;
            System.out.format("你的身高为%.2f英尺%.2f英寸", feet, inch);
        } else {
            System.out.println("你做出了错误的单元选择");
        }
    }
}
