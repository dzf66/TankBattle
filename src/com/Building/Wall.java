package com.Building;

import com.Tank.GamePanel;

import java.awt.*;

public class Wall {
  static   private GamePanel mypanel;
    private int x;  //障碍物的x坐标
    private int y;  //障碍物的y坐标

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    static Image imageWall=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("/wall.png"));

    public  Wall(GamePanel myPanel){
        this.mypanel=myPanel;
    }
    public static void wallCreate(Graphics g, int startX, int startY, int brickWidth, int brickHeight, int rows, int cols){
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                int x = startX + j * brickWidth;
                int y = startY + i * brickHeight;
                g.drawImage(imageWall, x, y, brickWidth, brickHeight,mypanel);
            }
        }
    }



}
