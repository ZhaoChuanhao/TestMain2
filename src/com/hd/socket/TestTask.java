package com.hd.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 赵传昊 on 2018/7/16.
 */
public class TestTask implements Runnable {
    private Socket socket;

    TestTask(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is;
        OutputStream os;
        try {
            is = socket.getInputStream();
            os = socket.getOutputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String request = null;
            while((request = br.readLine()) != null){
                System.out.print("client：" + request);
            }

            Scanner scan = new Scanner(System.in);
            System.out.print("server：");
            String response = scan.next();
            PrintWriter pw = new PrintWriter(os);
            pw.println(response);
            pw.flush();
            pw.close();
            br.close();
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
