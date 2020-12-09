package per.bai.greedysnake;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GwHandler implements KeyListener{
    private Paintpanel pp;
    private SnakeNode snakeNode;
    public GwHandler(Paintpanel pp,SnakeNode snakeNode){
        this.pp = pp;
        this.snakeNode = snakeNode;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        pp.requestFocusInWindow();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pp.requestFocusInWindow();
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            Paintpanel.start = !Paintpanel.start;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT&&snakeNode.getDirection()!=1){
            snakeNode.setDirection(3);
        }else if (e.getKeyCode() == KeyEvent.VK_UP&&snakeNode.getDirection()!=2){
            snakeNode.setDirection(0);
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN&&snakeNode.getDirection()!=0){
            snakeNode.setDirection(2);
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT&&snakeNode.getDirection()!=3){
            snakeNode.setDirection(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pp.requestFocusInWindow();

    }
}
