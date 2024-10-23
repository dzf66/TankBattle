package com.Windows;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UsersFile {    //用户账号密码类
    //创建文件地址，文件名
    private static final String File_PATH= System.getProperty("user.dir")+"/users.txt";
   //用map来保存一个用户
    private static Map<String, String> users = new HashMap<>();

    /**
     * 注册方法
     * @param name 输入的用户名
     * @param password 输入的密码
     */
    private static void RegisterUser(String name,String password){
        if(users.containsKey(name)){
            JOptionPane.showConfirmDialog(null,
                    "用户名已存在，请重新输入！","提示",JOptionPane.CLOSED_OPTION);
        }
        users.put(name,password);
        JOptionPane.showConfirmDialog(null,
                "注册成功！","提示",JOptionPane.CLOSED_OPTION);
    }

    /**
     * 登录方法
     * @param name 用户名
     * @param password 密码
     */
    private static void Login(String name,String password){
        //判断是否正确
        if(users.containsKey(name)&&users.get(name).equals(password)){

        }
    }

}
