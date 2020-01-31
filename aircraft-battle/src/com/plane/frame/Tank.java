package com.plane.frame;

import com.plane.bullet.Bullet;

import java.awt.*;

public class Tank {
    //四个方向
    public static final int DIR_UP = 0;
    public static final int DIR_DOWN = 1;
    public static final int DIR_LEFT = 2;
    public static final int DIR_RIGHT = 3;

    //状态
    public static final int STATE_STAND = 0;
    public static final int STATE_MOVE = 1;
    public static final int STATE_DIE = 2;
    public static final int STATE_FIRE = 3;
    private int x, y;
    private int width;
    private int dir;
    private int speed;
    private int state;
    private Color color = Color.ORANGE;

    public Tank(int x, int y, int dir) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    /**
     * the drawing method of tank
     *
     * @param g
     */
    public void draw(Graphics g) {
        //sets the color of the brush to the specified color
        g.setColor(color);
        g.fillRect(x, y, width, width);

        //draw a black border
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, width);

        //draw a gun barrel(the half of tank's width)
        int w = width >> 1;
        switch (dir) {
            case DIR_UP:
                g.drawLine(x + w, y - w, x + w, y + w);
                break;
            case DIR_DOWN:
                g.drawLine(x + w, y + w, x + w, y + 3 * w);
                break;
            case DIR_LEFT:
                g.drawLine(x - w, y + w, x + w, y + w);
                break;
            case DIR_RIGHT:
                g.drawLine(x + 3 * w, y + w, x + w, y + w);
                break;
        }


    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //坦克发射炮弹功能
    public Bullet fire() {
        Tank atk = null;
        int w = width >> 1;
        int bulletX = 0;
        int bulletY = 0;
        //根据坦克（根据方向）的坐标来计算炮弹的坐标
        switch (dir) {
            case DIR_UP:
                bulletX = x + w;
                bulletY = y - w;
                break;
            case DIR_DOWN:
                bulletX = x + w;
                bulletY = y + 3 * w;
                break;
            case DIR_LEFT:
                bulletX = x - w;
                bulletY = y + w;
                break;
            case DIR_RIGHT:
                bulletX = x + 3 * w;
                bulletY = y + w;
                break;
        }
        return new Bullet(bulletX, bulletY, dir, atk, true, color);

    }
}















