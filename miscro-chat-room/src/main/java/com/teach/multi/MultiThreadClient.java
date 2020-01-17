package com.teach.multi;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端类
 */
public class MultiThreadClient {

    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1",6666);
        Thread readFromServer = new Thread(new ReadThread(client));
        Thread writeToServer = new Thread(new writeThread(client));
        readFromServer.start();
        writeToServer.start();
    }
}

/**
 * 读线程
 */
class ReadThread implements Runnable{

    private Socket client;
    public ReadThread(Socket client){
        this.client=client;
    }
    public void run() {

        //获取客户端输入流
        try {
            Scanner in = new Scanner(client.getInputStream());
            //设定自己的分割标志
            in.useDelimiter("\n");
            while(true){
                String str = "";
                if(in.hasNext()){
                    str = in.next();
                    System.out.println(str);
                }
                //用户退出
                if(str.equals("quit")){
                    break;
                }
            }

        } catch (IOException e) {
            System.out.println("客户端读线程异常，错误为"+e);
        }
    }
}


/**
 *写线程
 *
 */
class writeThread implements Runnable{

    private Socket client;
    public writeThread(Socket client){
        this.client  =client;
    }

    public void run() {
        //读取从键盘的输入
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        try {
            PrintStream out = new PrintStream(client.getOutputStream());
            while(true){
                String str = "";
                if(scanner.hasNext()){
                    str = scanner.nextLine().trim();
                    out.println(str);
                }
                if(str.equals("quit")){
                    System.out.println("该用户下线");
                    out.close();
                    scanner.close();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("客户端写线程异常。错误为"+e);
        }
    }
}



















