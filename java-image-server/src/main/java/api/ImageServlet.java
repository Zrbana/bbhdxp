package api;

import Dao.Image;
import Dao.ImageDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json;charset=utf-8");
        //1.创建一个Imagedao 对象，并查找数据库
        ImageDao imageDao = new ImageDao();
        List<Image> images =  imageDao.selectAll();
        //2.把查找到的结果转为JSON格式的为字符串，并且写回给response对象
        Gson gson = new GsonBuilder().create();
        String jsonStr = gson.toJson(images);
        resp.getWriter().write(jsonStr);
    }

    private void selectOne( String imageId, HttpServletResponse resp) throws IOException {

        resp.setContentType("application/json;charset=utf-8");
        //创建ImageDao对象
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(Integer.parseInt(imageId));
        Gson gson=new GsonBuilder().create();
        String jsonData = gson.toJson(image);
        resp.getWriter().write(jsonData);

    }

    /**
     * 上传图片
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取图片的属性信息，并存入数据库
        //   a)需要创建一个factory对象和upload对象，是为了获取到图片属性
        //固定的逻辑
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload =new ServletFileUpload(factory);
        //   b)通过upload对象进一步解析请求（解析HTTP请求中body中的内容）

        //FileItem就代表一个上传的文件对象
        //理论上来说，HTTP支持一个请求中同时上传多个文件
        List<FileItem> items  =null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            e.printStackTrace();
            //出现异常说明解析出错
            //告诉客户端具体的错误是什么
            resp.setContentType("application/json;charset=utf-8");
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"请求解析失败\" }" );

            return ;
        }

        //   c)把fileItem的属性提取出来，转成Image对象，才能存入数据率
        //当前只考虑一张图片的情况
        FileItem fileItem = items.get(0);
        Image image =new Image();
        image.setImageName(fileItem.getName());
        image.setSize((int) fileItem.getSize());
        //手动获取一个当前日期，并转成格式化日期
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        image.setUploadTime(dateFormat.format(new Date()));
        image.setContentType(fileItem.getContentType());
        //自己构造一个路径来保存，引入时间戳是为了让文件路径能够唯一
        image.setPath("./image/"+System.currentTimeMillis()+"_"+image.getImageName());

        image.setMd5("11223344");

        //存入数据库
        ImageDao imageDao = new ImageDao();
        imageDao.insert(image);
        //2.获取图片的内容信息，并且写入磁盘文件

        File file = new File(image.getPath());
        try {
            fileItem.write(file);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"写磁盘失败\" }");
            return;
        }
        //3.给客户端返回一个结果数据
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write("{ \"ok\": true }");
    }

    /**
     * 删除指定图片
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json;charset=utf-8");
        //1.获取到请求中的的imageID
        String imageId = req.getParameter("imageId");
        if(imageId == null || imageId.equals("")){
            resp.setStatus(200);
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"解析请求失败\" }");
            return;
        }

        //2.查看该图片的相关属性（为了知道这个图片的路径信息）

        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(Integer.parseInt(imageId));
        if(image==null){
            //此时请求中传入的Id在数据库中不存在
            resp.setStatus(200);
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"imageId 在数据库中不存在\" }");
            return;
        }
        //3.删除数据库记录

        imageDao.delete(Integer.parseInt(imageId));

        //4.删除本地磁盘记录
        File file = new File(image.getPath());
        file.delete();
        resp.setStatus(200);
        resp.getWriter().write("{ \"ok\": true }");
    }
}
