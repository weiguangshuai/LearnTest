package com.cqupt.text.book.p454;

import java.io.*;

/**
 * @author weigs
 * @date 2017/5/27 0027
 */
public class ReadFile {

    public static void main(String[] args) {
        try {
            File file = new File("f:/exp/demo.txt");
            FileReader fileReader = new FileReader(file);

            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
