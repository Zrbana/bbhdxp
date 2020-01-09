package com.ll.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        request.setCharacterEncoding("utf-8");
        String uri = request.getRequestURI();
        if (uri.contains("/user/regist") || uri.contains("/regist.jsp")||
                uri.contains("/login.jsp") || uri.contains("/user/login") ||
                uri.contains("/css/") || uri.contains("/js/") ||
                uri.contains("/fonts/") || uri.contains("/user/findUser")) {
            chain.doFilter(request, resp);
        } else {
            Object user = request.getSession().getAttribute("user");
            if (user != null) {
                chain.doFilter(req, resp);
            }else {
                request.setAttribute("login_msg", "您尚未登陆,请登录");
                request.getRequestDispatcher("/login.jsp").forward(request, resp);
            }
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
