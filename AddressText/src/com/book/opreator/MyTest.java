package com.book.opreator;

import com.book.dbutils;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyTest {
    public static void main(String[] args) throws SQLException {
        MyTest my = new MyTest();
        my.modify();
    }


    //显示所有联系人信息
    public void selectAll() throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;

        String url = "jdbc:mysql://localhost:3306/book";
        String user = "root";
        String password = "root";
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection(url, user, password);
            //3.获取statement对象
            stmt = connection.createStatement();
            //4.使用statement执行sql语句
            String sql = "select * from msg";
            res = stmt.executeQuery(sql);
            //5.操作结果集

            System.out.println("姓名  |  地址  |  手机号码  |  家庭号码  |  邮编  |  邮箱 ");
            while (res.next()) {

                String name = res.getString("name");
                String address = res.getString("address");
                String phoneNumber = res.getString("phoneNumber");
                String familyNumber = res.getString("familyNumber");
                String postalCode = res.getString("postalCode");
                String Email = res.getString("Email");

                System.out.println(name + "  " + address + "  " + phoneNumber +
                        "  " + familyNumber + "  " + postalCode + "  " + Email);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    //5.显示联系人
    public static List<Person> display() throws SQLException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res = null;


        con = dbutils.getConnection();
        String sql = "desc msg";
        pst = con.prepareStatement(sql);
        res = pst.executeQuery();
        List<Person> ans = new ArrayList<Person>();
        while (res.next()) {
            Person per = new Person();
            per.setName(per.getName());
            per.setAddress(per.getAddress());
            per.setPhoneNumber(per.getPhoneNumber());
            per.setFamilyNumber(per.getFamilyNumber());
            per.setPostalCode(per.getPostalCode());
            per.setEmail(per.getEmail());
            ans.add(per);
            per.toString();
        }


        dbutils.close(con, pst, res);

        return ans;

    }

    // 添加联系人信息
    public static void insert(Person per) {
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;

        String url = "jdbc:mysql://localhost:3306/book";
        String user = "root";
        String password = "root";


        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection(url, user, password);
            //3.获取statement对象
            stmt = connection.createStatement();
            //4.使用statement执行sql语句
            String sql = "insert into msg(name,phoneNumber, Email,familyNumber,address,postalCode) values(?,?,?,?,?,?)";
            res = stmt.executeQuery(sql);
            //5.操作结果集

            stmt = connection.prepareStatement(sql);

            //stmt.setString(1,per.getName());

/**
 stmt.setInt(1, stu.getSn());
 stmt.setString(3, stu.getName());
 stmt.setInt(2,stu.getClassid());
 stmt.execute();
 */
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void modify() {//name,phoneNumber, Email,familyNumber,address,postalCode
        Connection connection = null;
        Statement stmt = null;
        ResultSet res = null;

        String url = "jdbc:mysql://localhost:3306/book";
        String user = "root";
        String password = "root";
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            connection = DriverManager.getConnection(url, user, password);
            //3.获取statement对象
            stmt = connection.createStatement();
            //4.使用statement执行sql语句
            Scanner in = new Scanner(System.in);
            String modifyName = in.next();
            String mphone = in.next();
            String mfamily = in.next();
            String maddress = in.next();
            String mpostalcode = in.next();
            String mEmail = in.next();
            System.out.println("请输入修改的联系人姓名：");
            System.out.println("请输入修改的联系人手机号码：");
            System.out.println("请输入修改的联系人家庭号码：");
            System.out.println("请输入修改的联系人地址：");
            System.out.println("请输入修改的联系人邮编：");
            System.out.println("请输入修改的联系人Email：");

            String sql = "update msg set name=" + modifyName + ",phoneNumber=" + mphone + ",familyNumber=" + mfamily
                    + ",address=" + maddress + ",postalCode=" + mpostalcode + ",Email=" + mEmail + "where name=" + modifyName;
            res = stmt.executeQuery(sql);


            int count = stmt.executeUpdate(sql);
            if (count > 0) {
                System.out.println("修改成功！");
            } else {
                System.out.println("联系人不存在！修改失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}