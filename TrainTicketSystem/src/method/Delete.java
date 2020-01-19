package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Delete {
    private Connection conn;
    public Delete(String a,String user){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=火车售票系统","sa","w12621058");
            String sql="delete from "+user+"订购信息 where 车次号='"+a+"'";
            String sql2="update 车次信息 set 剩余票数=剩余票数+1 where 车次号='"+a+"'"; //更新车次信息
            Statement stmt=conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(sql2);
            conn.close();
            JOptionPane.showMessageDialog(null, "退票成功！");
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "退票失败！");
            e.printStackTrace();
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "退票失败！");
            e.printStackTrace();
        }

    }

}
