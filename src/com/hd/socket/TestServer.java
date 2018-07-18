package com.hd.socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by 赵传昊 on 2018/7/16.
 */
public class TestServer {
    public static void main(String[] args){
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("localhost", 8888));
            System.out.println("success！");
            while(true){
                Socket socket = serverSocket.accept();
                new Thread(new TestTask(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
