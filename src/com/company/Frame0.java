package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class Frame0 extends JFrame {
    public static byte timesec = 0, timemin = 0, timehou = 0;
    public static Timer t;
    public Frame0() {
        JLabel g1 = new JLabel();
        JLabel g2 = new JLabel();
        g1.setText(timehou + ":" + timemin + ":" + timesec);
        class Task1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                timesec += 1;
                if (timesec == 60){
                    timesec = 0;
                    timemin += 1;
                }
                if (timemin == 60){
                    timemin = 0;
                    timehou += 1;
                }
                g1.setText(timehou + ":" + timemin + ":" + timesec);
                g2.setText("FPS: " + Panel.realfps);
            }
        }
        Task1 d = new Task1();
        t = new Timer(1000, d);
        t.restart();
        BufferedImage cursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(cursorImg, new Point(0, 0), "blank cursor");
        setCursor(blankCursor);
        setSize(Main.size.getSize());
        setUndecorated(true);
        class Mouse implements MouseMotionListener {
            @Override
            public void mouseDragged(MouseEvent e) {
            }
            @Override
            public void mouseMoved(final MouseEvent e) {
                if (Main.ingame) {
                    if (e.getX() > Main.locationX) {
                        Main.deg += (e.getX() - Main.locationX) * 1.0 / 10;
                    }
                    if (e.getX() < Main.locationX) {
                        Main.deg -= (Main.locationX - e.getX()) * 1.0 / 10;
                    }
                    Main.locationX = Main.size.width / 2;
                    try {
                        Robot r = new Robot();
                        r.mouseMove(Main.size.width / 2, Main.size.height / 2);
                    } catch (AWTException awtException) {
                        awtException.printStackTrace();
                    }
                }
            }
        }
        class KeyListener1 implements KeyListener {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                if (Main.ingame) {
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        Main.spdeg = Main.deg;
                        Main.w = false;
                        Main.s = false;
                        Main.a = false;
                        Main.d = false;
                        t.stop();
                        Main.ingame = false;
                        Framepause u = new Framepause();
                        u.setLocation(Main.size.width / 2 - u.getWidth() / 2, Main.size.height / 2 - u.getHeight() / 2);
                        JPanel p = new JPanel();
                        p.setBackground(Color.LIGHT_GRAY);
                        p.setSize(u.getSize());
                        u.setVisible(true);
                    }
                    if (e.getKeyCode() == KeyEvent.VK_W) Main.w = true;
                    if (e.getKeyCode() == KeyEvent.VK_S) Main.s = true;
                    if (e.getKeyCode() == KeyEvent.VK_A) Main.a = true;
                    if (e.getKeyCode() == KeyEvent.VK_D) Main.d = true;
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                if (Main.ingame) {
                    if (e.getKeyCode() == KeyEvent.VK_W) Main.w = false;
                    if (e.getKeyCode() == KeyEvent.VK_S) Main.s = false;
                    if (e.getKeyCode() == KeyEvent.VK_A) Main.a = false;
                    if (e.getKeyCode() == KeyEvent.VK_D) Main.d = false;
                }
            }
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addMouseMotionListener(new Mouse());
        addKeyListener(new KeyListener1());
        JLayeredPane pane = getLayeredPane();
        pane.setSize(Main.size);

        JPanel h2 = new JPanel();
        JPanel h1 = new JPanel();
        h1.setBackground(Color.GRAY);
        h2.setBackground(Color.GRAY);
        Panel h = new Panel();
        h.setSize(Main.size);
        h1.setBounds(0, 0, 100, 45);
        h2.setBounds(Main.size.width - 100, 0, 100, 45);
        g1.setFont(new java.awt.Font("Tahoma", 0, 20));
        g2.setFont(new java.awt.Font("Tahoma", 0, 20));
        h1.add(g1);
        h2.add(g2);
        pane.add(h);
        pane.add(h1);
        pane.add(h2);
        pane.setLayer(h, 1);
        pane.setLayer(h1, 2);
        pane.setLayer(h2, 2);
        class ActionListener1 implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                double r1 = 0;
//                long time = System.currentTimeMillis();
                for (int i = 0; i < Main.coordinates2.length; i++) {
                    Main.coordinates2[i][0] = Main.center[0] + Main.r * Math.cos(Math.toRadians(Main.deg + r1));
                    Main.coordinates2[i][1] = Main.center[1] + Main.r * Math.sin(Math.toRadians(Main.deg + r1));
                    r1 += Main.k2;
                    r1 = Math.round(r1 * 100) / 100.0;
                }
//                System.out.println(System.currentTimeMillis() - time);
                pane.repaint();
            }
        }
        ActionListener1 g = new ActionListener1();
        class Thread2 extends Thread{
            @Override
            public void run() {
                while (true) {
                    boolean w1 = Main.w, s1 = Main.s, a1 = Main.a, d1 = Main.d;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    double cos = Main.speed * Math.cos(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2)));
                    double sin = Main.speed * Math.sin(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2)));
                    double cosp90 = Main.speed * Math.cos(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) + 90));
                    double cosm90 = Main.speed * Math.cos(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) - 90));
                    double sinp90 = Main.speed * Math.sin(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) + 90));
                    double sinm90 = Main.speed * Math.sin(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) - 90));
                    double sinm135 = Main.speed * Math.sin(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) - 135));
                    double cosm135 = Main.speed * Math.cos(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) - 135));
                    double sinm45 = Main.speed * Math.sin(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) - 45));
                    double cosm45 = Main.speed * Math.cos(Math.toRadians(Main.deg + (Main.coordinates2.length * Main.k2 / 2) - 45));
                    if (w1 && !a1 && !d1 && !s1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] + cos, Main.center[1] + sin)]) {
                        Main.center[0] += cos;
                        Main.center[1] += sin;
                    }
                    if (s1 && !a1 && !d1 && !w1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] - cos, Main.center[1] - sin)]) {
                        Main.center[0] -= cos;
                        Main.center[1] -= sin;
                    }
                    if (a1 && !w1 && !d1 && !s1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] + cosm90, Main.center[1] + sinm90)]) {
                        Main.center[0] += cosm90;
                        Main.center[1] += sinm90;
                    }
                    if (d1 && !w1 && !a1 && !s1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] + cosp90, Main.center[1] + sinp90)]) {
                        Main.center[0] += cosp90;
                        Main.center[1] += sinp90;
                    }
                    if (w1 && a1 && !s1 && !d1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] + cosm45, Main.center[1] + sinm45)]){
                        Main.center[0] += cosm45;
                        Main.center[1] += sinm45;
                    }
                    if (w1 && d1 && !s1 && !a1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] - cosm135, Main.center[1] - sinm135)]){
                        Main.center[0] -= cosm135;
                        Main.center[1] -= sinm135;
                    }
                    if (s1 && a1 && !w1 && !d1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] + cosm135, Main.center[1] + sinm135)]){
                        Main.center[0] += cosm135;
                        Main.center[1] += sinm135;
                    }
                    if (s1 && d1 && !w1 && !a1 && !Main.wall[Panel.hhh(Main.center[0], Main.center[1], Main.kv, Main.center[0] - cosm45, Main.center[1] - sinm45)]){
                        Main.center[0] -= cosm45;
                        Main.center[1] -= sinm45;
                    }
                }
            }
        }
        new Thread2().start();
//        if (!Main.dynamicfps) new Timer(1000 / Main.fps, g).start();
        new Timer(1000 / Main.fps, g).start();
//        else{
//            System.out.println("kkk");
//        }





//        new Timer(25, g).start();
    }
}
