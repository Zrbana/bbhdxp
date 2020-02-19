package Dao;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 创建数据库连接的工具类
 */
public class DBUtil {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/image_server?characterEncoding=utf8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static volatile DataSource dataSource = null;

    //创建数据库连接
    public static Connection getConnection(){

        try {
            return  getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet) {


            try {
                if(resultSet == null)
                resultSet.close();
                if(statement == null) {
                    statement.close();
                }
                if(connection == null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    //关闭数据库连接
    public static void close(Connection connection, Statement statement) {


        try {

            if(statement == null) {
                statement.close();
            }
            if(connection == null) {
                connection.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    //创建DataSource的单例方法
    public static DataSource getDataSource(){
        if (dataSource == null) {
            synchronized (DBUtil.class) {
                if(dataSource == null){
                    dataSource = new MysqlDataSource();
                    MysqlDataSource tempDataSource = (MysqlDataSource) dataSource;
                    tempDataSource.setURL(URL);
                    tempDataSource.setUser(USERNAME);
                    tempDataSource.setPassword(PASSWORD);

                }
            }
        }
        return dataSource;
    }



}
