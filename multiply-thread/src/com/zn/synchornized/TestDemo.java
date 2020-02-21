package com.zn.synchornized;

public class TestDemo {
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        new Thread(mt,"黄牛A").start();
        new Thread(mt,"黄牛B").start();
        new Thread(mt,"黄牛C").start();
        //结果出现负数，这种问题就是不同步操作（多个线程并发处理）
    }
}

class MyThread implements Runnable{

    private int ticket  = 10;//10张票

    @Override
    public void run() {
        while(ticket>0){//还有票
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }//模拟网络延迟
            System.out.println(Thread.currentThread().getName()+",还有"+ticket--+"张票");
        }
    }
}