package org.example;

import org.example.handler.SWKHandler;
import org.example.handler.SWMHandler;

import javax.swing.*;

import java.awt.*;

public class StartWindows extends JFrame {
    JButton begin;
    JTextArea textArea;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    SWMHandler swmHandler = new SWMHandler(this);
    SWKHandler swkHandler = new SWKHandler(this);

    //todo
    public StartWindows(){
        super("XiaoYuan");
    }

    public static void main(String[] args) {
        StartWindows sw = new StartWindows();
        sw.initializeWindows();
    }
    public void initializeWindows(){
        super.setSize(400,400);
        super.setLocationRelativeTo(null);
        begin = new JButton("开始");
        textArea = new JTextArea("textArea");

        begin.setSize(new Dimension(50,80));
        textArea.setSize(new Dimension(250,300));

        springLayout.putConstraint(SpringLayout.WEST,begin,0,SpringLayout.WEST,jPanel);
        springLayout.putConstraint(SpringLayout.NORTH,begin,0,SpringLayout.NORTH,jPanel);

        springLayout.putConstraint(SpringLayout.WEST,textArea,0,SpringLayout.WEST,begin);
        springLayout.putConstraint(SpringLayout.NORTH,textArea,50,SpringLayout.SOUTH,begin);

        begin.addMouseListener(swmHandler);
        jPanel.add(begin);
        jPanel.add(textArea);
        jPanel.addKeyListener(swkHandler);
        super.add(jPanel);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public void endRobot(){
        swmHandler.endTread();
    }

}
