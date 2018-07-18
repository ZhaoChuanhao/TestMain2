package com.hd.socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 赵传昊 on 2018/7/16.
 */
public class TestClient {
    public static void main(String[] args){
        try {
            Socket socket = new Socket("localhost",8888);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            Scanner scan = new Scanner(System.in);
            System.out.print("client：");
            String response = scan.next();
            PrintWriter pw = new PrintWriter(os);
            pw.println(response);
            pw.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String request = null;
            while((request = br.readLine()) != null){
                System.out.print("server：" + request);
            }

            br.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
