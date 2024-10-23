package com.Tank;
import com.Windows.LoadingBgm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class GameFrame extends JFrame {
    private GamePanel gp=null;
    Scanner scanner=new Scanner(System.in);
    String key="1";//默认新游戏
    public GameFrame(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); //获取屏幕大小
        gp=new GamePanel(this,key);
        Thread thread=new Thread(gp);
        thread.start();  //启动画板线程
        this.addKeyListener(gp);  //键盘监听器
        this.addMouseListener(gp);//鼠标监听器
        this.add(gp);
        this.setSize(1200,750); //窗口大小
        int centerX = (screenSize.width - this.getWidth()) / 2;
        int centerY = (screenSize.height - this.getHeight()) / 2;
        this.setLocation(centerX,centerY);  //使窗口在屏幕中央
        this.setTitle(" 坦克大战---(重新开始R键，开火J键)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        //增加关闭窗口的处理
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("监听到了关闭窗口");
                Recorder.keepRecord();//存盘
                System.out.println("监听到了关闭窗口");
                System.exit(0);
            }
        });

    }

}
