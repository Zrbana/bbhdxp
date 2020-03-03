package com.zn;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Collection<Part> parts = req.getParts();
        for (Part part : parts) {
            System.out.println(part.getName());
            System.out.println(part.getSubmittedFileName());
            System.out.println(part.getContentType());
            System.out.println(part.getSize());
            Collection<String> headerNames = part.getHeaderNames();
            for (String headerName : headerNames) {
                part.getHeader(headerName);
            }
            InputStream is = part.getInputStream();
            // 使用的是相对路径
            OutputStream os = new FileOutputStream("E:\\uploads\\" + part.getSubmittedFileName());
            byte[] buf = new byte[1024];
            int len;
            while ((len = is.read(buf)) != -1) {
                os.write(buf, 0, len);
            }
            os.close();
            System.out.println("==========================================");
        }
    }
}
