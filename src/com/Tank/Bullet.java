package com.Tank;

public class Bullet implements Runnable{  //发射子弹一个线程
    private int x; //子弹的x坐标
    private int y; //子弹的y坐标
    private int direct=0; //默认子弹方向为上
    private int speed=8; //默认子弹速度为8
    private boolean isLive=true; //子弹是否还存在

     private boolean isPaused=false; //是否处于暂停
    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {  //子弹的运动
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!isPaused) {       //线程是否进入等待状态
                switch (direct) {
                    case 0: //向上
                        y -= speed;
                        break;
                    case 1: //向下
                        y += speed;
                        break;
                    case 2: //向左
                        x -= speed;
                        break;
                    case 3: //向右
                        x += speed;
                        break;
                }
                //判断子弹是否穿过边界结束线程
                if (!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive)) {
                   // System.out.println("子弹线程退出");
                    isLive = false;
                    break;
                }
            }
        }

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

    public boolean isLive() {
        return isLive;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


    public void setLive(boolean live) {
        isLive = live;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }
}
