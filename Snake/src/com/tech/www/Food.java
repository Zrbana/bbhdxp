package com.tech.www;

import java.awt.*;
import java.util.Random;

public class Food {
    private int row;//所在行
    private int col;//所在列
    public Food(){
        repair();
    }

    //绘制食物
    public void draw(Graphics g){
        //设置画笔颜色
        g.setColor(Color.RED);
        //填充矩形
        g.fillRect(col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN);
    }

    //随机生成食物的位置
    public void repair(){
        row = new Random().nextInt(Config.ROWS);
        col = new Random().nextInt(Config.COLS);

    }

    public Rectangle getFoodRec(){
        return new Rectangle(col*Config.SPAN, row*Config.SPAN, Config.SPAN, Config.SPAN);
    }
}













