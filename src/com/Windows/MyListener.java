package com.Windows;

import com.Tank.GameFrame;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
public class MyListener extends MouseAdapter {      //对登录和注册按钮事件的处理
    //创建文件地址，文件名
    private  final String File_PATH= System.getProperty("user.dir")+"/users.txt";
    //用map来保存一个用户
    private  Map<String, String> users = new HashMap<>();

    private MenuFrame menuFrame; //获取窗口对象

    public MyListener(MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton bt = (JButton) e.getSource(); //获取事件源对象
        String id = menuFrame.getTextname().getText(); //获取用户名
        String password = menuFrame.getTextpassword().getText();//获取密码
        if (StringUtil.isEmpty(id) && StringUtil.isEmpty(password)) {
            menuFrame.getIdWarning().setVisible(true);
            menuFrame.getPwWarning().setVisible(true);
        } else {
            if (StringUtil.isEmpty(id)) { //账号为空
                menuFrame.getIdWarning().setVisible(true);
                menuFrame.getPwWarning().setVisible(false);
            }
            if (StringUtil.isEmpty(password)) {  //密码为空
                menuFrame.getIdWarning().setVisible(false);
                menuFrame.getPwWarning().setVisible(true);
            }
        }
        if (!StringUtil.isEmpty(id) && !StringUtil.isEmpty(password)) {//都不为空
            loadFromFile();//读取文件信息
            if(users.size()!=0) { //文件不为空时
                if (bt.getText().equals("登录并开始游戏")) {
                    Login(id, password);
                }
                if(bt.getText().equals("注册账号")){
                    System.out.println("开始注册");
                    RegisterUser(id,password);
                }
            }else if(users.size()==0){  //为文件空的情况
                if(bt.getText().equals("登录并开始游戏")){
                    JOptionPane.showConfirmDialog(null,
                            "还没有用户先注册","提示",JOptionPane.CLOSED_OPTION);
                }
                if(bt.getText().equals("注册账号")){
                    System.out.println("开始注册");
                    RegisterUser(id,password);
                }
            }
               /* menuFrame.dispose();  //关闭主菜单窗口
                Loading loadFrame = new Loading();        //加载窗口

                // 创建音乐播放线程
                Thread musicThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        LoadingBgm loadingBgm = new LoadingBgm();
                    }
                });
                //创建加载线程
                Thread loadingThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        final int[] i = {0}; // 将变量 i 包装为数组并声明为 final
                        Timer timer = new Timer(500, null); // 创建一个定时器，每隔500毫秒触发一次
                        timer.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                loadFrame.updateProgress(i[0]);
                                i[0]++;

                                if (i[0] > 100) {
                                    timer.stop(); // 加载完成后停止定时器
                                    try {
                                        Thread.sleep(6000); // 等待6秒
                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }
                                    musicThread.interrupt();
                                    loadFrame.dispose();// 关闭加载窗口
                                    // 创建游戏窗口并显示
                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            GameFrame gameFrame = new GameFrame();
                                        }
                                    });
                                }
                            }
                        });
                        timer.start();// 启动定时器
                    }
                });

                // 启动加载线程和音乐线程
                loadingThread.start();
                musicThread.start();*/
        }
        saveFile();//保存更新的文件信息
    }

    /**
     * 注册方法
     * @param name 输入的用户名
     * @param password 输入的密码
     */
    public  void RegisterUser(String name,String password) {
        if (users.containsKey(name)) {
            JOptionPane.showConfirmDialog(null,
                    "用户名已存在，请重新输入！", "提示", JOptionPane.CLOSED_OPTION);
        }else{
            users.put(name,password);
            JOptionPane.showConfirmDialog(null,
                    "注册成功！","提示",JOptionPane.CLOSED_OPTION);
        }

    }

    /**
     * 登录方法
     * @param name 用户名
     * @param password 密码
     */
    public void Login(String name,String password){
        //判断是否正确
        if(users.containsKey(name)&&users.get(name).equals(password)){
            menuFrame.dispose();  //关闭主菜单窗口
            Loading loadFrame = new Loading();        //加载窗口

            // 创建音乐播放线程(匿名类)
            Thread musicThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LoadingBgm loadingBgm = new LoadingBgm();
                }
            });
            //创建加载线程(匿名类)
            Thread loadingThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    final int[] i = {0}; // 将变量 i 包装为数组并声明为 final(为了线程安全)
                    Timer timer = new Timer(500, null); // 创建一个定时器，每隔500毫秒触发一次
                    timer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            loadFrame.updateProgress(i[0]);
                            i[0]++;
                            if (i[0] > 100) {
                                timer.stop(); // 加载完成后停止定时器
                                try {
                                    Thread.sleep(6000); // 等待6秒
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                                musicThread.interrupt();
                                loadFrame.dispose();// 关闭加载窗口
                                // 创建游戏窗口并显示
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        GameFrame gameFrame = new GameFrame();
                                    }
                                });
                            }
                        }
                    });
                    timer.start();// 启动定时器
                }
            });

            // 启动加载线程和音乐线程
            loadingThread.start();
            musicThread.start();
        }else{
            JOptionPane.showConfirmDialog(null,
                    "账号或密码错误，请重新输入，若没有账号请先注册！","提示",
                    JOptionPane.CLOSED_OPTION);
        }

    }

    //读取文件信息
    public void loadFromFile(){
        try(BufferedReader br=new BufferedReader(new FileReader(File_PATH))) {
            String line;
            while((line=br.readLine())!=null){
                String[] parts=line.split(",");//以","为分隔标记读取
                String name=parts[0];
                String password=parts[1];
                users.put(name,password);//将文件中的信息读取到map中
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //保存文件信息
    public void saveFile(){
        try (BufferedWriter bw=new BufferedWriter(new FileWriter(File_PATH))){
            //遍历users的Map中的键值对，然后写入到文件中
            for (Map.Entry<String, String> entry : users.entrySet()) {
                String line = entry.getKey() + "," + entry.getValue();
                bw.write(line);
                bw.newLine();//换行
                bw.flush();//刷新缓冲区
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}

