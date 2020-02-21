package com.zn.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        Thread thread_01 = new Thread(threadA,"黄牛A");
        Thread thread_02 = new Thread(threadA,"黄牛B");
        Thread thread_03 = new Thread(threadA,"黄牛C");
        thread_01.setPriority(Thread.MIN_PRIORITY);
        thread_02.setPriority(Thread.MAX_PRIORITY);
        thread_03.setPriority(Thread.MAX_PRIORITY);
        thread_01.start();
        thread_02.start();
        thread_03.start();
    }
}

//使用ReentrantLock
class ThreadA implements Runnable {

    private int ticket = 100;

    private Lock ticketLock = new ReentrantLock();

    @Override
    public void run() {
        for (int i = 0; i < 500; i++) {

            ticketLock.lock();
            try {

                if (ticket > 0) {

                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName() + ",还有" + this.ticket--
                        + "张票");
            } finally {

                ticketLock.unlock();
            }
        }
    }
}