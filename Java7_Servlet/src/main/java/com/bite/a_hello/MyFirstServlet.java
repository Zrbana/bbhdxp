package com.bite.a_hello;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 自定义类 继承自 HttpServlet
 *
 * MVC
 * V：jsp（视图层）
 */
public class MyFirstServlet extends HttpServlet {

    //覆盖doGet（）方法

    //默认get提交
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //响应解决乱码
        response.setContentType("text/html;charset=utf-8");


        //向浏览器输出内容
        response.getWriter().print("这是我第一个Servlet"+"<br/>");
        response.getWriter().write("当前系统时间是："+new Date());
    }
}
