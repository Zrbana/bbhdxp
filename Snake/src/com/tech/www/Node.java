package com.tech.www;

import java.awt.*;

/**
 * 贪吃蛇分割的节点
 */
public class Node {
    int row;//行
    int col;//列
    Node next;//上一节点指针
    Node pre;//下一节点指针
    String dir; //蛇前进的方向

    public Node(int row,int col,String dir){
        this.row = row;
        this.col = col;
        this.dir  = dir;
    }

    //绘制节点
    public void draw(Graphics g){
        //如果当前节点的上一个节点为null，则当前节点就是蛇头
        if(this.pre == null){
            //绘制蛇头的颜色为黄色
            g.setColor(Color.YELLOW);
        }else{
            g.setColor(Color.BLUE);
        }
        g.fillOval(col*Config.SPAN,row*Config.SPAN,Config.SPAN,Config.SPAN);

    }
}











