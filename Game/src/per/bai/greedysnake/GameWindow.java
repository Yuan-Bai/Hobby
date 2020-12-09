package per.bai.greedysnake;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static java.awt.Image.SCALE_DEFAULT;
import static java.awt.Image.SCALE_FAST;

public class GameWindow {
    JFrame gw;
    int width = 902;
    int height = 602;


    public GameWindow(){
        gw = new JFrame("贪吃蛇");
        gw.setSize(width,height);
        Image image = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/toutou.jpg").getPath()).getImage();
        gw.setIconImage(image);
        gw.setLocationRelativeTo(null);
        Paintpanel pp = new Paintpanel();
        gw.add(pp);

        //todo

        gw.setResizable(false);
        gw.setVisible(true);
        pp.requestFocusInWindow();
        gw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

class Paintpanel extends JPanel{
    static boolean start = false;
    boolean gameover = false;

    //bug不知道如何解决故用计数法解决
    int count = 0;
    JButton begin;
    Paintpanel paintpanel = this;
    //Image unit = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/Sprite-0001.png").getPath()).getImage();
    ImageIcon unit = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/Sprite-0001.png").getPath());
    public Paintpanel(){
        begin = new JButton("开始游戏");
        this.setLayout(null);
        this.add(begin);
        begin.setBounds(750,30,90,30);
        arraySnake.add(0,new SnakeNode(15,13,1));
        GwHandler gwHandler = new GwHandler(this,arraySnake.get(0));
        arraySnake.add(1,new SnakeNode(14,13,1));
        arraySnake.add(2,new SnakeNode(13,13,1));
        GswHandler gswHandler = new GswHandler(this);
        this.addKeyListener(gwHandler);
        begin.addMouseListener(gswHandler);

        //todo

    }

    ArrayList<SnakeNode> arraySnake = new ArrayList<>();
    Food food = new Food(arraySnake);
    public void paintComponent(Graphics g){
        g.fillRect(0,0,902,602);
        //蛇的初始位置

        super.paintComponent(g);
        this.setBackground(Color.WHITE);
        for(int i = 0;i <= 27;i++)
        {
            g.setColor(Color.black);
            g.drawLine(50,10+i*20,710,10+i*20);
        }
        for(int i = 0;i <= 33;i++)
        {
            g.setColor(Color.black);
            g.drawLine(50+i*20,10,50+i*20,550);
        }

        unit.setImage(unit.getImage().getScaledInstance(20,20,SCALE_DEFAULT));
        if(count>=1){
            this.Eat();
            unit.paintIcon(paintpanel,g,50+20*food.getX(),10+20*food.getY());
            for(int i = 0;i < SnakeNode.length;i++) {
                unit.paintIcon(paintpanel,g,50 + 20*arraySnake.get(i).getX(),10 + 20*arraySnake.get(i).getY());
            }
            if (count==1) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            while (true) {
                                if (paintpanel.start) {
                                    for (int j = SnakeNode.length - 1; j > 0; j--) {
                                        arraySnake.get(j).setX(arraySnake.get(j - 1).getX());
                                        arraySnake.get(j).setY(arraySnake.get(j - 1).getY());
                                    }
                                    switch (arraySnake.get(0).getDirection()) {
                                        case 0:
                                            arraySnake.get(0).setY(arraySnake.get(0).getY() - 1);
                                            break;
                                        case 1:
                                            arraySnake.get(0).setX(arraySnake.get(0).getX() + 1);
                                            break;
                                        case 2:
                                            arraySnake.get(0).setY(arraySnake.get(0).getY() + 1);
                                            break;
                                        case 3:
                                            arraySnake.get(0).setX(arraySnake.get(0).getX() - 1);
                                            break;
                                    }
                                    if (arraySnake.get(0).getX() > 32) {
                                        arraySnake.get(0).setX(0);
                                    } else if (arraySnake.get(0).getX() < 0) {
                                        arraySnake.get(0).setX(32);
                                    }
                                    if (arraySnake.get(0).getY() > 26) {
                                        arraySnake.get(0).setY(0);
                                    } else if (arraySnake.get(0).getY() < 0) {
                                        arraySnake.get(0).setY(26);
                                    }
                                    repaint();
                                    try {
                                        Thread.sleep(175);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    HitSelf();
                                    if (gameover)break;
                                } else {

                                    //非常的奇怪，必须有以下代码才可以进入上面的循环
                                    try {
                                        Thread.sleep(1);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                            //todo
                            start = false;
                        }
                    }
                }).start();
            }
        }
        count++;
    }

    public void Eat(){
        if (arraySnake.get(0).getY() == food.getY() && arraySnake.get(0).getX() == food.getX()){
            food.CreateFood();
            snakeAdd();
        }
    }
    public void HitSelf(){
        if (arraySnake.get(0).getY() == food.getY() && arraySnake.get(0).getX() == food.getX()){

        }
        for (int k = 1;k<arraySnake.size()-1;k++){
            if (arraySnake.get(k).getX() == arraySnake.get(0).getX() && arraySnake.get(k).getY() == arraySnake.get(0).getY()){
                gameover = true;
                break;
            }
        }
    }

    public void snakeAdd(){
        SnakeNode snakeNode = new SnakeNode(arraySnake.get(SnakeNode.length-1).getX(),arraySnake.get(SnakeNode.length-1).getY(),1);
        arraySnake.add(snakeNode);
        SnakeNode.length++;
    }
}