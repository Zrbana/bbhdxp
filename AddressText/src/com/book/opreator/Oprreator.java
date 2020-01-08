package com.book.opreator;

import com.book.dbutils;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
public class Oprreator {

    public static void main(String[] args) {

    }
    //1.添加新的联系人   OK
    public static void add(Person p){
            //获得连接
            Connection con = dbutils.getConnection();
            PreparedStatement pst = null;
            //sql查询语句
            String sql = "insert into msg(name,address,phoneNumber,familyNumber,postalCode,email) values(?,?,?,?,?,?)";

            //预编译语句
            try {
                //赋值
                pst = con.prepareStatement(sql);
                pst.setString(1, p.getName());
                pst.setString(2, p.getAddress());
                pst.setString(3, p.getPhoneNumber());
                pst.setString(4, p.getFamilyNumber());
                pst.setString(5, p.getPostalCode());
                pst.setString(6, p.getEmail());
                pst.execute();//执行插入操作
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbutils.close(con, pst);

        }


    //2.删除联系人  OK
    public static void delete(String name)  {


        //创建连接
        Connection con = dbutils.getConnection();

        //sql语句
        String sql = "delete from msg where name=?";

        //预编译语句
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1,name);
            pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
       dbutils.close(con,pst);


    }


    //3.保存联系人
    public static void save(){

    }

    //4.按名字排序
    public static void sort() throws SQLException {
        //创建连接
        Connection con = dbutils.getConnection();
        //sql语句
        String sql = "select * from msg order by name";
        //预编译语句
        PreparedStatement pst= con.prepareStatement(sql);

    }

    //5.显示联系人
    public static List<Person> display() throws SQLException {

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet res= null;

        try {
            con = dbutils.getConnection();
            String sql = "desc msg";
            pst = con.prepareStatement(sql);
            res  = pst.executeQuery();
            List<Person> ans = new ArrayList<Person>();
            while(res.next()){
                Person per  = new Person();
                per.setName(per.getName());
                per.setAddress(per.getAddress());
                per.setPhoneNumber(per.getPhoneNumber());
                per.setFamilyNumber(per.getFamilyNumber());
                per.setPostalCode(per.getPostalCode());
                per.setEmail(per.getEmail());
                ans.add(per);
            }

            dbutils.close(con,pst,res);
            return ans;
        }
    }

     public static Person selectPerson(String name)
     {
     // 1. 获取数据源
     Connection con = null;
     //预编译
     PreparedStatement pstmt = null;
     //结果集
     ResultSet rs = null;
     Person per = new Person();
     try {
         //连接
     con = dbutils.getConnection();

      //sql语句
     String sql = "select name,phoneNumber, Email,familyNumber,address,postalCode from Person" +
             " where name = ?";
     pstmt = con.prepareStatement(sql);

     pstmt.setString(1, name);

     rs = pstmt.executeQuery();

     while (rs.next()){
     per.setName(rs.getString("name"));
     per.setPhoneNumber(rs.getString("phoneNumber"));
     per.setEmail(rs.getString("Email"));
     per.setFamilyNumber(rs.getString("familyNumber"));
     per.setAddress(rs.getString("address"));
     per.setPostalCode(rs.getString("postalCode"));
     }

     }catch (SQLException e){
     e.printStackTrace();
     }finally {
     try {
     if (pstmt != null){
     pstmt.close();
     }
     if (con != null){
     con.close();
     }
     } catch (SQLException e){
     e.printStackTrace();
     }
     }

     return per;
     }

    //6.按照名字查询联系人  OK
    public static List<Person> selectName(String name) throws SQLException {

        Connection con = dbutils.getConnection();
        String sql = "select name,address,phoneNumber,familyNumber,postalCode,email from" +
                "msg where name=?";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,name);
        //结果集
        ResultSet res = pst.executeQuery();

        //存放查询的结果
        List<Person>  ans  = new ArrayList<Person>();

        while(res.next()){
            Person per = new Person();
            pst.setString(1,per.getName());
            pst.setString(2,per.getAddress());
            pst.setString(3,per.getPhoneNumber());
            pst.setString(4,per.getFamilyNumber());
            pst.setString(5,per.getPostalCode());
            pst.setString(6,per.getEmail());
            ans.add(per);
        }


        dbutils.close(con,pst,res);
        return ans;

    }

}
*/