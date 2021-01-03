package per.bai.greedysnake.windows;

import per.bai.greedysnake.Gutil.GetAdmin;
import per.bai.greedysnake.function.AutoSnake;
import per.bai.greedysnake.function.Food;
import per.bai.greedysnake.function.SnakeNode;
import per.bai.greedysnake.serviceImp.AdminServiceImp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static java.awt.Image.SCALE_DEFAULT;

public class GameWindow {
    JFrame gw;
    int width = 902;
    int height = 602;


    public GameWindow(GetAdmin getAdmin){
        gw = new JFrame("贪吃蛇");
        gw.setSize(width,height);
        Image image = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/toutou.jpg").getPath()).getImage();
        gw.setIconImage(image);
        gw.setLocationRelativeTo(null);
        Paintpanel pp = new Paintpanel(getAdmin,this);
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

    AdminServiceImp asi = new AdminServiceImp();
    GetAdmin getAdmin;
    GameWindow gw;

    //bug不知道如何解决故用计数法解决
    int count = 0;

    //
    int count1 = 0;

    JButton begin;
    JTextArea explain;
    JTextArea score;
    JButton auto;
    JButton rank;

    Paintpanel paintpanel = this;
    //Image unit = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/Sprite-0001.png").getPath()).getImage();
    ImageIcon unit = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/Sprite-0001.png").getPath());

    public Paintpanel(GetAdmin getAdmin,GameWindow gw){
        this.getAdmin = getAdmin;
        this.gw = gw;
        explain = new JTextArea("按空格开始游戏\n或暂停游戏");
        begin = new JButton("开始游戏");
        auto = new JButton("智能模式");
        score = new JTextArea("得分:" + SnakeNode.length);
        rank = new JButton("排名");

        this.setLayout(null);
        this.add(begin);
        this.add(explain);
        this.add(auto);
        this.add(rank);
        explain.setBounds(730,80,100,50);
        begin.setBounds(750,30,90,30);
        auto.setBounds(750,180,90,30);
        rank.setBounds(750,250,90,30);

        //蛇初始化
        initialize();

        GwHandler gwHandler = new GwHandler(this,arraySnake.get(0));
        AllHandler gswHandler = new AllHandler(this,gw);
        this.addKeyListener(gwHandler);
        begin.addMouseListener(gswHandler);
        auto.addMouseListener(gswHandler);
        rank.addMouseListener(gswHandler);
        //todo

    }

    //test
    StringBuffer stringBuffer = new StringBuffer();


    ArrayList<SnakeNode> arraySnake = new ArrayList<>();
    //
    Food food = new Food(arraySnake);
    //
    AutoSnake as = null;
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

        score = new JTextArea("得分:" + SnakeNode.length);
        this.add(score);
        score.setBounds(730,140,100,30);

        unit.setImage(unit.getImage().getScaledInstance(20,20,SCALE_DEFAULT));
        if(count>=1){
            //处理count无限增加的问题
            //判断吃掉食物了?
            this.Eat();
            //打印食物
            unit.paintIcon(paintpanel,g,50+20*food.getX(),10+20*food.getY());
            for(int i = 0;i < SnakeNode.length;i++) {
                unit.paintIcon(paintpanel,g,50 + 20*arraySnake.get(i).getX(),10 + 20*arraySnake.get(i).getY());
            }
            if (count==1) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while (true) {
                            while (true) {
                                if (paintpanel.start) {
                                    if (paintpanel.jTextArea != null)paintpanel.remove(paintpanel.jTextArea);
                                    if (count1 == 1)repaint();
                                    count1 = 0;
                                    for (int j = SnakeNode.length - 1; j > 0; j--) {
                                        arraySnake.get(j).setX(arraySnake.get(j - 1).getX());
                                        arraySnake.get(j).setY(arraySnake.get(j - 1).getY());
                                    }
                                    if (as != null)as.GetNode();
                                    stringBuffer.append(arraySnake.get(0).getDirection());
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
                                        Thread.sleep(100);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }

                                    if (HitSelf())break;
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
                            System.out.println(stringBuffer);
                            asi.storage(getAdmin);
                            start = false;
                            initialize();
                            count1 = 1;
                        }
                    }
                });
                thread.start();
            }
        }
        count++;
    }

    public void initialize(){
        if (arraySnake.size() == 0){
            arraySnake.add(0,new SnakeNode(15,13,1));
        }else {
            for (int k = 1; k < SnakeNode.length; k++) {
                arraySnake.remove(1);
            }
            SnakeNode.length = 3;
            arraySnake.get(0).setX(15);
            arraySnake.get(0).setY(13);
            arraySnake.get(0).setDirection(1);
            GwHandler.x = -1;
            GwHandler.y = -1;
        }
        arraySnake.add(1, new SnakeNode(14, 13, 1));
        arraySnake.add(2, new SnakeNode(13, 13, 1));
    }

    public void Eat(){
        if (arraySnake.get(0).getY() == food.getY() && arraySnake.get(0).getX() == food.getX()){
            AutoSnake.b = true;
            AutoSnake.count = 0;
            food.CreateFood();
            snakeAdd();
        }
    }

    JTextArea jTextArea;
    public boolean HitSelf(){
        for (int k = 1;k<arraySnake.size()-1;k++){
            if (arraySnake.get(k).getX() == arraySnake.get(0).getX() && arraySnake.get(k).getY() == arraySnake.get(0).getY()){

                jTextArea = new JTextArea("游戏结束");
                paintpanel.add(jTextArea);
                jTextArea.setFont(new java.awt.Font("Dialog", 1, 30));
                jTextArea.setBounds(315,240,130,35);
                return true;
            }
        }
        return false;
    }

    public void snakeAdd(){
        SnakeNode snakeNode = new SnakeNode(arraySnake.get(SnakeNode.length-1).getX(),arraySnake.get(SnakeNode.length-1).getY(),1);
        arraySnake.add(snakeNode);
        SnakeNode.length++;
    }

    int count2 = 0;
    public void Auto(){
        if (count2==0){
            as = new AutoSnake(arraySnake,food);
            count2 = 1;
        }else {
            as = null;
            count2 = 0;
        }
    }
}