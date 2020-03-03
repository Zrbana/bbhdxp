package com.zn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/get-cookie")
public class GetCookieServlet extends HttpServlet {
    private void printMessage(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().printf("<p>%s</p>", message);
        System.out.println(message);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            printMessage(resp, "通过 Cookie 对象获取: " + cookie.getName() + ":" + cookie.getValue());
        }
    }

    private void getHeaderCookie(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");

        String cookieValue = req.getHeader("Cookie");
        printMessage(resp, "取到的 Cookie Header 是: " + cookieValue);
    }
}
