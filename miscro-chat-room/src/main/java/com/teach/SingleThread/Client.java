package com.teach.SingleThread;

import javafx.scene.transform.Scale;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.security.Principal;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",8080);
        Scanner read = null;
        PrintStream write  =null;
         try {

             read = new Scanner(client.getInputStream());
             write = new PrintStream(client.getOutputStream());

             write.println("Hi i am a client");
             if (read.hasNext()) {
                 System.out.println("服务器发送如下消息：" + read.nextLine());
             }
         }catch (IOException e){
             e.printStackTrace();
         }finally {
             client.close();
             read.close();;
             write.close();
         }
    }
}
