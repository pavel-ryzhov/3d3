package com.company;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;

public class Main {
    private static Frame0 f;
    private static Frame mainframe;

    public static int k0 = 200;
    public static int k = 30000;
    public static Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
    public static double [][] coordinates2;
    public static double k2 = 0.2;
    public static int locationX = size.width / 2;
    public static int r;
    public static double deg;
    public static double speed;
    public static byte [][] start_walls = new byte[size.width][size.height];
    public static double[] center = {size.width / 2.0, size.height / 2.0};
    public static BufferedImage img = null;
    public static int k1;
    public static boolean w = false;
    public static boolean s = false;
    public static boolean a = false;
    public static boolean d = false;
    public static boolean[] wall = new boolean[8];
    public static int kv = 11;
    public static ArrayList<MyMap> maps = new ArrayList<>();
    public static boolean end = false;
    public static boolean ingame = true;
    public static double spdeg;
    public static final String[] MAPS = {"карта1", "карта4", "карта3"};
    public static String[] settings = new String[9];
    public static int fps = 30;
    public static boolean dynamicfps = false;

    public static void main(String[] args) {
        try {
            if (!new File("maps.txt").exists()) {
                PrintWriter pw = new PrintWriter(new File("maps.txt"));
                pw.println("карта1");
                pw.println("карта1.png");
                pw.println("карта3");
                pw.println("карта3.png");
                pw.println("карта4");
                pw.println("карта4.png");
                pw.close();
            }
            BufferedReader br = new BufferedReader(new FileReader("maps.txt"));
            try {
                String l;
                while ((l = br.readLine()) != null) {
                    maps.add(new MyMap(l, br.readLine()));
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            mainframe = new Frame();
            if (!new File("settings.txt").exists()) setdefaultsettings();
            updatesettings();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        mainframe.setLocation(size.width / 2 - mainframe.getWidth() / 2, size.height / 2 - mainframe.getHeight() / 2);
        mainframe.setVisible(true);
    }
    public static void setdefaultsettings(){

            try {
                PrintWriter pw = new PrintWriter(new File("settings.txt"));
                pw.println(Toolkit.getDefaultToolkit().getScreenSize().width + "");
                pw.println(Toolkit.getDefaultToolkit().getScreenSize().height + "");
                pw.println("false");
                pw.println("30");
                pw.println("false");
                pw.println("200");
                pw.println("30000");
                pw.println("0.2");
                pw.println("11");
                pw.close();
            } catch (FileNotFoundException e) {
                Frameex frameex = new Frameex("Файл не найден");
                frameex.setLocation(Main.size.width / 2 - frameex.getWidth() / 2, Main.size.height / 2 - frameex.getHeight() / 2);
                frameex.setVisible(true);
            }

    }
    public static void updatesettings(){
        try {
            BufferedReader br1 = new BufferedReader(new FileReader("settings.txt"));
            try {
                for (int i = 0; i < 9; i++) {
                    settings[i] = br1.readLine();
                }
                br1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            size = new Dimension(Integer.parseInt(settings[0]), Integer.parseInt(settings[1]));
            mainframe.setLocation(size.width / 2 - mainframe.getWidth() / 2, size.height / 2 - mainframe.getHeight() / 2);
        }catch (FileNotFoundException e){
            Frameex frameex = new Frameex("Файл не найден");
            frameex.setLocation(Main.size.width / 2 - frameex.getWidth() / 2, Main.size.height / 2 - frameex.getHeight() / 2);
            frameex.setVisible(true);
        }
    }
    public static void start(){

        dynamicfps = Boolean.parseBoolean(settings[2]);
        fps = Integer.parseInt(settings[3]);
        k0 = Integer.parseInt(settings[5]);
        k = Integer.parseInt(settings[6]);
        k2 = Double.parseDouble(settings[7]);
        kv = Integer.parseInt(settings[8]);

        coordinates2 = new double[k0][2];
        k1 = size.width / coordinates2.length;
        ingame = true;
        end = false;
        f = new Frame0();
        for (int i = size.width / 2 - img.getWidth() / 2, r = 0; i < size.width / 2 + img.getWidth() / 2; i++, r++) {
            for (int i1 = size.height / 2 - img.getHeight() / 2, r1 = 0; i1 < size.height / 2 + img.getHeight() / 2; i1++, r1++) {
                if (img.getRGB(r, r1) == Color.BLACK.getRGB()) start_walls[i][i1] = 1;
                if (img.getRGB(r, r1) == Color.GREEN.getRGB()) start_walls[i][i1] = 2;
                if (img.getRGB(r, r1) == Color.red.getRGB()) {
                    center[0] = r + size.width / 2.0 - img.getWidth() / 2.0;
                    center[1] = r1 + size.height / 2.0 - img.getHeight() / 2.0;
                }
            }
        }
        f.setVisible(true);
    }
    public static void end(){
        f.setVisible(false);
        Frame f = new Frame();
        f.setLocation(size.width / 2 - f.getWidth() / 2, size.height / 2 - f.getHeight() / 2);
        f.setVisible(true);


        Frameend g = new Frameend();
        g.setLocation(size.width / 2 - g.getWidth() / 2, size.height / 2 - g.getHeight() / 2);
        g.setVisible(true);
    }
    public static void end1(){
        Frame0.timesec = 0;
        Frame0.timemin = 0;
        Frame0.timehou = 0;
        f.setVisible(false);
        Frame f = new Frame();
        f.setLocation(size.width / 2 - f.getWidth() / 2, size.height / 2 - f.getHeight() / 2);
        f.setVisible(true);
    }
}
