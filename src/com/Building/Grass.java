package com.Building;

import com.Tank.GamePanel;

import java.awt.*;

public class Grass {
    static private GamePanel myPanel;
    public Grass(GamePanel myPanel){
        this.myPanel=myPanel;
    }
    static Image imagegrass=Toolkit.getDefaultToolkit().getImage(GamePanel.class.getResource("/grass.png"));
    public static void grassCreate(Graphics g, int startX, int startY, int Width, int Height){
        for (int i = 0; i < 5; i++) {
            startX+=30;
            g.drawImage(imagegrass, startX, startY, Width, Height, myPanel);
        }
    }

}

