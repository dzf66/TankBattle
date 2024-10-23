package com.Windows;

/**
 * 用于判断字符串为空的类
 */
public class StringUtil {

    /**
     * 用于判断字符串是否为空的方法
     * @param s 要判断的字符串
     * @return 返回结果，为空为true，非空为false
     */
    public static boolean isEmpty(String s){
        if((s.trim().equals(""))||s==null){
            return true;
        }else{
            return false;
        }
    }
}
