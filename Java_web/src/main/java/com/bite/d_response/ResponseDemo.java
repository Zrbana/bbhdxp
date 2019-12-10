package com.bite.d_response;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向:原理:location+302
 */
public class ResponseDemo extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //location+302
        //设置响应头:response.setHeader()
        response.setHeader("location","/adv.html");
        //response.setStatus(int code)
        response.setStatus(302);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
