package com.zn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/get-session")
public class GetSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String now = (String) session.getAttribute("now");
        String name = (String) session.getAttribute("name");
        printMessage(resp, "Now = " + now);
        printMessage(resp, "Name = " + name);
    }

    private void printMessage(HttpServletResponse resp, String message) throws IOException {
        resp.getWriter().printf("<p>%s</p>", message);
        System.out.println(message);
    }
}
