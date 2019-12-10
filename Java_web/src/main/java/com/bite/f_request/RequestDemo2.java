package com.bite.f_request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头
 *  referer:非法链接
 * 1)如果直接访问下载链接地址(xxServlet) :null
 * 2)当前访问地址没有经过广告页面的跳转(!referer.contains("adv.html"))
 */
public class RequestDemo2 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");
        //获取请求头
        String referer = request.getHeader("referer");
        System.out.println("referer:"+referer); //null

        //判断是否是否非法链接
        if(referer==null || !referer.contains("adv.html")){
            //Referer: http://localhost:8080/RequestDemo2
            response.getWriter().write("您当前访问的是否非法链接,<a href='/adv.html'>请跳转到广告页面</a>");
        }else{
            response.getWriter().print("访问资源地址,下载资源文件");
        }




    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
