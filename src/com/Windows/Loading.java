/*
 * Created by JFormDesigner on Tue Feb 13 13:19:58 CST 2024
 */

package com.Windows;

import com.Tank.GameFrame;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 30433
 */
public class Loading extends JFrame {  //窗口大小(600,465)
    boolean isend = false;
     LoadingBgm loadingBgm=null;

    public Loading() {
        initComponents();
        this.add(panel1);
        progressBar1.setStringPainted(true);
        panel1.add(progressBar1);
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(label3);
        panel1.add(label4);
        this.setSize(600, 465);
        this.setVisible(true);
        System.out.println("窗口正常显示");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponents() {
        //this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        progressBar1 = new JProgressBar();
        label1 = new JLabel();
        label2 = new JLabel();
        label4 = new JLabel();
        label3 = new JLabel();

        //======== this ========
        setTitle("\u52a0\u8f7d\u754c\u9762......");
        var contentPane = getContentPane();

        //======== panel1 ========
        {
            panel1.setBackground(Color.lightGray);

            //---- label1 ----
            label1.setText("\u6b63\u5728\u52a0\u8f7d\u6e38\u620f\uff0c\u8bf7\u8010\u5fc3\u7b49\u5019\uff01");
            label1.setForeground(Color.red);
            label1.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 20));
            label1.setBackground(Color.lightGray);

            //---- label2 ----
            label2.setText("\u5854\u5854\u5f00\uff01");
            label2.setFont(new Font("\u534e\u6587\u96b6\u4e66", Font.PLAIN, 20));
            label2.setForeground(Color.red);

            //---- label4 ----
            label4.setText("text");
            label4.setIcon(new ImageIcon(getClass().getResource("/freedom.jpg")));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                    .addGroup(panel1Layout.createParallelGroup()
                                            .addGroup(panel1Layout.createSequentialGroup()
                                                    .addGap(119, 119, 119)
                                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 283, GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(label2, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                    .addGap(0, 92, Short.MAX_VALUE))
                                            .addComponent(progressBar1, GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                                            .addComponent(label4, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE))
                                    .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                    panel1Layout.createParallelGroup()
                            .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label2))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(progressBar1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                    .addGap(19, 19, 19))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());

        //---- label3 ----
        label3.setText("text");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JProgressBar progressBar1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label4;
    private JLabel label3;

    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public void updateProgress(int progress) {
        progressBar1.setValue(progress);
    }

    public void progressgeme() {    //加载的方法
      //  Thread progressThread = new Thread(() -> {    //加载线程

            for (int i = 0; i <= 100; i++) {
                try {
                    Thread.sleep(500);  // 模拟加载过程
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.updateProgress(i);
            }

      //  });
       /* progressThread.start(); //启动线程
        try {
            progressThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        /*Thread bgmThread=new Thread(()->{    //音乐线程
            LoadingBgm loadingBgm =new LoadingBgm();
        });

        bgmThread.start();*/

        /*try {
            progressThread.join();
            bgmThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

       /* if (progressBar1.getValue() == 1) {  //进度条加载完成停止播放音乐
            loadingBgm.stopBgm();
        }*/


        this.dispose();            //关闭当前窗口
        try {
            Thread.sleep(10);     //等待10毫秒
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        GameFrame gameFrame = new GameFrame(); //打开游戏窗口
    }

   /* public void load() {
        Thread bgmThread = new Thread(() -> {    //音乐线程
            loadingBgm = new LoadingBgm();
        });

       bgmThread.start();
       progressgeme();
       if(progressBar1.getValue() == 1){

           bgmThread.interrupt();

           this.dispose();            //关闭当前窗口
           *//*try {
               Thread.sleep(10);     //等待10毫秒
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }*//**//*
           GameFrame gameFrame = new GameFrame(); //打开游戏窗口
       }*//*
    }*/
}