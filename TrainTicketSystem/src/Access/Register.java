package Access;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Register {
    private Connection connection;
    public Register(String a, String b){
        try {
            Class.forName("com.jdbc.mysql.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
            String sql = "insert into UserMsg values('"+a+"','"+b+"')";
            String sql2 = "create table"+a+"OrderMsg(ID varchar(10),begin varchar(20),end varchar(20)," +
                    "beginTime varchar(30),foreign key(ID)reference msg(ID) )";
            Statement statement = null;
            statement=connection.createStatement();
            statement.executeUpdate(sql);
            statement.executeUpdate(sql2);
            connection.close();
            JOptionPane.showMessageDialog(null,"注册成功！");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,"注册失败！");
            e.printStackTrace();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"注册失败！");

            e.printStackTrace();
        }

    }
}
