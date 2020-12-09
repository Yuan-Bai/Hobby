package per.bai.greedysnake;


import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GswHandler implements MouseListener {
    private GameStartWindow gsw;
    private Paintpanel pp;

    public GswHandler(GameStartWindow gsw){
        this.gsw = gsw;
    }
    public GswHandler(Paintpanel pp){
        this.pp = pp;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jButton = (JButton)e.getSource();
        if(e.getClickCount()==1&&"开始".equals(jButton.getText())){
            gsw.logindipose();
            new GameWindow();
        }
        if(e.getClickCount()==1&&"开始游戏".equals(jButton.getText())){
            pp.requestFocusInWindow();
            Paintpanel.start = !Paintpanel.start;
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
}
