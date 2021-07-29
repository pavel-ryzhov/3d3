package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.Infinity;

public class Panel extends JPanel {
//    public static ArrayList<Long> sp = new ArrayList<>();
    public static ArrayList<Point> points;
    public static ArrayList<Point> points1;
    public static ArrayList<Point> walls = new ArrayList<>();
    public static ArrayList<Boolean> greenwalls = new ArrayList<>();
    public static int realfps = 0;
    public static ArrayList<Integer> forrealfps = new ArrayList<>(10);
    @Override
    public void paint(Graphics g){
//        super.paint(g);
        long time = System.currentTimeMillis();
//        long time1 = System.currentTimeMillis();
//        long time = System.nanoTime();
        walls((int)Main.center[0], (int)Main.center[1]);
//        System.out.println(System.currentTimeMillis() - time);
//        System.out.println(System.nanoTime() - time);
        ArrayList<Point> l3 = new ArrayList<>();
        for (int i = 0; i < Main.coordinates2.length; i++) {
            l3.add(new Point((int)Math.round(Main.coordinates2[i][0]), (int)Math.round(Main.coordinates2[i][1])));
        }





//        for (int r = 0; r < l3.size(); r++) {
////            long time = System.nanoTime();
//            points = arrayofpoints(l3.get(r), Main.center);
////            System.out.println(System.nanoTime() - time);
////            long time = System.nanoTime();
//            second:
//            for (int i = 0; i < points.size(); i++) {
//                for (int j = 0; j < walls.size(); j++) {
//                    if (walls.get(j).x == points.get(i).x && walls.get(j).y == points.get(i).y) {
//                        double s = Math.sqrt(Math.pow(walls.get(j).x - Main.center[0], 2) + Math.pow(walls.get(j).y - Main.center[1], 2));
////                        long time = System.nanoTime();
//                        drawRect(((Main.size.width - Main.k1 * Main.coordinates2.length) / 2 + (int) (Main.k1 / 2.0) + r * Main.k1), (int) ((Main.size.height - Main.k / s) / 2), (int) ((Main.size.height - Main.k / s) / 2 + Main.k / s), g, s, greenwalls.get(j));
////                        System.out.println(System.nanoTime() - time);
//                        break second;
//                    }
//                }
//            }
////            System.out.println(System.nanoTime() - time);
//        }

//        int[][] fordraw0 = new int[l3.size()][3];
//        double[] fordraw1 = new double[l3.size()];
//        boolean[] fordraw2 = new boolean[l3.size()];
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int r = 0; r < l3.size() / 2; r++) {
//                    points = arrayofpoints(l3.get(r), Main.center);
//                    second:
//                    for (int i = 0; i < points.size(); i++) {
//                        for (int j = 0; j < walls.size(); j++) {
//                            if (walls.get(j).x == points.get(i).x && walls.get(j).y == points.get(i).y) {
//                                double s = Math.sqrt(Math.pow(walls.get(j).x - Main.center[0], 2) + Math.pow(walls.get(j).y - Main.center[1], 2));
//                                fordraw0[r][0] = ((Main.size.width - Main.k1 * Main.coordinates2.length) / 2 + (int) (Main.k1 / 2.0) + r * Main.k1);
//                                fordraw0[r][1] = (int) ((Main.size.height - Main.k / s) / 2);
//                                fordraw0[r][2] = (int) ((Main.size.height - Main.k / s) / 2 + Main.k / s);
//                                fordraw1[r] = s;
//                                fordraw2[r] = greenwalls.get(j);
//                                break second;
//                            }
//                        }
//                    }
//                }
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int r = l3.size() / 2; r < l3.size(); r++) {
//                    points1 = arrayofpoints(l3.get(r), Main.center);
//                    second:
//                    for (int i = 0; i < points1.size(); i++) {
//                        for (int j = 0; j < walls.size(); j++) {
//                            if (walls.get(j).x == points1.get(i).x && walls.get(j).y == points1.get(i).y) {
//                                double s = Math.sqrt(Math.pow(walls.get(j).x - Main.center[0], 2) + Math.pow(walls.get(j).y - Main.center[1], 2));
//                                fordraw0[r][0] = ((Main.size.width - Main.k1 * Main.coordinates2.length) / 2 + (int) (Main.k1 / 2.0) + r * Main.k1);
//                                fordraw0[r][1] = (int) ((Main.size.height - Main.k / s) / 2);
//                                fordraw0[r][2] = (int) ((Main.size.height - Main.k / s) / 2 + Main.k / s);
//                                fordraw1[r] = s;
//                                fordraw2[r] = greenwalls.get(j);
//                                break second;
//                            }
//                        }
//                    }
//                }
//            }
//        });
//        thread1.start();
//        thread2.start();
//        try {
//            thread1.join();
//            thread2.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
//        for (int i = 0; i < fordraw0.length; i++) {
//            drawRect(fordraw0[i][0], fordraw0[i][1], fordraw0[i][2], g, fordraw1[i], fordraw2[i]);
//        }




        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int r = 0; r < l3.size() / 2; r++) {
                    points = arrayofpoints(l3.get(r), Main.center);
                    second:
                    for (int i = 0; i < points.size(); i++) {
                        for (int j = 0; j < walls.size(); j++) {
                            if (walls.get(j).x == points.get(i).x && walls.get(j).y == points.get(i).y) {
                                double s = Math.sqrt(Math.pow(walls.get(j).x - Main.center[0], 2) + Math.pow(walls.get(j).y - Main.center[1], 2));
                                drawRect(((Main.size.width - Main.k1 * Main.coordinates2.length) / 2 + (int) (Main.k1 / 2.0) + r * Main.k1), (int) ((Main.size.height - Main.k / s) / 2), (int) ((Main.size.height - Main.k / s) / 2 + Main.k / s), g, s, greenwalls.get(j));
                                break second;
                            }
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int r = l3.size() / 2; r < l3.size(); r++) {
                    points1 = arrayofpoints(l3.get(r), Main.center);
                    second:
                    for (int i = 0; i < points1.size(); i++) {
                        for (int j = 0; j < walls.size(); j++) {
                            if (walls.get(j).x == points1.get(i).x && walls.get(j).y == points1.get(i).y) {
                                double s = Math.sqrt(Math.pow(walls.get(j).x - Main.center[0], 2) + Math.pow(walls.get(j).y - Main.center[1], 2));
                                drawRect(((Main.size.width - Main.k1 * Main.coordinates2.length) / 2 + (int) (Main.k1 / 2.0) + r * Main.k1), (int) ((Main.size.height - Main.k / s) / 2), (int) ((Main.size.height - Main.k / s) / 2 + Main.k / s), g, s, greenwalls.get(j));
                                break second;
                            }
                        }
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        if (forrealfps.size() != 10) forrealfps.add((int)(System.currentTimeMillis() - time));
        else{
            int y = 10000 / sum(forrealfps);
            if (Main.dynamicfps){
                realfps = y;
                if (realfps > Main.fps) Main.fps++;
                if (realfps < Main.fps) Main.fps--;
            }else{
                realfps = Math.min(y, Main.fps);
            }
            forrealfps.clear();
        }

//        realfps = 1000 / (int)(System.currentTimeMillis() - time);
//        System.out.println(System.currentTimeMillis() - time);
//        sp.add(System.currentTimeMillis() - time);
    }
    public static void walls(int x, int y) {
        walls.clear();
        greenwalls.clear();
        for (int i = x - Main.r; i < x + Main.r; i++) {
            for (int j = y - Main.r; j < y + Main.r; j++) {
                if (Main.start_walls[i][j] == 1) {
                    walls.add(new Point(i, j));
                    greenwalls.add(false);
                }
                if (Main.start_walls[i][j] == 2) {
                    walls.add(new Point(i, j));
                    greenwalls.add(true);
                }
            }
        }
        int kv = Main.kv;
        Point center = new Point((int)Main.center[0], (int)Main.center[1]);
        int[] j = new int[8];
        for (int i = x - kv / 2; i <= x + kv / 2; i++) {
            for (int i1 = y - kv / 2; i1 <= y + kv / 2; i1++) {
                if(Main.start_walls[i][i1] == 1){
                    if (i1 < center.y && i1 >= center.y - kv / 2 && i < center.x && i >= center.x - kv / 2)j[0]++;
                    if (i1 > center.y && i1 <= center.y + kv / 2 && i < center.x && i >= center.x - kv / 2)j[6]++;
                    if (i1 < center.y && i1 >= center.y - kv / 2 && i > center.x && i <= center.x + kv / 2)j[2]++;
                    if (i1 > center.y && i1 <= center.y + kv / 2 && i > center.x && i <= center.x + kv / 2)j[4]++;
                    if (i == center.x && i1 < center.y && i1 >= center.y - kv / 2)j[1]++;
                    if (i == center.x && i1 > center.y && i1 <= center.y + kv / 2)j[5]++;
                    if (i1 == center.y && i < center.x && i >= center.x - kv / 2)j[7]++;
                    if (i1 == center.y && i > center.x && i <= center.x + kv / 2)j[3]++;
                }
                if(Main.start_walls[i][i1] == 2){
                    if (!Main.end) {
                        Main.end = true;
                        Main.end();
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if (j[i] > 0) Main.wall[i] = true;
            else Main.wall[i] = false;
        }
    }
    public static synchronized ArrayList<Point> arrayofpoints (Point l, double[] l1){
        ArrayList<Point> points = new ArrayList<>();
        double m = (l.y - l1[1]) / (l.x - l1[0]);
        double b = l1[1] - (m * l1[0]);
        boolean vertical = false;
        if (m == Infinity || m == -Infinity){
            vertical = true;
        }
        points.clear();
        if (!vertical) {
            if (Math.abs(l1[0] - l.x) > Math.abs(l1[1] - l.y)) {
                if ((int)l1[0] < l.x){
                    for (int i = (int)l1[0]; i <= l.x; i++) {
                        points.add(new Point(i, (int)Math.round(m * i + b)));
                    }
                }else {
                    for (int i = (int)l1[0]; i >= l.x; i--) {
                        points.add(new Point(i, (int)Math.round(m * i + b)));
                    }
                }
            } else {
                if ((int)l1[1] < l.y){
                    for (int i = (int)l1[1]; i <= l.y; i++) {
                        points.add(new Point((int) Math.round((i - b) / m), i));
                    }
                }else {
                    for (int i = (int)l1[1]; i >= l.y; i--) {
                        points.add(new Point((int) Math.round((i - b) / m), i));
                    }
                }
            }
        } else {
            if ((int)l1[1] < l.y) {
                for (int i = (int)l1[1]; i <= l.y; i++) {
                    points.add(new Point(l.x, i));
                }
            }else{
                for (int i = (int)l1[1]; i >= l.y; i--) {
                    points.add(new Point(l.x, i));
                }
            }
        }
        return points;
    }
    public synchronized static void drawRect(int x, int y, int y1, Graphics g, double s, boolean d){
        if (d){
            g.setColor(Color.GREEN);
        }
        if (!d){
            int z = (int) (s * 250 / Main.r);
            g.setColor(new Color(z, z, z));
        }
        g.fillRect(x, y - Main.k1 / 2, Main.k1, y1 - y);
    }
    public static int hhh (double x1, double y1, int kv, double x, double y){
        double f = 1.0 / (kv / 2);
        if (y < y1 - f && y >= y1 - kv / 2 - f && x < x1 - f && x >= x1 - kv / 2 - f)return 0;
        if (y > y1 + f && y <= y1 + kv / 2 + f && x < x1 - f && x >= x1 - kv / 2 - f)return 6;
        if (y < y1 - f && y >= y1 - kv / 2 - f && x > x1 + f && x <= x1 + kv / 2 + f)return 2;
        if (y > y1 + f && y <= y1 + kv / 2 + f && x > x1 + f && x <= x1 + kv / 2 + f)return 4;
        if (y < y1 - f && y >= y1 - kv / 2 - f && x < x1 + f && x >= x1 - f)return 1;
        if (y > y1 + f && y <= y1 + kv / 2 + f && x < x1 + f && x >= x1 - f)return 5;
        if (x < x1 - f && x >= x1 - kv / 2 - f && y < y1 + f && y >= y1 - f)return 7;
        if (x > x1 + f && x <= x1 + kv / 2 + f && y < y1 + f && y >= y1 - f)return 3;
        else return -1;
    }
    public static int average(List<Integer> arr){
        int sum = 0;
        for (Integer x: arr) sum += x;
        return sum / arr.size();
    }
    public static int sum(ArrayList<Integer> arr){
        int sum = 0;
        for (Integer x: arr) sum += x;
        return sum;
    }
}