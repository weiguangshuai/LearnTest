package com.cqupt.text.exp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weigs
 * @date 2017/6/5 0005
 */
public class Chapter8 {
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        boolean flag = true;
        List<String> list = new ArrayList<String>();
        while (flag == true) {
            String textLine = keyboard.nextLine();
            if (textLine.length() > 0 && textLine.charAt(0) == '.') {
                flag = false;
            } else {
                list.add(textLine);
            }
        }
        System.out.println("请输入你要保存的文件名：");
        String fileName = keyboard.nextLine();
        if (fileName.length() != 0) {
            if (new File("f:\\demo\\" + fileName + ".txt").exists()) {
                System.out.println("请重新输入文件名：");
                fileName = keyboard.nextLine();
            }
        } else {
            System.out.println("文件名不能为空");
            System.exit(0);
        }
        File file = new File("f:\\demo\\" + fileName + ".txt");
        PrintWriter ps = new PrintWriter(file);

        for (String str : list) {
            ps.write(str);
        }
        ps.close();
        System.out.println("打印新创建的文本的内容");
        openFile(fileName);

    }

    public static void openFile(String filename) throws IOException {
        FileReader file = new FileReader("f:/demo/"+filename+".txt");
        BufferedReader bufferedReader = new BufferedReader(file);
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
    }
}


