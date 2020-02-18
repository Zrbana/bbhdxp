package Dao;

import common.JavaImageServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库操作的增删改查的方法
 */
public class ImageDao {

    /**
     * 把Image对象插入数据库
     * @param image
     */
    public void insert(Image image) {
        //1.创建连接
        Connection connection = (Connection) DBUtil.getConnection();
        //2.创建SQL语句
        String sql = "INSERT INTO IMAGE_TABLE VALUES(null,?,?,?,?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, image.getImageName());
            statement.setInt(2, image.getSize());
            statement.setString(3, image.getUpload_time());
            statement.setString(4, image.getContentType());
            statement.setString(5, image.getPath());
            statement.setString(6, image.getMd5());

            //3.执行SQL语句
            int ret = statement.executeUpdate();
            if(ret!=1){
                throw new JavaImageServerException("插入数据库出错！");
            }

        } catch (SQLException | JavaImageServerException e) {
            e.printStackTrace();
        }finally {


            //3.关闭数据库
            DBUtil.close(connection,statement,null);
        }


    }

    /**
     * 查找所有的Image对象
     * @return
     */
    public List<Image> selectAll(){

        Image image = new Image();
        List<Image> imageList = new ArrayList<>();
        Connection connection = (Connection) DBUtil.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from image_table";
        try {
            statement = connection.prepareStatement(sql);


            while(resultSet.next()){
                image.setImageID(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUpload_time(resultSet.getString("upload_time"));
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path"));
                image.setMd5(resultSet.getString("md5"));
                imageList.add(image);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return imageList;
    }

    /**
     * 查找单个对象
     * @return
     */
    public Image selectOne(int imageId){

        // 1. 获取数据库连接
        Connection connection = (Connection) DBUtil.getConnection();
        // 2. 构造 SQL 语句
        String sql = "select * from image_table where imageId = ?";
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            // 3. 执行 SQL 语句
            statement = connection.prepareStatement(sql);
            statement.setInt(1, imageId);
            resultSet = statement.executeQuery();
            // 4. 处理结果集
            if (resultSet.next()) {
                Image image = new Image();
                image.setImageID(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUpload_time(resultSet.getString("uploadTime"));
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path"));
                image.setMd5(resultSet.getString("md5"));
                return image;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. 关闭链接
            DBUtil.close(connection, statement, resultSet);
        }
    }

    /**
     * 根据imageID删除指定图片
     * @param imageId
     */
    public void delete(int imageId){
// 1. 获取数据库连接
        Connection connection = (Connection) DBUtil.getConnection();
        // 2. 拼装 SQL 语句
        String sql = "delete from image_table where imageId = ?";
        PreparedStatement statement = null;
        // 3. 执行 SQL 语句

        try {
            statement = connection.prepareStatement(sql);
            statement.setInt(1, imageId);
            int ret = statement.executeUpdate();
            if (ret != 1) {
                throw new JavaImageServerException("删除数据库操作失败");
            }
        } catch (SQLException | JavaImageServerException e) {
            e.printStackTrace();
        } finally {
            // 4. 关闭连接
            DBUtil.close(connection, statement, null);
        }
    }


}
