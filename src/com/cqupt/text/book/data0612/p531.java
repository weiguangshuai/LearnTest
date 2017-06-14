package com.cqupt.text.book.data0612;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author weigs
 * @date 2017/6/12 0012
 */
public class p531 {
    private List<String> songList = new ArrayList<>();

    public static void main(String[] args) {
        new p531().go();
    }

    public void go() {
        getSongs();
        System.out.println(songList);
        System.out.println("+++++++++");
        Collections.sort(songList);
        System.out.println(songList);
        System.out.println("---------");
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(songList);
        System.out.println(hashSet);
        System.out.println("=========");
    }

    private void getSongs() {
        try {
            File file = new File("f:/demo/demo.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                addSong(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addSong(String line) {
        String[] tokens = line.split("/");
        songList.add(tokens[0]);
    }

}
