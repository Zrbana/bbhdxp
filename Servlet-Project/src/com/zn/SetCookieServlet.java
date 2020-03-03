package com.zn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-cookie")
public class SetCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        {
            Cookie cookie = new Cookie("name", "peixinchen");
            resp.addCookie(cookie);
        }
        {
            Cookie cookie = new Cookie("age", "18");
            cookie.setMaxAge(10 * 60);  // 10 分钟以后
            resp.addCookie(cookie);
        }

        resp.getWriter().println("<h1>通过 Cookie 对象 来种 Cookie</h1>");
    }

    private void setCookie1(HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        resp.setHeader("Set-Cookie", "name=peixinchen");
        resp.getWriter().println("<h1>手写 Header 来种 Cookie</h1>");
    }
}
