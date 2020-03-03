package com.zn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        if (name == null || name.trim().length() == 0) {
            name = "世界";
        }

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("<h1>Hello</h1>");
        resp.getWriter().println("<h2>你好" + name + "</h2>");
        resp.getWriter().println("<p>我已经修改了代码</p>");
        try {
            throw new Exception("我随便写点社么");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
