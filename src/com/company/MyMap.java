package com.company;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyMap {
    private String name;
    private String way;

    public MyMap(String name, String way) {
        this.name = name;
        this.way = way;
    }

    public String getName() {
        return name;
    }

    public String getWay() {
        return way;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public BufferedImage getBufferedImage(){
        BufferedImage img = null;
        try {
            img =  ImageIO.read(new File(way));
        } catch (IOException e) {
            Frameex f = new Frameex("Путь к файлу указан неверно");
            f.setLocation(Main.size.width / 2 - f.getWidth() / 2, Main.size.height / 2 - f.getHeight() / 2);
            f.setVisible(true);
        }
        return img;
    }
}
