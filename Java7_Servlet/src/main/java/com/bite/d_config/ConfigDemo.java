package com.bite.d_config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * ServletConfig：称为Servlet的配置对象  （一个web工程中，servletConfig可以有多个）
 *      配置初始化参数
 *      web.xml 中servlet中配置
 *
 *      doGet如何获取ServletConfig
 *
 *      HttpServlet的父类
 *  public ServletConfig getServletConfig() {
 * 	return config;}
 */
public class ConfigDemo extends HttpServlet {
  /*  public ConfigDemo(){
        //声明ServletConfig对象
    }*/
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //HttpServletRequest：封装一些方法 ：会话技术有关
        // getSession():获取Session域对象
        //getCookies();获取cookie数组（cookie信息）
        ServletConfig config = this.getServletConfig();
        //获取servlet中初始化参数
        // 通过初始化参数名称获取参数值
        // public String getInitParameter(String name);

        String path = config.getInitParameter("path");
//        getInitParameterNames() ;  获取所有参数名称对应内容


        //读取一个磁盘上的文件内容：e:/aaa.txt :讲过内容输出到控制台
//        BufferedReader br = new BufferedReader(new FileReader("e:/aaa.txt")) ;
        BufferedReader br =
                new BufferedReader(new FileReader(path)) ;
        String line = null ;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
