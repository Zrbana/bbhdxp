package com.bite.e_refresh;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * refresh响应头:定时刷新/经过n秒执行页面跳转
 */
public class RefreshDemo extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置refrsh响应头
        //定时刷新:
//        response.setHeader("refresh","2"); //2秒

        //经过n秒执行页面跳转
        response.setHeader("refresh","3;url=/adv.html");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
