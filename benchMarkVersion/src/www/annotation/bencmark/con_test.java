package www.annotation.bencmark;
import java.sql.*;

public class con_test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String driver ="com.mysql.jdbc.Driver";  //定义驱动名称
        String url="jdbc:mysql://localhost:3306/jdbctest";   //定义要访问的数据库名(jdbctest为数据库名)
        String user="root";       //数据库用户名
        String password="root";  //数据库登录密码
        try {
            Class.forName(driver);                                 //加载驱动
            System.out.println("正在连接数据库...");
            Connection con = DriverManager.getConnection(url,user,password);   //声明Connection对象并获取数据库连接
            if(!con.isClosed())  System.out.println("数据库连接成功"+"\n");
            Statement stat=con.createStatement();             //创建数据库操作对象
            String sql="select *from stu";                   //执行的sql语句
            ResultSet rs=stat.executeQuery(sql);            //执行sql语句并存放结果
            while(rs.next())                               //遍历结果集
            {
                String name=rs.getString("name");             //数据库name字段信息
                int id=rs.getInt("id");                       //数据库id字段信息
                float score=rs.getFloat("score");             //数据库score字段信息
                System.out.println(id+" "+name+" "+score);
            }
/*********************像IO流一样，使用过的资源都需要关闭******************************/
/***********************先打开的后关闭，后打开的先关闭********************************/
            rs.close();
            stat.close();
            con.close();
/*************************************处理异常**************************************/
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库驱动加载失败");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }finally{
            System.out.println("\n"+"数据库get");
        }

    }
}

