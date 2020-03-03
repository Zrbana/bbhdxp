package com.zn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private void printMessage(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().printf("<p>%s</p>", message);
        System.out.println(message);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 这里设置的 请求的 编码，告诉 Tomcat，按照 utf-8 的字符集解析用户提交上来的信息
        req.setCharacterEncoding("utf-8");

        // 这里设置的 响应的 编码，告诉 浏览器，按照 utf-8 的字符集编码，读得到响应信息
        resp.setContentType("text/html; charset=utf-8");

        printMessage(resp, "用户名 = " + req.getParameter("username"));
        printMessage(resp, "昵称 = " + req.getParameter("nickname"));
        printMessage(resp, "密码 = " + req.getParameter("password"));
        printMessage(resp, "确认密码 = " + req.getParameter("password-confirm"));
        printMessage(resp, "个性签名 = " + req.getParameter("brief"));
    }
}
