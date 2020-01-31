package com.plane.bullet;

import com.plane.frame.Constant;
import com.plane.frame.Tank;

import javax.swing.*;
import java.awt.*;

/**
 * 炮弹类：坐标，速度，方向，伤害，大小，颜色，炮弹的敌我
 */
public class Bullet {
    private int x,y;
    private int speed;
    private int dir;

    private int atk;
    private int diameter = 4;
    private boolean isFriendly;//敌我属性
    private Color color;
    //子弹是否可见
    private boolean visible = true;


    public Bullet(int x, int y, int dir, Tank atk, boolean isFriendly, Color color){
        super();
        this.y = y;
        this.speed = speed;
        this.dir  = dir;
        this.diameter = diameter;
        this.isFriendly = isFriendly;
        this.color = color;
    }

    public void draw(Graphics g) {
        if (!visible) return;
        g.setColor(color);
        int w = diameter >> 1;
        g.fillArc(x - w, y - w, diameter, diameter, 0, 360);
        //子弹的飞行轨迹
        logic();
    }

    public void logic(){
        switch (dir) {
            case Tank.DIR_UP:
                y -= speed;
                if(y < 0)visible = false;
                break;
            case Tank.DIR_DOWN:
                y += speed;
                if(y > Constant.FRAME_HEIGHT)visible = false;
                break;
            case Tank.DIR_LEFT:
                x -= speed;
                if (x < 0)visible = false;
                break;
            case Tank.DIR_RIGHT:
                x += speed;
                if(x > Constant.FRAME_WIDTH)visible = false;
                break;
        }
    }

    public boolean isVisible(){
        return visible;
    }
    public void setVisible(boolean visible){
        this.visible = visible;
    }


}















