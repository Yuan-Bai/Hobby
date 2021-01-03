package org.example.handler;

import org.example.StartWindows;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SWKHandler implements KeyListener {
    StartWindows sw;

    public SWKHandler(StartWindows sw){
        this.sw = sw;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        sw.requestFocusInWindow();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        sw.requestFocusInWindow();
        if (e.getKeyCode() == KeyEvent.VK_SPACE)sw.endRobot();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        sw.requestFocusInWindow();
    }
}
