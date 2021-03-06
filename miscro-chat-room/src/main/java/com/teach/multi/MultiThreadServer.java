package com.teach.multi;

import sun.reflect.generics.scope.Scope;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.Principal;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MultiThreadServer {
    //存储所有注册的客户信息
    private static Map<String, Socket> map = new ConcurrentHashMap<String, Socket>();

    //具体处理每个客户端通信的内部类
    static class ExecuteClient implements Runnable{

        private Socket client;
        public ExecuteClient(Socket client){
            this.client=client;
        }
        public void run() {
            String msgFromClient;

            //获取客户端的输入流
            try {
                Scanner in = new Scanner(client.getInputStream());
                while(in.hasNext()){
                    msgFromClient = in.nextLine();
                    Pattern pattern = Pattern.compile("\r");
                    Matcher matcher = pattern.matcher(msgFromClient);
                    //注册流程
                    //注册格式：User：用户名
                    if(msgFromClient.startsWith("U")){
                        String userName = msgFromClient.split("\\:")[1];
                        register(userName,client);
                        continue;
                    }
                    //群聊流程
                    //群聊的格式：G：要发送的信息
                    if(msgFromClient.startsWith("G")){
                        String userName = getUserName(client);
                        String msg = msgFromClient.split("\\:")[1];
                        groupChat(userName,msg);
                        continue;
                    }

                    //私聊流程
                    //私聊格式：P：要发送的对象名-要发送的信息
                    if(msgFromClient.startsWith("P")){
                        String acceptUser = msgFromClient.split("\\:")[1].split("-")[0];
                        String msg = msgFromClient.split("\\.")[1].split("-")[1];
                        String sendUser = getUserName(client);
                        privateChat(sendUser,acceptUser,msg);
                        continue;
                    }

                    //用户退出
                    //退出格式：quit
                   if(msgFromClient.equals("quit")){
                       String userName = getUserName(client);
                       System.out.println("用户"+userName+"下线了");
                       map.remove(userName);
                       System.out.println("当前上线人数为："+map.size());
                       continue;
                   }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        /**
         * 用户注册流程
         * @param userName  用户名
         * @param client  客户端socket
         */
        private void register(String userName,Socket client){
            System.out.println(userName+" "+"上线了" );
            map.put(userName,client);
            System.out.println("当前上线人数为："+map.size());
            PrintStream out = null;
            try {
                out = new PrintStream(client.getOutputStream());

                out.println("注册成功！");
            } catch (IOException e) {
                System.out.println("注册异常，错误为"+e);
            }
        }

        /**
         * 根据socket获取用户名
         * @param socket
         * @return
         */
        private String getUserName(Socket socket){
            for(String name:map.keySet()){
                if(map.get(name).equals(socket)){
                    return name;
                }
            }
            return null;
        }

        /**
         * 私聊流程
         * @param sendUser 发送信息的用户
         * @param acceptUser 接收信息的用户
         * @param msg 发送的信息
         */
        private void privateChat(String sendUser,String acceptUser ,String msg){
            Socket socket = map.get(acceptUser);
            try {
                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println("私聊信息：");
                out.println(sendUser+":"+msg);

            } catch (IOException e) {
                System.out.println("私聊异常，错误为"+e);
            }
        }

        /**
         * 群聊流程
         * @param userName
         * @param msg 客户端发送的信息
         */
        private void groupChat(String userName,String msg){
            //群聊只需要发送用户的信息用entry遍历
            Set<Map.Entry<String,Socket>> set = map.entrySet();
            for(Map.Entry<String,Socket> entry:set){
                try{
                Socket socket = entry.getValue();
                //取得每个客户端的输出流
                    PrintStream out = new PrintStream(socket.getOutputStream());
                    out.println("群聊信息" );
                    out.println(userName+":"+msg );
                } catch (IOException e) {
                    System.out.println("群聊异常，错误为"+e);
                }
            }
        }




    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(50);
        ServerSocket serverSocket = new ServerSocket(6666);
        for(int i =0;i<50;i++){
            System.out.println("等待客户端连接：");
            Socket client = serverSocket.accept();
            System.out.println("有新的客户端连接，端口号为："+client.getPort());
            executorService.submit(new ExecuteClient(client));
        }
        executorService.shutdown();
        serverSocket.close();
    }

}













