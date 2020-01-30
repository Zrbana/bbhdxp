package com.tech.www;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JPanel implements ActionListener {
    MyPanel myPanel;
    JButton pause; //暂停游戏
    JButton continu;//继续游戏
    JButton restart; //重新开始
    JButton exit; // 退出游戏

    public Button(MyPanel myPanel){
        this.myPanel = myPanel;
        this.setBounds(0,440,706,60);
        pause  = new JButton("暂停游戏");
        continu  = new JButton("继续游戏");
        restart = new JButton("重新游戏");
        exit = new JButton("退出游戏");
        this.add(pause);
        this.add(continu);
        this.add(restart);
        this.add(exit);

        pause.addActionListener(this);
        continu.addActionListener(this);
        restart.addActionListener(this);
        exit.addActionListener(this);
    }

    /**
     * 获取事件作用的对象
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //监听对象是暂停游戏
        if(e.getSource() == pause){
            Config.isPause = false;
        }

        //监听对象是继续游戏
        if(e.getSource() == continu){
            Config.isPause = true;
            //设置键盘监听焦点
            myPanel.setFocusable(true);
            myPanel.requestFocus();
        }
        // 监听对象是重新开始游戏
        if (e.getSource() == restart) {
            // 1.停掉当前线程
            myPanel.snakeThread.stopThread();
            // 2.重新生成蛇和食物
            Food food = new Food();
            myPanel.food = food;
            myPanel.snake = new Snake(food);
            // 将控制条件还原到初始状态
            Config.isPause = true;
            Config.isLive = true;
            // 3.创建新的线程对象(内部类对象)
            MyPanel.SnakeThread snakeThread = myPanel.new SnakeThread();
            // 4.启动线程
            snakeThread.start();
            myPanel.snakeThread = snakeThread;
            // 获取键盘焦点
            myPanel.setFocusable(true);
            myPanel.requestFocus();
        }
        //监听对象退出游戏
        if(e.getSource() == exit){
            System.exit(0);
        }
    }
}










