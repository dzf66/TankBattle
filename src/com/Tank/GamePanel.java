package com.Tank;

import com.Building.Grass;
import com.Building.Wall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;



//坦克大战绘图区域
public class GamePanel extends JPanel implements MouseListener,KeyListener,Runnable  {
    private JFrame frame;

    boolean isWin=false;  //是否暂停
    int x=750,y=450; //初始化用户坦克位置

    UserTank ut=null;

    Vector<Bomb> bombs =new Vector<>(); //用于存放炸弹的集合(当子弹击中坦克时添加一个bomb对象)
    Vector<AiTank> aiTanks=new Vector<>(); //将人机坦克保存到Vector集合中，可以动态改变大小
    Vector<Node> nodes=new Vector<>();//存放Node对象的集合
    //定义三张爆炸图片
    Image image1=null;
    Image image2=null;
    Image image3=null;

    int aitanksize=4;

    public GamePanel(JFrame jFrame,String key){   //画板构造器
        addMouseListener(this);
        nodes=Recorder.getNodes();
        if(nodes==null){
            key="1";
            System.out.println("还没有游戏记录，请开始新游戏");
        }else{
            key="2";
            System.out.println("继续上局游戏");
        }
        Recorder.setAiTanks(aiTanks);
        this.frame=jFrame;
        ut=new UserTank(x,y);  //初始化用户的坦克
        ut.setSpeed(5);

        switch(key){
            case "1": //新游戏
                for(int i=0;i<aitanksize;i++){    //初始化人机坦克
                    AiTank aiTank=new AiTank(100*(i+1),0);
                    aiTank.setDirect(((int)(Math.random()*4)));
                    //将aiTanks 设置给aiTank
                    aiTank.setAiTanks(aiTanks);
                    Thread ait=new Thread(aiTank);
                    ait.start(); //启动人机坦克线程
                    Bullet aibullet=new Bullet(aiTank.getX()+10,aiTank.getY()+40,aiTank.getDirect());
                    aiTank.aibullets.add(aibullet);
                    Thread t=new Thread(aibullet);
                    t.start();
                    aiTanks.add(aiTank);
                }
                break;
            case "2": //继续上局游戏
                for(int i=0;i<nodes.size();i++){    //初始化人机坦克
                    Node node=nodes.get(i);
                    AiTank aiTank=new AiTank(node.getX(),node.getY());
                    aiTank.setDirect(node.getDirect());
                    //将aiTanks 设置给aiTank
                    aiTank.setAiTanks(aiTanks);
                    Thread ait=new Thread(aiTank);
                    ait.start(); //启动人机坦克线程
                    Bullet aibullet=new Bullet(aiTank.getX()+10,aiTank.getY()+40,aiTank.getDirect());
                    aiTank.aibullets.add(aibullet);
                    Thread t=new Thread(aibullet);
                    t.start();
                    aiTanks.add(aiTank);
                }
                break;
            default:
                System.out.println("Warning");
        }



        //初始化图片
        image1=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("/bomb_1.png"));
        image2=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("/bomb_2.png"));
        image3=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("/bomb_3.png"));



    }

    /**
     * 显示用户击中坦克数量的方法
     * @param g 画笔
     */
    public void showInfo(Graphics g){
        g.setColor(Color.BLACK);
        Font font=new Font("宋体",Font.BOLD,16);
        g.setFont(font);
        g.drawString("您已经击毁敌方坦克数量",1005,60);
        drawTank(1020,90,g,0,0);//画一个人机坦克
        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(Recorder.getDesAiTank()),1060,120);

    }
    //显示按钮
    public void showButton(Graphics g){
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(1020, 200, 120, 20);
        // 绘制按钮文本
        g.setColor(Color.blue);
        g.setFont(new Font("宋体", Font.BOLD, 16));
        g.drawString("保存并退出游戏", 1025, 215);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(1020, 260, 100, 20);
        // 绘制按钮文本
        g.setColor(Color.blue);
        g.setFont(new Font("宋体", Font.BOLD, 16));
        g.drawString("重新游戏", 1025, 275);

    }
    
    public void paint(Graphics g){  //绘图方法
        super.paint(g);
        g.fillRect(0,0,1000,750);
        showInfo(g);
        showButton(g);
        //画出坦克-封装方法
        if(ut.alive&&ut!=null){ //绘制用户坦克
          drawTank(ut.getX(),ut.getY(),g,ut.getDirect(),ut.getType());
        }

        for(int i=0;i<aiTanks.size();i++) {             //绘制人机坦克
            AiTank aiTank = aiTanks.get(i);
            if (aiTank.alive) {               //判断人机坦克是否存活再绘制
                drawTank(aiTank.getX(), aiTank.getY(), g, aiTank.getDirect(), aiTank.getType());
                //画出所有人机子弹
                for (int j = 0; j < aiTank.aibullets.size(); j++) {
                    Bullet bullet = aiTank.aibullets.get(j);
                    if (bullet.isLive()) {
                        g.fill3DRect(bullet.getX(), bullet.getY(), 4, 4, false);
                    } else {
                        aiTank.aibullets.remove(bullet); //移除子弹
                    }
                }
            }
        }

        //绘制用户子弹
        for(int i=0;i<ut.bullets.size();i++){
            Bullet mybullet=ut.bullets.get(i);
            if(mybullet!=null&&mybullet.isLive()){
                g.setColor(Color.yellow);
                g.fill3DRect(mybullet.getX(),mybullet.getY(),4,4,false);
            }else{
                ut.bullets.remove(mybullet);
            }
        }

        //显示炸弹(从集合中取出)

        for(int i=0;i<bombs.size();i++){
            Bomb bomb=bombs.get(i);
            if(bomb.life>6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if(bomb.life>3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else{
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);

            }
            bomb.lifeDown();
            if(bomb.life==0){
                bombs.remove(bomb);
            }
        }

        //绘制墙
        Wall.wallCreate(g,10,250,10,10,2,20);//竖
        Wall.wallCreate(g,10,230,10,10,29,2);//横
        Wall.wallCreate(g,340,230,10,10,2,20);//竖
        Wall.wallCreate(g,70,420,10,10,29,2);//横
        Wall.wallCreate(g,400,230,10,10,40,2);//横
        //绘制草丛
        Grass.grassCreate(g,760,170,100,100);//横


    }

    //编写绘制坦克方法
    /*
    *   x,坦克的左上角x坐标
    *   y,坦克的左上角y坐标
    *   g,画笔
    *  direct,坦克的方向(上下左右) (0-上，1-下,2-左,3-右)
    *  type,坦克的类型
    * */
    public void drawTank(int x,int y,Graphics g,int direct,int type) {
        switch(type){
            case 0:   //用户坦克
                g.setColor(Color.cyan);
                break;
            case 1:  //人机坦克
                g.setColor((Color.yellow));
                break;
        }
        switch(direct){  //依据坦克方向绘制坦克
            case 0:  //0表示向上
                g.fill3DRect(x,y,5,40,false); //坦克的左轮
                g.fill3DRect(x+15,y,5,40,false);//坦克的右轮
                g.fill3DRect(x+5,y+10,10,20,false);//坦克中间部分
                g.fillOval(x+5,y+15,10,10);//坦克炮台
                g.drawLine(x+10,y,x+10,y+20);//坦克炮筒
                break;
            case 1://1表示向下
                g.fill3DRect(x,y,5,40,false); //坦克的左轮
                g.fill3DRect(x+15,y,5,40,false);//坦克的右轮
                g.fill3DRect(x+5,y+10,10,20,false);//坦克中间部分
                g.fillOval(x+5,y+15,10,10);//坦克炮台
                g.drawLine(x+10,y+20,x+10,y+40);//坦克炮筒
                break;
            case 2://2表示向左
                g.fill3DRect(x,y,40,5,false); //坦克的左轮
                g.fill3DRect(x,y+15,40,5,false);//坦克的右轮
                g.fill3DRect(x+10,y+5,20,10,false);//坦克中间部分
                g.fillOval(x+15,y+5,10,10);//坦克炮台
                g.drawLine(x,y+10,x+20,y+10);//坦克炮筒
                break;
            case 3://3表示向右
                g.fill3DRect(x,y,40,5,false); //坦克的左轮
                g.fill3DRect(x,y+15,40,5,false);//坦克的右轮
                g.fill3DRect(x+10,y+5,20,10,false);//坦克中间部分
                g.fillOval(x+15,y+5,10,10);//坦克炮台
                g.drawLine(x+20,y+10,x+40,y+10);//坦克炮筒
                break;
            default:
                System.out.println("没有处理");
                break;
        }
    }

    /*坦克销毁方法
    * Bullet bt 发射的子弹
    * AiTank aiTank 人机坦克
    * */
    public void destroy(Bullet bt,Tank Tank){
        switch(Tank.getDirect()){
            case 0:  //向上和向下
            case 1:
                if(bt.getX()>Tank.getX()&&bt.getX()<Tank.getX()+20
                        &&bt.getY()>Tank.getY()&&bt.getY()<Tank.getY()+40){
                    bt.setLive(false);
                    Tank.alive=false;
                    aiTanks.remove(Tank);
                    if(Tank instanceof AiTank){//判断是否为人机坦克
                       Recorder.addDesAiTank();
                    }

                    Bomb bomb=new Bomb(Tank.getX(),Tank.getY());
                    bombs.add(bomb);  //加入到集合
                }
                break;
            case 2:  //向左和向右
            case 3:
                if(bt.getX()>Tank.getX()&&bt.getX()<Tank.getX()+40
                &&bt.getY()>Tank.getY()&&bt.getX()<Tank.getY()+20){
                    bt.setLive(false);
                    Tank.alive=false;
                    aiTanks.remove(Tank);
                    if(Tank instanceof AiTank){//判断是否为人机坦克
                        Recorder.addDesAiTank();
                    }
                    Bomb bomb=new Bomb(Tank.getX(),Tank.getY());
                    bombs.add(bomb);  //加入到集合
                }
                break;
            default:
                break;
        }

    }

    /**
     * 销毁用户坦克的方法
     */
    public void destroyUser() {
        for(int i=0;i<aiTanks.size();i++){
            AiTank aiTank=aiTanks.get(i);   //取出每一个人机坦克
            for(int j=0;j<aiTank.aibullets.size();j++){ //判断每一个子弹是否击中用户
                Bullet aibt=aiTank.aibullets.get(j);
                if(aibt.isLive()&&ut.alive){
                    destroy(aibt,ut);
                }
            }
        }

    }
    public void showMessage(){
        int choice = JOptionPane.showConfirmDialog(null,
                "您的坦克被击中了！是否要复活继续游戏？", "游戏结束",
                JOptionPane.YES_NO_OPTION);
        if(choice==JOptionPane.YES_OPTION){
            Recorder.clean();
            frame.dispose();                //关闭当前窗口
            ut.alive=true;
            GameFrame gameFrame=new GameFrame();
            System.out.println("开始删除信息");
            System.out.println("删除信息完成");
        }else {
            System.exit(0);
        }
    }
    public void showMessageWin(){
        int choice = JOptionPane.showConfirmDialog(null,
                "您击败了所有的人机坦克！", "游戏结束",
                JOptionPane.CLOSED_OPTION);

    }

    //鼠标点击事件
    @Override
    public void mouseClicked(MouseEvent e) {

        int mouseX = e.getX();
        int mouseY = e.getY();
        //第一个按钮
        if(mouseX>1020&&mouseX<1140&&mouseY>200&&mouseY<220){//在第一个按钮区域
            Recorder.keepRecord();//存盘
            System.exit(0);
        }
        if(mouseX>1020&&mouseX<1120&&mouseY>260&&mouseY<280){//在第二个按钮区域
            Recorder.clean();//删除信息
            frame.dispose();//关闭当前窗口
            GameFrame gameFrame=new GameFrame();//打开新的游戏窗口
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    //键盘监听处理事件
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //接收用户按键通过用户按下WASD来控制坦克移动

    @Override
    public void keyPressed(KeyEvent e) {

        if(e.getKeyCode()==KeyEvent.VK_J){ //j发射子弹
         //可以发射多颗子弹
                ut.shot();

        }
        if(e.getKeyCode()==KeyEvent.VK_S){ //向下移动
                ut.setDirect(1);
                  ut.moveDown();
        }else if(e.getKeyCode()==KeyEvent.VK_W){ //向上移动
                ut.setDirect(0);
                ut.moveUP();
        }else if(e.getKeyCode()==KeyEvent.VK_A){ //向左移动
                ut.setDirect(2);
                ut.moveLeft();
        }else if(e.getKeyCode()==KeyEvent.VK_D){ //向右移动
                ut.setDirect(3);
                ut.moveRight();
        }
        this.repaint();
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(100);         //间隔100毫秒就重新绘制屏幕达到子弹移动效果
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //判断子弹是否击中坦克
               for(int j=0;j<ut.bullets.size();j++) {
                   Bullet bt=ut.bullets.get(j);
                   if (bt != null && bt.isLive()) { //子弹不为空且存活时
                     for (int i = 0; i < aiTanks.size(); i++) {  //遍历人机坦克
                        AiTank aiTank = aiTanks.get(i);
                        destroy(bt, aiTank);
                       }
                    }
                }
               destroyUser();
            this.repaint();
            if(!ut.alive){
                showMessage();
            }
            if(aiTanks.size()==0){
                showMessageWin();
                Recorder.keepRecord();
                break;
            }

        }
    }

}
