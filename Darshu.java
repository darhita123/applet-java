package com.company;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Darshu extends Applet implements ActionListener,Runnable{
    String name;
    int fontSize=16;
    Label label = new Label("Enter your Name=");
    TextField textField1 = new TextField();

    Button button = new Button("Submit");
    boolean stopFlag = true;
    Thread t=null;
    int y=30;


    public void init()
    {
        add(label);
        add(textField1);
        add(button);
        button.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            name = textField1.getText();


        }

    }
    @Override
    public void start(){
      t = new Thread(this);
      stopFlag = false;
      t.start();
    }

    @Override
    public void stop(){
        stopFlag = true;
        t=null;
    }

    @Override
    public void run() {
        for (;;) {
            try{
                repaint();
                Thread.sleep(500);
                if(stopFlag){
                    break;
                }
            }catch (Exception e) {
            }
        }
    }
    public  void paint(Graphics g){
        g.drawString(name,60,y);
        g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));

        y=y+5;
        fontSize = fontSize+5;
    }
}
/*<applet code="Darshu.java" width=500 height=500></applet>*\
