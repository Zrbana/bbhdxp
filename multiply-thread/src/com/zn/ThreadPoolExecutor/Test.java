package com.zn.ThreadPoolExecutor;

import java.util.concurrent.*;

public class Test {
    /**
     * public ThreadPoolExecutor(int corePoolSize,基本大小
     * int maximumPoolSize,
     * long keepAliveTime,线程活动保持时间
     * TimeUnit unit,
     * BlockingQueue<Runnable> workQueue,
     * RejectedExecutionHandler handler)
     */
    public static void main(String[] args) {
        RunnableThread runnableThread = new RunnableThread();
        CallableThread callableThread = new CallableThread();

        //创建一个线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 2000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>());

        for(int i=0;i<5;i++){
            //使用execute()用于提交不需要返回值的任务，所以无法判断任务是否被执行成功
            threadPoolExecutor.execute(runnableThread);
        }

        for (int i = 0; i < 5; i++) {
            Future<String> future = threadPoolExecutor.submit(callableThread);
            try {
                String str = future.get();
                System.out.println(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}


class RunnableThread implements Runnable{

    @Override
    public void run() {
        for(int i = 0;i< 50;i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
        }
    }
}




class CallableThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        for(int i =0;i<50;i++){
            System.out.println(Thread.currentThread().getName()+"、"+i);
        }
        return Thread.currentThread().getName()+"任务执行完毕";
    }
}











