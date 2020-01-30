package com.tech.www;


import java.awt.*;
import java.awt.event.KeyEvent;

public class Snake {
    Node head; //蛇头
    Node body; //蛇身
    Node tail;//蛇尾
    Food food; //食物
    //初始化贪吃蛇起始位置以及贪吃蛇的前进方向
    public Snake(Food food){
        //创建蛇头 蛇身 蛇尾节点
        head = new Node(7,13,Config.R);
        body = new Node(7,12,Config.R);
        tail = new Node(7,11,Config.R);
        //绑定蛇头，蛇身，蛇尾之间的关系
        head.next = body;
        head.pre = head;
        head.next = body;
        //初始化食物对象
        this.food = food;

    }

    //绘制蛇
    public void draw(Graphics g){
        //蛇有多个结点，需要取出每个节点，然后把每个节点绘制出来
        for(Node n = head;n!=null;n=n.next){
            //调用节点画图的方法
            n.draw(g);
        }
    }

    //贪吃蛇移动
    public void move(){
        //1.添加蛇头 2.去除蛇尾 3.吃食物 4.死亡检测
        addHead();
        removeTail();
        deadCheck();

    }

    //添加蛇头
    public void addHead(){
        //根据蛇头的方向判断
        Node node = null;
        switch(head.dir){
            case Config.R:
                node = new Node(head.row,head.col+1,head.dir);
                break;
            case Config.L:
                node  = new Node(head.row,head.col-1,head.dir);
                break;
            case Config.U:
                node = new Node(head.row-1,head.col,head.dir);
                break;
            case Config.D:
                node  = new Node(head.row+1,head.col,head.dir);
                break;
            default:
                break;

        }
        //绑定节点与蛇头的关系
        node.next = head;
        head.pre = node;
        head = node;//将新的蛇头节点赋值给原来的蛇头
    }

    //取出蛇尾
    public void removeTail(){
        //1.把蛇尾设为null，蛇尾的上一个节点的下一个指针为null
        tail.pre.next = null;
        //2.把蛇尾的上一个节点赋值给蛇尾
        tail = tail.pre;

    }

    //控制移动方向
    public void keyControl(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_UP:
                if(head.dir.equals(Config.D)){
                    break;
                }
                head.dir = Config.U;
                break;
            case KeyEvent.VK_DOWN:
                if (head.dir.equals(Config.U)) {
                    break;
                }
                head.dir = Config.D;
                break;
            case KeyEvent.VK_LEFT:
                if (head.dir.equals(Config.R)) {
                    break;
                }
                head.dir = Config.L;
                break;
            case KeyEvent.VK_RIGHT:
                if (head.dir.equals(Config.L)) {
                    break;
                }
                head.dir = Config.R;
                break;

        }


    }


    /**
     * 吃食物
     * 1.判断贪食蛇蛇头坐标和食物坐标是否重合
     * 2.重新生成一条新的贪吃蛇（添头不去尾）
     * 3.重新随机生成食物
     */
    public void eat(){
        //判断两个矩阵是否相交(蛇头是否碰到食物）
        Rectangle a = getHeadRec();
        Rectangle b = food.getFoodRec();
        if(a.intersects(b)){
            addHead();//添加蛇头

            food.repair();//随机生成食物
        }
    }

    //获取蛇头坐标
    public Rectangle getHeadRec(){
        //获取蛇头矩形坐标
        return new Rectangle(head.col*Config.SPAN, head.row*Config.SPAN, Config.SPAN, Config.SPAN);

    }

    //检测贪吃蛇是否死亡
    public void deadCheck(){
        // 1.蛇头碰到边界
        // 行的范围:0-Config.ROWS-1
        // 列的范围:0-Config.COLS-1
        if (head.row<0||head.col<0||head.row>Config.ROWS-1||head.col>Config.COLS-1) {
            // 将贪吃蛇的状态改成死亡
            Config.isLive = false;
        }
        // 2.蛇头不能碰到蛇身
        // 遍历蛇身，判断蛇身每一个节点是否和蛇头重合
        for (Node n = head.next; n!=null; n = n.next) {
            // 判断蛇头的位置和当前蛇身节点的位置是否相同
            if (head.row == n.row && head.col == n.col) {
                Config.isLive = false;
                break;
            }
        }
    }

}













