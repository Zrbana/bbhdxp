package com.zn.synchornized;

public class TestDemo_01 {

    public static void main(String[] args) {
        Thread_01 t  = new Thread_01();
        Thread t1 = new Thread(t,"黄牛A");
        Thread t2 = new Thread(t,"黄牛B");
        Thread t3 = new Thread(t,"黄牛C");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();

        Thread_02 th = new Thread_02();
        Thread th1 = new Thread(th,"黄牛A");
        Thread th2 = new Thread(th,"黄牛B");
        Thread th3 = new Thread(th,"黄牛C");
        t1.start();
        t2.start();
        t3.start();
    }
}
//使用同步代码块，必须锁定一个对象
class Thread_01 implements Runnable {
    private int ticket = 1000; // 一共100张票
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
// 在同一时刻，只允许一个线程进入代码块处理
            synchronized(this) { // 表示为程序逻辑上锁
                if(this.ticket>0) { // 还有票
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
// TODO Auto-generated catch block
                        e.printStackTrace();
                    } // 模拟网络延迟
                    System.out.println(Thread.currentThread().getName()+",还有"
                            +this.ticket -- +" 张票");
                }
            }
        }
    }
}

//使用同步方法
class Thread_02 implements Runnable{

    private int ticket = 100;

    @Override
    public void run() {
        for(int i = 0;i< 100;i++){
            try {
                this.sale();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void sale() throws InterruptedException {
        if(this.ticket > 0){
            Thread.sleep(200);
            System.out.println(Thread.currentThread().getName()+",还有"+ticket--
            +"张票");
        }
    }
}