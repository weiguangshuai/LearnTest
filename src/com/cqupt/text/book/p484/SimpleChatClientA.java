package com.cqupt.text.book.p484;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author weigs
 * @date 2017/5/31 0031
 */
public class SimpleChatClientA {

    public void go() {
        try {
            Socket socket = new Socket("127.0.0.1",4100);

            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String line = bufferedReader.readLine();
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SimpleChatClientA simpleChatClientA = new SimpleChatClientA();
        simpleChatClientA.go();
    }
}
