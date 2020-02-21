package com.zn.ThreadLocal;

public class Test {
    private static String commStr;
    private static ThreadLocal<String> threadStr = new ThreadLocal<>();
    public static void main(String[] args){
        commStr = "main";
        threadStr.set("main");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                commStr = "thread";
                threadStr.set("thread");
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(commStr);//thread
        System.out.println(threadStr.get());//main

        //从运行结果可以看出，对于 ThreadLocal 类型的变量，在一个线程中设置值，不影响其在其它线程中的值。也就是
        //说 ThreadLocal 类型的变量的值在每个线程中是独立的。
    }
}
