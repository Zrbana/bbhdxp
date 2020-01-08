import java.sql.*;

import static sun.plugin.javascript.navig.JSType.URL;

public class Test {
    public static void main(String[] args) throws SQLException {
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/book";
        String name = "root";
        String password ="root";
                //1.加载驱动程序
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,name,password);
            //3.通过数据库的连接操作数据库，实现增删改查
            Statement stmt = conn.createStatement();
            rs = stmt.executeQuery("select name from msg");//选择import java.sql.ResultSet;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        while(rs.next()){//如果对象中有数据，就会循环打印出来
                        System.out.println(rs.getString("name"));
                    }
           }
    }

