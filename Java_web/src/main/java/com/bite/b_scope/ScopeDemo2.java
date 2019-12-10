package com.bite.b_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ScopeDemo2 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取ServletContext对象
        ServletContext context =
                this.getServletContext();
        //public Object getAttribute(String name)
//        String name = (String) context.getAttribute("name");
        List<String> list = (List<String>) context.getAttribute("list");
//        System.out.println("name:"+name);
        System.out.println("list:"+list);
        System.out.println("获取到了域中数据");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
