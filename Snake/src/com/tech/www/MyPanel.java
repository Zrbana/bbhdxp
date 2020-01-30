package com.tech.www;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyPanel extends JPanel implements KeyListener{

    // 创建食物对象
    Food food = new Food();
    // 创建一个贪吃蛇对象
    Snake snake = new Snake(food);
    // 创建线程对象
    SnakeThread snakeThread = new SnakeThread();

    public MyPanel() {
        // 设置容器坐标及大小
        this.setBounds(0, 0, 700, 440);
        // 设置容器背景色
        this.setBackground(Color.PINK);
        // 启动线程
        snakeThread.start();
        // 注册键盘监听器
        this.addKeyListener((KeyListener) this);
    }

    // 绘制容器
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 设置绘制的颜色
        g.setColor(Color.GRAY);
        // 绘制横线
        for (int i = 0; i < Config.ROWS; i++) {
            // 使用当前颜色在点 (x1, y1) 和 (x2, y2) 之间画一条线
            g.drawLine(0, Config.SPAN * i, Config.COLS * Config.SPAN, Config.SPAN * i);
        }
        // 绘制竖线
        for (int i = 0; i < Config.COLS; i++) {
            g.drawLine(Config.SPAN * i, 0 , Config.SPAN * i , Config.ROWS * Config.SPAN);
        }
        // 贪吃蛇移动
        snake.move();
        // 画食物
        food.draw(g);
        // 画蛇
        snake.draw(g);
        // 吃食物
        snake.eat();
    }
    // 贪吃蛇的线程
    class SnakeThread extends Thread{
        boolean flag = true;// 重新开始
        @Override
        public void run() {
            // Config.isLive:判断贪吃蛇是否存活
            while (Config.isLive && flag) {
                try {
                    // 当贪吃蛇没有死亡的时候，则继续移动
                    Thread.sleep(300);// 当前线程休眠0.3秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // Config.isPause== true:代表继续游戏
                // Config.isPause== false:代表暂停游戏
                if (Config.isLive && Config.isPause) {
                    // 重新绘制图形,具有页面刷新的效果
                    // 重绘的执行流程 repaint()-->调用awt线程-->update()方法-->paint()
                    repaint();
                }
                if (!Config.isLive) {
                    // 弹出一个结束游戏的对话框
                    JOptionPane.showMessageDialog(MyPanel.this, "游戏结束");
                }
            }
        }
        // 停止线程的方法
        public void stopThread() {
            flag = false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e) {
        // 调用贪吃蛇的控制方向方法
        snake.keyControl(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

}