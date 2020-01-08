package com.book;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
public class Menu extends JFrame {



    TextField text1=new TextField(50);
    TextField text2=new TextField(50);
    TextField text3=new TextField(50);
    TextField text4=new TextField(50);
    TextField text5=new TextField(50);
    TextField text6=new TextField(50);
    TextField t1=new TextField(50);
    TextField t2=new TextField(50);
    TextField t3=new TextField(50);
    TextField t4=new TextField(50);
    TextField t5=new TextField(50);
    TextField t6=new TextField(50);
    TextField ta1=new TextField(5);
    TextField ta2=new TextField(5);
    TextField ta3=new TextField(5);

    TextArea txt1 =new TextArea(50,50);

    JButton b1=new JButton("添加");
    JButton b2=new JButton("保存");
    JButton b3=new JButton("修改");
    JButton b4=new JButton("删除");
    JButton b5=new JButton("查询");




    Label l1=new Label(" 输入姓名   :");
    Label l2=new Label(" 输入年龄   :");
    Label l3=new Label(" 输入性别   :");
    Label l4=new Label(" 输入电话   :");
    Label l5=new Label(" 输入地址   :");
    Label l6=new Label(" 输入其他   :");

    Label a1=new Label(" 输入姓名   :");
    Label a2=new Label(" 输入年龄   :");
    Label a3=new Label(" 输入性别   :");
    Label a4=new Label(" 输入电话   :");
    Label a5=new Label(" 输入地址   :");
    Label a6=new Label(" 输入其他   :");
    Label a7=new Label("(输入姓名即可删除)");

    Label la1=new Label("姓名:");
    Label la2=new Label("年龄:");
    Label la3=new Label("性别:");
    Label la4=new Label("    ");
    Label la8=new Label("    ");
    Label la9=new Label("    ");
    Label la11=new Label("    ");
    Label la12=new Label("    ");
    Label la5=new Label("");
    Label la6=new Label("");
    Label la7=new Label("");







    JMenuBar bar;
    JMenu file,sear,dele,order;
    JMenuItem name,sex,age,show,clear,sall,dall,oage,oname;



    JPanel ff=new JPanel();
    JPanel f1=new JPanel();
    JPanel f2=new JPanel();
    JPanel f3=new JPanel();
    JPanel f4=new JPanel();
    JPanel f5=new JPanel();


    JTabbedPane Tpan=new JTabbedPane();//定义分页面板对象



    public Menu()           //构造方法实现图形化界面
    {
        super("通讯录");//用jframe设置title

        ff=(JPanel)this.getContentPane();//ff对象获取框架


        text1.setBounds(50, 50, 130, 20);
        text2.setBounds(50, 70, 130, 20);

        f1.setVisible(true);
        f1.setBounds(0, 0, 300, 200);
        f1.setLayout(new FlowLayout());//设置页面的布局

        f1.add(l1);
        f1.add(text1);
        f1.add(l2);
        f1.add(text2);
        f1.add(l3);
        f1.add(text3);
        f1.add(l4);
        f1.add(text4);
        f1.add(l5);
        f1.add(text5);
        f1.add(l6);
        f1.add(text6);
        f1.add(b1);
        f1.add(b2);


        f2.setLayout(new BorderLayout(10,50)); //设计f2的布局

        bar=new JMenuBar();
        sear=new JMenu("查找");
        file=new JMenu("文件");
        order=new JMenu("排序");
        dele=new JMenu("删除");


        name =new JMenuItem("姓名");
        sex  =new JMenuItem("性别");
        age  =new JMenuItem("年龄");
        show =new JMenuItem("显示");
        clear=new JMenuItem("清空");
        sall =new JMenuItem("查找全部");
        dall =new JMenuItem("删除全部");
        oage =new JMenuItem("年龄排序");
        oname=new JMenuItem("姓名排序");


        bar.add(file);
        bar.add(order);
        bar.add(sear);
        bar.add(dele);

        sear.add(sall);

        order.add(oage);
        order.add(oname);



        dele.add(dall);



        file.add(show);
        file.add(clear);

        setJMenuBar(bar);//现实或隐藏此组件
        setVisible(true);

        //设置文本框




        f2.add(txt1,BorderLayout.CENTER);
        f2.add(bar ,BorderLayout.NORTH);
        f2.add(f4  ,BorderLayout.WEST);
        f2.add(la5 ,BorderLayout.EAST);
        f2.add(la6 ,BorderLayout.SOUTH);

        //****************************************************************************

        b1.addActionListener(new clean());
        b2.addActionListener(new sav());
        b3.addActionListener(new alter());
        b4.addActionListener(new delec());

        b5.addActionListener(new search());                                                               //添加相应的监听者
        show.addActionListener(new shower());
        sall.addActionListener(new shower());
        dall.addActionListener(new dall());
        clear.addActionListener(new clean());
        oname.addActionListener(new order());
        oage.addActionListener(new order());


        //*************************************************************************************


        ff.add(Tpan);//把两个容器放到分页面板tpan中然后放入同一个容器ff中
        Tpan.add(f1,0);
        Tpan.add(f2,1);
        Tpan.add(f3,2);


        Tpan.setTitleAt(0, "输入信息");
        Tpan.setTitleAt(1, "查看信息");
        Tpan.setTitleAt(2, "修改信息");

        Tpan.setSelectedIndex(0); //设置初始页
        //设置第三个面板***********************************************************************************

        f1.setLayout(new FlowLayout());
        f3.add(a1); f3.add(t1);
        f3.add(a2); f3.add(t2);
        f3.add(a3); f3.add(t3);
        f3.add(a4); f3.add(t4);
        f3.add(a5); f3.add(t5);
        f3.add(a6); f3.add(t6);
        f3.add(b3); f3.add(b4);
        f3.add(a7);
        //****************设置第二个中的West面板************************************************


        f4.setLayout(new GridLayout(4,5));
        f4.add(la1);f4.add(ta1);
        f4.add(la2);f4.add(ta2);
        f4.add(la3);f4.add(ta3);
        f4.add(la4);f4.add(b5);
        f4.add(la7);
        f4.add(la8);f4.add(la9);
        f4.add(la11);f4.add(la12);
        txt1.setSize(50, 50);




        /////////***************************************************************************
        setSize(500,400);
        show();

    }
    class clean implements ActionListener{             //实现“清除”功能
        public void actionPerformed(ActionEvent e){
            Object source=e.getSource();
            if(source==b1)
                text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            text6.setText("");
            txt1 .setText("");
        }
    }
    class dall implements ActionListener{              //类dall实现删除全部数据
        public void actionPerformed(ActionEvent e)
        {


            String driver="com.mysql.jdbc.Driver";
            //jdbc协议：数据库子协议：主机：端口/连接的数据库
            String url="jdbc:mysql://localhost:3306/book";
            String use="root";
            String password="zn19980121..";
            try{
                // 通过得到字节码对象的方式加载静态代码块，从而注册驱动程序
                //1.加载驱动程序
                Class.forName(driver);
                //2.建立连接
                Connection con=DriverManager.getConnection(url,use,password);
                //3.创建执行sql语句的statement
                Statement  stmt=con.createStatement();
                //4.创建sql语句
                String sql="delete from msg";
                stmt.executeUpdate(sql);




            }
            catch(Exception ce)
            {
                ce.printStackTrace();
            }

        }

    }


    class shower implements ActionListener{           //类shower用来实现将数据从文件读如到文本区域中
        public void actionPerformed(ActionEvent e)
        {

            Object source=e.getSource();

            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/book";
            String use="root";
            String password="zn19980121..";
            if(source==show | source==sall)
            {
                try
                {
                    Class.forName(driver);
                    Connection con=DriverManager.getConnection(url,use,password);
                    Statement  stmt=con.createStatement();
                    String sql="select * from msg ";
                    ResultSet rs=stmt.executeQuery(sql);
                    txt1 .setText("");
                    while(rs.next())
                    {

                        txt1.insertText("其他： "+rs.getObject(6)+"\n\n\n",0);
                        txt1.insertText("地址： "+rs.getString(5)+"\n",0);
                        txt1.insertText("电话： "+rs.getString(4)+"\n",0);
                        txt1.insertText("性别： "+rs.getString(3)+"\n",0);
                        txt1.insertText("年龄： "+rs.getString(2)+"\n",0);
                        txt1.insertText("姓名： "+rs.getString(1)+"\n",0);

                    }
                    rs.close();
                    stmt.close();
                }
                catch(Exception ce)
                {
                    ce.printStackTrace();
                }
            }
        }}
    class order implements ActionListener{           //order 用来实现排序功能
        public void actionPerformed(ActionEvent e)
        {

            Object source=e.getSource();

            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/book";
            String use="root";
            String password="zn19980121..";
            if(source==oname)
            {
                try
                {
                    Class.forName(driver);
                    Connection con=DriverManager.getConnection(url,use,password);
                    Statement  stmt=con.createStatement();
                    String sql="select * from msg order by name";
                    ResultSet rs=stmt.executeQuery(sql);
                    txt1 .setText("");
                    while(rs.next())
                    {

                        txt1.insertText("其他： "+rs.getObject(6)+"\n\n\n",0);
                        txt1.insertText("地址： "+rs.getString(5)+"\n",0);
                        txt1.insertText("电话： "+rs.getString(4)+"\n",0);
                        txt1.insertText("性别： "+rs.getString(3)+"\n",0);
                        txt1.insertText("年龄： "+rs.getString(2)+"\n",0);
                        txt1.insertText("姓名： "+rs.getString(1)+"\n",0);

                    }

                    rs.close();
                    stmt.close();
                }

                catch(Exception ce)
                {
                    ce.printStackTrace();
                }
            }


            if(source==oage)
            {
                try
                {
                    Class.forName(driver);
                    Connection con=DriverManager.getConnection(url,use,password);
                    Statement  stmt=con.createStatement();
                    String sql="select * from msg order by phonenumber desc";
                    ResultSet rs=stmt.executeQuery(sql);
                    txt1 .setText("");
                    while(rs.next())
                    {

                        txt1.insertText("其他： "+rs.getObject(6)+"\n\n\n",0);
                        txt1.insertText("地址： "+rs.getString(5)+"\n",0);
                        txt1.insertText("电话： "+rs.getString(4)+"\n",0);
                        txt1.insertText("性别： "+rs.getString(3)+"\n",0);
                        txt1.insertText("年龄： "+rs.getString(2)+"\n",0);
                        txt1.insertText("姓名： "+rs.getString(1)+"\n",0);

                    }

                    rs.close();
                    stmt.close();
                }


                catch(Exception ce)
                {
                    ce.printStackTrace();
                }
            }

        }}

    class sav implements ActionListener{         //类sav用来实现将数据读入到数据库中
        public void actionPerformed(ActionEvent e)
        {



            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/book";
            String use="root";
            String password="zn19980121..";

            try
            {
                Class.forName(driver);
                Connection con=DriverManager.getConnection(url,use,password);
                Statement  stmt=con.createStatement();
                String sql="insert into msg values('"+text1.getText()+"','"+text2.getText()+"','"+text3.getText()+"','"+text4.getText()+"','"+text5.getText()+"','"+text6.getText()+"')";

                if (text1.getText().length() == 0|text2.getText().length() ==0|text3.getText().length() == 0|text4.getText().length() == 0|text5.getText().length() == 0|text6.getText().length() == 0)
                {
                    String t="错误";
                    String d="请输入整信息后保存";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;           //错误的处理
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                    text1.setText("");
                    text2.setText("");
                    text3.setText("");
                    text4.setText("");
                    text5.setText("");
                    text6.setText("");
                }


                else if(text3.getText().equals("男")||text3.getText().equals("女")){
                    stmt.executeUpdate(sql);
                    String t="成功";
                    String d="保存成功";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                    text1.setText("");
                    text2.setText("");
                    text3.setText("");
                    text4.setText("");
                    text5.setText("");
                    text6.setText("");
                }
                else {
                    String t="错误";
                    String d="请重新输入性别";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;           //错误的处理
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                    text3.setText("");
                }
            }
            catch(SQLException ex)                                    // 捕捉异常
            {
                String t="错误";
                String d="年龄、电话应为数字";
                int dtype=JOptionPane.PLAIN_MESSAGE;
                dtype=JOptionPane.WARNING_MESSAGE;           //错误的处理
                JOptionPane.showMessageDialog(null,d,t,dtype);
                while (ex != null)
                {

                    ex = ex.getNextException();
                }
            }
            catch(Exception ce)
            {
                ce.printStackTrace();
            }
        }
    }

    class alter implements ActionListener{           //修改按钮


        public void actionPerformed(ActionEvent e)                    // 处理修改按钮的ActionEvent
        {

            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/day2";
            String use="root";
            String password="root";


            try
            {
                try {
                    Class.forName(driver);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                Connection con=DriverManager.getConnection(url,use,password);
                Statement  stmt=con.createStatement();

                if (t1.getText().length() == 0)
                {
                    String t="错误";
                    String d="姓名为必填项目";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                }
                else {
                    if (t2.getText().length() != 0)
                        stmt.executeUpdate("update ziliao set sage='" +
                                t2.getText() + "' where sname='" +
                                t1.getText() + "'"); // 更新表中姓名相关的年龄记录
                    if (t3.getText().length() != 0)
                        stmt.executeUpdate("update ziliao set sex='" +
                                t3.getText() + "' where sname='" +
                                t1.getText() + "'"); // 更新表中姓名相关的性别记录
                    if (t4.getText().length() != 0)
                        stmt.executeUpdate("update ziliao set telephone='" +
                                t4.getText() + "' where name='" +
                                t1.getText() + "'"); // 更新表中与姓名相关的电话记录
                    if (t5.getText().length() != 0)
                        stmt.executeUpdate("update ziliao set address='" +
                                t5.getText() + "' where sname='" +
                                t1.getText() + "'"); // 更新表中与姓名相关的地址的记录
                    if (t6.getText().length() != 0)
                        stmt.executeUpdate("update ziliao set other='" +
                                t6.getText() + "' where sname='" +
                                t1.getText() + "'"); // 更新表中与姓名相关的其他的记录
                }
                if (t2.getText().length() == 0 &t3.getText().length() == 0 &t4.getText().length() == 0&t5.getText().length() == 0&t6.getText().length() == 0)
                {
                    String t="错误";
                    String d="修改不成功请重新输入";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                }
                else {
                    String t="成功";
                    String d="修改成功";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                }
            }
            catch(SQLException ex)                                    // 捕捉异常
            {
                String t="错误";
                String d="修改类型错误电话年龄为数字";
                int dtype=JOptionPane.PLAIN_MESSAGE;
                dtype=JOptionPane.WARNING_MESSAGE;
                JOptionPane.showMessageDialog(null,d,t,dtype);
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
            }


        }
    }


    class delec implements ActionListener
    {


        public void actionPerformed(ActionEvent e)                    // 处理修改按钮的ActionEvent
        {

            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/day2";
            String use="root";
            String password="root";
            try
            {
                Class.forName(driver);           // 实例化JDBC-ODBC桥的驱动
                Connection con=DriverManager.getConnection(url,use,password);  // 连接数据库
                String sql="select sname from ziliao";
                Statement  stmt=con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                if (rs.next()==false)                        // 判断数据库中是否有要删除的记录，如没有则显示提示框
                {
                    t1.setText("");
                    String t="提示";
                    String d="没有您要删除的记录";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                }
                else
                {
                    String sql2="delete from ziliao where sname='"+t1.getText()+"'";
                    stmt.executeUpdate(sql2);             // 删除表中对应姓名的数据记录
                    // 清空信息框
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    String t="提示";
                    String d="删除记录成功";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                }
            }
            catch(SQLException ex)                      // 捕捉异常
            {

                while (ex != null)
                {
                    ex = ex.getNextException();
                }
            }
            catch(Exception ex )
            {
                ex.printStackTrace();
            }


        }
    }
    class search implements ActionListener
    {


        public void actionPerformed(ActionEvent e)                    // 处理查询按钮的ActionEvent
        {

            String driver="com.mysql.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/day2";
            String use="root";
            String password="root";
            try
            {
                Class.forName(driver);           // 实例化JDBC-ODBC桥的驱动
                Connection con=DriverManager.getConnection(url,use,password);  // 连接数据库
                String sql = null;
                Statement  stmt=con.createStatement();


                if (ta1.getText().length() == 0&ta2.getText().length() == 0&ta3.getText().length() == 0)
                {
                    String t="错误";
                    String d="您没有输入要查询的项目";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                }
                else {
                    if (ta1.getText().length() != 0)
                        sql="select * from ziliao where sname='" +
                                ta1.getText() + "'"; // 查询表中相关姓名的记录
                    if (ta2.getText().length() != 0)
                        sql="select * from ziliao where sage='" +
                                ta2.getText() + "'"; // 查询表中相关年龄的记录
                    if (ta3.getText().length() != 0)
                        sql="select * from ziliao where sex='" +
                                ta3.getText() + "'"; // 查询表中相关性别的记录
                }
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next())
                {
                    txt1 .setText("");
                    txt1.insertText("其他： "+rs.getObject(6)+"\n\n\n",0);
                    txt1.insertText("地址： "+rs.getString(5)+"\n",0);
                    txt1.insertText("电话： "+rs.getString(4)+"\n",0);
                    txt1.insertText("性别： "+rs.getString(3)+"\n",0);
                    txt1.insertText("年龄： "+rs.getString(2)+"\n",0);
                    txt1.insertText("姓名： "+rs.getString(1)+"\n",0);

                }
                rs.close();
                stmt.close();
                if (txt1.getText().length() == 0)
                {
                    String t="错误";
                    String d="表中没有你要查询的记录";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);
                    ta1.setText("");
                    ta2.setText("");
                    ta3.setText("");

                }
                else {
                    String t="成功";
                    String d="查找成功";
                    int dtype=JOptionPane.PLAIN_MESSAGE;
                    dtype=JOptionPane.WARNING_MESSAGE;
                    JOptionPane.showMessageDialog(null,d,t,dtype);

                    ta1.setText("");
                    ta2.setText("");
                    ta3.setText("");

                }
            }
            catch(SQLException ex)                      // 捕捉异常
            {

                while (ex != null)
                {
                    ex = ex.getNextException();
                }
            }
            catch(Exception ex )
            {
                ex.printStackTrace();
            }


        }
    }

    public static void main(String args[])
    {
        Menu app=new Menu();
        app.addWindowListener
                (
                        new WindowAdapter()
                        {

                            public void windowClosing(WindowEvent e){System.exit(0);}
                        }
                );

    }
}

