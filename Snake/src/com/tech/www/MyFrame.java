package com.tech.www;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel myPanel = new MyPanel();
    Button button = new Button(myPanel);

    public MyFrame(){
        //设置窗体标题
        this.setTitle("贪吃蛇v1.0");
        //设置窗体初始位置及大小
        this.setBounds(300,50,706,500);
        //设置当关闭窗口的时候，保证JVM退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置布局管理器为null，清空布局
        this.setLayout(null);
        //设置此窗体是否可由用户调整大小
        this.setResizable(false);
        //添加控件
        this.add(myPanel);
        //设置键盘监听焦点
        //设置是否允许获取焦点
        myPanel.setFocusable(true);
        //获取焦点
        myPanel.requestFocus();
        //添加按钮
        this.add(button);
        //显示
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new MyFrame();
    }
}
