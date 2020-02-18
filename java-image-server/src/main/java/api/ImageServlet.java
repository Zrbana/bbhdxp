package api;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageServlet extends HttpServlet {
    /**
     * 查看图片属性：即能查看所有，也能查看指定
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过是否URL中带有imageId参数来区分
        String imageId = req.getParameter("iamgeId");
        if(imageId == null || imageId.equals("")){
            selectAll(req,resp);
        }else{
            selectOne(imageId,resp);
        }
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void selectOne( String imageId, HttpServletResponse resp) {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
