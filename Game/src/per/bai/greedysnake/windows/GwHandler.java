package per.bai.greedysnake.windows;

import per.bai.greedysnake.function.SnakeNode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GwHandler implements KeyListener{
    public static int x;
    public static int y;
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
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT&&snakeNode.getDirection()!=1 && (snakeNode.getX() != x || snakeNode.getY() != y)){
            snakeNode.setDirection(3);
            x = snakeNode.getX();
            y = snakeNode.getY();
        }else if (e.getKeyCode() == KeyEvent.VK_UP&&snakeNode.getDirection()!=2 && (snakeNode.getX() != x || snakeNode.getY() != y)){
            snakeNode.setDirection(0);
            x = snakeNode.getX();
            y = snakeNode.getY();
        }else if (e.getKeyCode() == KeyEvent.VK_DOWN&&snakeNode.getDirection()!=0 && (snakeNode.getX() != x || snakeNode.getY() != y)){
            snakeNode.setDirection(2);
            x = snakeNode.getX();
            y = snakeNode.getY();
        }else if (e.getKeyCode() == KeyEvent.VK_RIGHT&&snakeNode.getDirection()!=3 && (snakeNode.getX() != x || snakeNode.getY() != y)){
            snakeNode.setDirection(1);
            x = snakeNode.getX();
            y = snakeNode.getY();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pp.requestFocusInWindow();
    }

}
