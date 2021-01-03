package org.example.handler;

import org.example.FRobot;
import org.example.StartWindows;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SWMHandler implements MouseListener {
    StartWindows sw;
    Thread thread;

    public SWMHandler(StartWindows sw){this.sw = sw;}

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jButton = (JButton)e.getSource();
        if (e.getClickCount()==1&&"开始".equals(jButton.getText())){
            sw.requestFocusInWindow();
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    new FRobot(sw);
                }
            });
            thread.start();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void endTread(){
        thread.stop();
    }
}
