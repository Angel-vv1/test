package com.example.crawler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;

public class DataSender {
    public static void sendData(List<String> dataList) {
        try {
            Socket socket = new Socket("localhost", 9999);
            OutputStream outputStream = socket.getOutputStream();
            for (String data : dataList) {
                outputStream.write((data + "\n").getBytes());
            }
            outputStream.flush();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
