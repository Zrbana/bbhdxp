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

    private static final String URL = "jdbc:mysql://localhost:3306";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static DataSource dataSource = null;

    //创建数据库连接
    public static DataSource getConnection(){

        try {
            return (DataSource) getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    //关闭数据库连接
    public static void close(Connection connection, Statement statement, ResultSet resultSet){

        if(resultSet ==null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement == null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection == null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
