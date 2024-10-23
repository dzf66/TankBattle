package com.Tank;

public class Tank {  //坦克父类
    private int x; //坦克的横坐标
    private int y; //坦克的纵坐标
    private int direct; //坦克的方向 0-上，1-下，2-左，3-右
    private int speed=1; //坦克的速度
    boolean alive=true;

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    //控制坦克移动的方法
    public void moveUP(){
        if(getY()>0){
            y-=speed;
        }

    }
    public void moveDown(){
        if(getY()+40<750){
          y+=speed;
        }
    }
    public void moveRight(){
        if(getX()+40<1000){
           x+=speed;
        }
    }
    public void moveLeft(){
        if(getX()>0){
          x-=speed;
        }
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

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


}
