package com.cqupt.text.book.p484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端代码
 *
 * @author weigs
 * @date 2017/5/31 0031
 */
public class DailyAdviceService {
    String[] adviceList = {"Take smaller bites", "Go for the tight jeans",
            "One world", "Just for today,be honest", "You might want to rethink"};

    public void go() {
        try {
            ServerSocket serverSocket = new ServerSocket(4100);

            while (true) {
                Socket socket = serverSocket.accept();

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                String advice = getAdvice();
                printWriter.write(advice);
                printWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }

    public static void main(String[] args) {
        DailyAdviceService dailyAdviceService = new DailyAdviceService();
        dailyAdviceService.go();
    }
}
