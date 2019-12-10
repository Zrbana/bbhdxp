package com.bite.b_scope;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ServletContext:域对象
 */
public class ScopeDemo1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //public void setAttribute(String name, Object object)
        //获取全局管理对象
        ServletContext context = this.getServletContext();
        //保存数据
        List<String> list = new ArrayList<>() ;
        list.add("java") ;
        list.add("javaEE") ;
        list.add("hadoop") ;
//        context.setAttribute("name","jacky");
        context.setAttribute("list",list);

        //重定向/请求转发到jsp页面
        System.out.println("保存数据成功了....");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
