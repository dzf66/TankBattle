package com.Windows;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.InputStream;

public class LoadingBgm {
    private Clip clip;
    private boolean isend=false;
    public LoadingBgm(){
        try{
            InputStream inputStream = LoadingBgm.class.getResourceAsStream("/bgm.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);
            clip=AudioSystem.getClip();
            clip.open(audioInputStream);  //打开音频流
            clip.start();

           if(isend) {
               clip.close();
               audioInputStream.close();
               inputStream.close();
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void stopBgm() {
        if (clip != null) {
            clip.stop(); // 停止音频播放
            clip.close(); // 关闭音频流

        }
    }

    public boolean isIsend() {
        return isend;
    }

    public void setIsend(boolean isend) {
        this.isend = isend;
    }
}


