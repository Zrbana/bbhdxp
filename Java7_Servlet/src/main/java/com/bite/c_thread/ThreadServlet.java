package com.bite.c_thread;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet
 * 单实例，多线程的！
 * 统计访客人数
 *
 * 校验多线程安全问题的标准？
 *  1）查看当前环境是否是多线程环境
 *  2）是否存在共享数据
 *  3）是否有多条语句对共享数据操作
 *          将多条语句对共享数据的操作使用synchronized包起来
 *          同步代码块
 *
 *
 */
public class ThreadServlet extends HttpServlet {
        //成员变量
    private static int count = 1 ;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //解决乱码
        response.setContentType("text/html;charset=utf-8");
        synchronized (ThreadServlet.class){   //synchronized(锁对象)：任意对象
            //同步方法（非静态）：this
            //静态的同步方法：类名.class
            response.getWriter().write("当前访客是第："+count+"个");

            //睡上5秒(延迟)
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count ++ ;
        }


    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //在doPost方法中调用doGet（）
        doGet(request,response);
    }
}
