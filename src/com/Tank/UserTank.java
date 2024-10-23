package com.Tank;

import java.util.Vector;

public class UserTank extends Tank{  //用户坦克
    private int type=1;

    Vector<Bullet> bullets=new Vector<Bullet>();//可以发射多个子弹保存到集合中

    Bullet bullet=null; //拥有子弹对象

    public UserTank(int x, int y){
        super(x,y);
    }

    public void shot(){ //发射子弹方法

        if(bullets.size()==5){ //同时最多5颗子弹
            return;
        }
        switch(getDirect()){ //根据坦克的方向创建子弹对象
            case 0://向上
                bullet=new Bullet(getX()+10,getY(),0);
                break;
            case 1://向下
                bullet=new Bullet(getX()+10,getY()+40,1);
                break;
            case 2://向左
                bullet=new Bullet(getX(),getY()+10,2);
                break;
            case 3://向右
                bullet=new Bullet(getX()+40,getY()+10,3);
                break;
            default:
                break;
        }
          bullets.add(bullet);
        //启动子弹线程
            Thread thread=new Thread(bullet);
            thread.start();

    }

    public int getType() {
        return type;
    }

}
