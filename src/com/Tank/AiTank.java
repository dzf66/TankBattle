package com.Tank;

import java.util.Vector;

public class AiTank extends Tank implements Runnable{ //人机坦克实现线程接口
    private int type=0;
    private int direct=1;
    Vector<Bullet>aibullets=new Vector<>(); //多个人机坦克多个子弹

    Vector<AiTank>aiTanks=new Vector<>();//用于存放gemepanle里的aitanks

    public void setAiTanks(Vector<AiTank> aiTanks) {//获取aitanks
        this.aiTanks = aiTanks;
    }

    /**
     * 判断ai坦克是否重叠的方法
     * @return 如果重叠返回true，否则返回false
     */
    public boolean isTouchAitank(){
        //判断当人机坦克方向
        switch(this.getDirect()){
            case 0://上
                //当前坦克和集合中的坦克进行比较
                for(int i=0;i<aiTanks.size();i++){
                    AiTank aiTank=aiTanks.get(i);
                    if(aiTank!=this){
                        //如果人机坦克方向为上下坐标范围 x=[aiTank.getX(),aiTank.getX()+20]
                        //                         y=[aiTank.getY(),aiTank.getY()+40]
                        if(aiTank.getDirect()==0||aiTank.getDirect()==1){
                            //当前人机坦克坐标 左上角[this.getX(),this.getY()]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+20
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+40){
                                return true;
                            }
                            //右上角[this.getX()+20,this.getY()]
                            if(this.getX()+20>= aiTank.getX()
                                    &&this.getX()+20<= aiTank.getX()+20
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+40){
                                return true;
                            }

                        }
                        //如果人机坦克方向为左右 x=[aiTank.getX(),aiTank.getX()+40]
                        //                   y=[aiTank.getY(),aiTank.getY()+20]
                        if(aiTank.getDirect()==2||aiTank.getDirect()==3){
                            //当前人机坦克坐标 左上角[this.getX(),this.getY()]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+40
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+20){
                                return true;
                            }
                            //右上角[this.getX()+20,this.getY()]
                            if(this.getX()+20>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+40
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+20){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 1://下
                //当前坦克和集合中的坦克进行比较
                for(int i=0;i<aiTanks.size();i++){
                    AiTank aiTank=aiTanks.get(i);
                    if(aiTank!=this){
                        //如果人机坦克方向为上下坐标范围 x=[aiTank.getX(),aiTank.getX()+20]
                        //                         y=[aiTank.getY(),aiTank.getY()+40]
                        if(aiTank.getDirect()==0||aiTank.getDirect()==1){
                            //当前人机坦克坐标 左下角[this.getX(),this.getY()+40]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+20
                                    &&this.getY()+40>+aiTank.getY()
                                    &&this.getY()+40<+aiTank.getY()+40){
                                return true;
                            }
                            //右下角[this.getX()+20,this.getY()+40]
                            if(this.getX()+20>= aiTank.getX()
                                    &&this.getX()+20<= aiTank.getX()+20
                                    &&this.getY()+40>+aiTank.getY()
                                    &&this.getY()+40<+aiTank.getY()+40){
                                return true;
                            }

                        }
                        //如果人机坦克方向为左右 x=[aiTank.getX(),aiTank.getX()+40]
                        //                   y=[aiTank.getY(),aiTank.getY()+20]
                        if(aiTank.getDirect()==2||aiTank.getDirect()==3){
                            //当前人机坦克坐标 左下角[this.getX(),this.getY()+40]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+40
                                    &&this.getY()+40>+aiTank.getY()
                                    &&this.getY()+40<+aiTank.getY()+20){
                                return true;
                            }
                            //右下角[this.getX()+20,this.getY()+40]
                            if(this.getX()+20>= aiTank.getX()
                                    &&this.getX()+20<= aiTank.getX()+40
                                    &&this.getY()+40>+aiTank.getY()
                                    &&this.getY()+40<+aiTank.getY()+20){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 2://左
                //当前坦克和集合中的坦克进行比较
                for(int i=0;i<aiTanks.size();i++){
                    AiTank aiTank=aiTanks.get(i);
                    if(aiTank!=this){
                        //如果人机坦克方向为上下坐标范围 x=[aiTank.getX(),aiTank.getX()+20]
                        //                         y=[aiTank.getY(),aiTank.getY()+40]
                        if(aiTank.getDirect()==0||aiTank.getDirect()==1){
                            //当前人机坦克坐标 左上角[this.getX(),this.getY()]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+20
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+40){
                                return true;
                            }
                            //左下角[this.getX(),this.getY()+20]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+20
                                    &&this.getY()+20>+aiTank.getY()
                                    &&this.getY()+20<+aiTank.getY()+40){
                                return true;
                            }

                        }
                        //如果人机坦克方向为左右 x=[aiTank.getX(),aiTank.getX()+40]
                        //                   y=[aiTank.getY(),aiTank.getY()+20]
                        if(aiTank.getDirect()==2||aiTank.getDirect()==3){
                            //当前人机坦克坐标 左上角[this.getX(),this.getY()]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+40
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+20){
                                return true;
                            }
                            //左下角[this.getX(),this.getY()+20]
                            if(this.getX()>= aiTank.getX()
                                    &&this.getX()<= aiTank.getX()+40
                                    &&this.getY()+20>+aiTank.getY()
                                    &&this.getY()+20<+aiTank.getY()+20){
                                return true;
                            }
                        }
                    }
                }
                break;
            case 3://右
                //当前坦克和集合中的坦克进行比较
                for(int i=0;i<aiTanks.size();i++){
                    AiTank aiTank=aiTanks.get(i);
                    if(aiTank!=this){
                        //如果人机坦克方向为上下坐标范围 x=[aiTank.getX(),aiTank.getX()+20]
                        //                         y=[aiTank.getY(),aiTank.getY()+40]
                        if(aiTank.getDirect()==0||aiTank.getDirect()==1){
                            //当前人机坦克坐标 右上角[this.getX()+40,this.getY()]
                            if(this.getX()+40>= aiTank.getX()
                                    &&this.getX()+40<= aiTank.getX()+20
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+40){
                                return true;
                            }
                            //右下角[this.getX()+40,this.getY()+20]
                            if(this.getX()+40>= aiTank.getX()
                                    &&this.getX()+40<= aiTank.getX()+20
                                    &&this.getY()+20>+aiTank.getY()
                                    &&this.getY()+20<+aiTank.getY()+40){
                                return true;
                            }

                        }
                        //如果人机坦克方向为左右 x=[aiTank.getX(),aiTank.getX()+40]
                        //                   y=[aiTank.getY(),aiTank.getY()+20]
                        if(aiTank.getDirect()==2||aiTank.getDirect()==3){
                            //当前人机坦克坐标 右上角[this.getX()+40,this.getY()]
                            if(this.getX()+40>= aiTank.getX()
                                    &&this.getX()+40<= aiTank.getX()+40
                                    &&this.getY()>+aiTank.getY()
                                    &&this.getY()<+aiTank.getY()+20){
                                return true;
                            }
                            //右下角[this.getX()+40,this.getY()+20]
                            if(this.getX()+40>= aiTank.getX()
                                    &&this.getX()+40<= aiTank.getX()+40
                                    &&this.getY()+20>+aiTank.getY()
                                    &&this.getY()+20<+aiTank.getY()+20){
                                return true;
                            }
                        }
                    }
                }
                break;
        }
        return false;
    }




    @Override
    public void setDirect(int direct) {
        this.direct = direct;
    }
    public int getDirect() {
        return direct;
    }

    public AiTank(int x, int y){
        super(x,y);


    }


    public int getType() {
        return type;
    }

    @Override
    public void run() {  //自由移动
        while(true){
            if(alive&&aibullets.size()<1){
                Bullet aibt=null;
                //根据方向再发射子弹
                switch(getDirect()){
                    case 0:  //向上
                      aibt =new Bullet(getX()+10,getY(),0);
                      break;
                    case 1:  //向下
                        aibt=new Bullet(getX()+10,getY()+40,1);
                        break;
                    case 2:  //向左
                        aibt=new Bullet(getX(),getY()+10,2);
                        break;
                    case 3:  //向右
                        aibt=new Bullet(getX()+40,getY()+10,3);
                        break;
                }
                aibullets.add(aibt);
                new Thread(aibt).start();  //启动线程
            }
            //自由移动
            switch(getDirect()){
                case 0:       //向上移动
                    for(int i=0;i<30;i++){  //人机坦克移动30后改变方向
                        if(getY()>0&&!isTouchAitank()) {
                            moveUP();
                        }
                        try {      //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 1:     //向下移动
                    for(int i=0;i<30;i++){  //人机坦克移动30后改变方向
                        if(getY()+60<750&&!isTouchAitank()){
                            moveDown();
                        }
                        try {      //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;

                case 2:     //向左移动
                    for(int i=0;i<30;i++){  //人机坦克移动30后改变方向
                        if(getX()>0&&!isTouchAitank()){
                           moveLeft();
                        }
                        try {      //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
                case 3:     //向右移动
                    for(int i=0;i<30;i++){  //人机坦克移动30后改变方向
                        if(getX()+40<1000&&!isTouchAitank()){
                           moveRight();
                        }
                        try {      //休眠50毫秒
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    break;
            }
            //随机生成0-3的整数以改变方向
            setDirect((int)(Math.random()*4));
            if(!alive){
                break;  //退出线程
            }
        }
    }
}
