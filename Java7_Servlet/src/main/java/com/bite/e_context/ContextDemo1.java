package com.bite.e_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext
 *  作用1：获取全局管理者对象-获取全局参数信息
 */
public class ContextDemo1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //1)获取全局管理者对象
        ServletContext context = this.getServletContext();
        String encoding = context.getInitParameter("encoding");
        System.out.println(encoding);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
