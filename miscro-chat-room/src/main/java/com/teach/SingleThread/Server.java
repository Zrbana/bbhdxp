package com.teach.SingleThread;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        server = new ServerSocket(8080);

        Scanner read = null;
        PrintStream write = null;
        try {

            //取得客户的socket
            Socket clientSocket = server.accept();
            //取得输入输出流
            read  =new Scanner(clientSocket.getInputStream());
            write = new PrintStream(clientSocket.getOutputStream());
            //数据的读取
            if (read.hasNext()) {
                System.out.println("客户端发送如下消息：" + read.nextLine());
            }
            write.println("hi,i am a server");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            server.close();
            read.close();
            write.close();
        }
    }
}
