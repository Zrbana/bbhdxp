package com.bite.b_life;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * servlet的生命周期
 *      初始化：public void init(ServletConfig config)
 *      服务方法：service（request，response）
 *
 */
public class LifeServlet extends HttpServlet {
    //创建：new LifeServlet();
    public LifeServlet(){
        System.out.println("serlvet 对象被创建了....");
    }


    //servlet的初始化方法
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("servlet 初始化了。。。");

    }

    /**
     * servlet的服务方法，在访问serlvet默认执行service方法（要根据不同的提交方式判断的）
     *     一般情况：都是覆盖最具体的方法：DoXXX（）方法
     *      doGet()/doPost()
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //源码：通过不同的提交方式来执行不同doXXX方法
        System.out.println("调用了service的服务方法...");
    }

    //post方式提交
    /*
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    */

    //默认get方式提交
   /* protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("servlet默认执行doGet方法。。。");
    }*/

    @Override
    public void destroy() {
        System.out.println("servlet销毁了。。。");
    }
}
