package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Frameadd extends javax.swing.JFrame {

    public Frameadd() {
        initComponents();
    }

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);


        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 20));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 20));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel1.setText("Придумайте имя:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 20));
        jLabel2.setText("Укажите путь к файлу:");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 20));
        jButton1.setText("Добавить");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boolean ex = false;
                if (jTextField2.getText().equals("")){
                    Frameex f = new Frameex("Введите имя");
                    f.setLocation(Main.size.width / 2 - f.getWidth() / 2, Main.size.height / 2 - f.getHeight() / 2);
                    f.setVisible(true);
                    ex = true;
                }else if(jTextField1.getText().equals("")){
                    Frameex f = new Frameex("Введите путь к файлу");
                    f.setLocation(Main.size.width / 2 - f.getWidth() / 2, Main.size.height / 2 - f.getHeight() / 2);
                    f.setVisible(true);
                    ex = true;
                }else{
                    boolean l = false;
                    for (int i = 0; i < Main.maps.size(); i++) {
                        if (jTextField2.getText().equals(Main.maps.get(i).getName())){
                            l = true;
                        }
                    }
                    if (l){
                        Frameex f = new Frameex("Карта с таким именем уже существует");
                        f.setLocation(Main.size.width / 2 - f.getWidth() / 2, Main.size.height / 2 - f.getHeight() / 2);
                        f.setVisible(true);
                        ex = true;
                    }
                }
                if (!ex) {
                    Main.maps.add(new MyMap(jTextField2.getText(), jTextField1.getText()));
                    Frame.addItem(jTextField2.getText());
                    PrintWriter pw = null;
                    try {
                        pw = new PrintWriter("maps.txt");
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < Main.maps.size(); i++) {
                        pw.println(Main.maps.get(i).getName());
                        pw.println(Main.maps.get(i).getWay());
                    }
                    pw.close();
                    setVisible(false);
                }
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20));
        jButton2.setText("Отмена");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setVisible(false);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(26, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())

        );

        pack();


    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
}
