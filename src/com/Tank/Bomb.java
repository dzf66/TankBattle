package com.Tank;

public class Bomb {  //坦克爆炸
    int x,y; //炸弹坐标
    int life=12; //炸弹生命周期
    boolean alive=true; //炸弹是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void lifeDown(){ //通过减少生命值来达到动态效果
        if(life>0){
            life--;
        }else{
            alive=false;
        }
    }
}
