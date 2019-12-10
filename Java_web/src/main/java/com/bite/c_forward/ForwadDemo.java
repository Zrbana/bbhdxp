package com.bite.c_forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext:请求转发
 */
public class ForwadDemo extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //请求转发原理:
        //1)获取全局管理对象
        //2)获取请求分发对象:public RequestDispatcher getRequestDispatcher(String path)
            //将请求转发到服务器的另一个资源
        //3)public void forward(ServletRequest request, ServletResponse response) throws ServletException,
        /*ServletContext context = this.getServletContext();
        RequestDispatcher rd = context.getRequestDispatcher("/adv.html");
        rd.forward(request,response);*/

        //简写方式
        request.getRequestDispatcher("/adv.html").
                forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
