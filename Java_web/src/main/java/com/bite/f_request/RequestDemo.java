package com.bite.f_request;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求头:   user-agent:浏览器类型
 */
public class RequestDemo extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //获取请求头 request.getHeader("user-agent") ;
        String userAgent = request.getHeader("user-agent") ;
        System.out.println(userAgent);
        /**
         * IE浏览器
         * Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko
         * 谷歌
         * Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.377
         * firFox:浏览类型
         */
        if(userAgent.contains("Trident")){
            response.getWriter().print("您当前使用 浏览器是IE浏览器");
        }else if(userAgent.contains("Chrome")){
            response.getWriter().print("您当前使用 浏览器是谷歌浏览器");
        }else if(userAgent.contains("firFox")){
            response.getWriter().print("您当前使用 浏览器是火狐浏览器");
        }else{
            response.getWriter().print("您当前的浏览类型无法识别!");
        }


    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
