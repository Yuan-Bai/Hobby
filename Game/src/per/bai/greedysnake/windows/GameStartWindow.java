package per.bai.greedysnake.windows;

import javax.swing.*;
import java.awt.*;

public class GameStartWindow {
    JFrame gsw;
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);
    private int wWidth = 600;
    private int wHeight = 400;
    private int bWidth = 30;
    private int bHeight = 20;

    //
    JButton begin;
    JButton login;
    JButton register;
    JLabel gamename;
    JLabel username;
    JLabel password;
    JTextField nametext;
    JTextField pswtext;
    //
    AllHandler ah = new AllHandler(this);

    public GameStartWindow(){
        //创建窗口并给出标题名字
        gsw = new JFrame("贪吃蛇");


        //设置大小
        gsw.setSize(wWidth,wHeight);

        //设置居中
        gsw.setLocationRelativeTo(null);
        //设置居中的另一种方法
        //Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        //int offX = (dimension.width - width) / 2;
        //int offY = (dimension.height - height) / 2;
        //gsw.setLocation(offX,offY);

        //设置窗口大小不可变
        gsw.setResizable(false);

        //设置窗口图片
        Image image = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/toutou.jpg").getPath()).getImage();
        gsw.setIconImage(image);

        //设置按钮
        Container container = gsw.getContentPane();

        begin = new JButton("开始");
        login = new JButton("登录");
        register = new JButton("注册");
        gamename = new JLabel("贪吃蛇小游戏",JLabel.CENTER);
        username = new JLabel("用户名");
        nametext = new JTextField();
        password = new JLabel("密码");
        pswtext = new JTextField();


        begin.setSize(bWidth,bHeight);
        username.setSize(new Dimension(60,25));
        nametext.setPreferredSize(new Dimension(200,25));
        password.setSize(new Dimension(60,25));
        pswtext.setPreferredSize(new Dimension(200,25));
        login.setSize(new Dimension(60,20));
        register.setSize(new Dimension(60,20));

        Font font = new Font("行楷",Font.PLAIN,15);
        gamename.setFont(new Font("行楷",Font.PLAIN,30));
        username.setFont(font);
        nametext.setFont(font);
        password.setFont(font);
        pswtext.setFont(font);

        //jPanel.add(begin);
        //jPanel.add(login);
        jPanel.add(username);
        jPanel.add(nametext);
        jPanel.add(password);
        jPanel.add(pswtext);
        jPanel.add(login);
        jPanel.add(register);
        //jPanel.add();
        container.add(gamename,BorderLayout.NORTH);
        container.add(jPanel);

        //
        login.addMouseListener(ah);
        begin.addMouseListener(ah);
        register.addMouseListener(ah);

        //界面布局
        //200为nametext宽度。
        int offX = (username.getWidth() + 200 + 20)/2;
        int offY = (username.getHeight() + password.getHeight() + login.getHeight() + 80)/2;
        springLayout.putConstraint(SpringLayout.WEST,username,-offX,SpringLayout.HORIZONTAL_CENTER,jPanel);
        springLayout.putConstraint(SpringLayout.NORTH,username,-offY,SpringLayout.VERTICAL_CENTER,jPanel);
        //nametext
        springLayout.putConstraint(SpringLayout.WEST,nametext,20,SpringLayout.EAST,username);
        springLayout.putConstraint(SpringLayout.NORTH,nametext,0,SpringLayout.NORTH,username);
        //password
        springLayout.putConstraint(SpringLayout.EAST,password,0,SpringLayout.EAST,username);
        springLayout.putConstraint(SpringLayout.NORTH,password,20,SpringLayout.SOUTH,username);
        //pswtext
        springLayout.putConstraint(SpringLayout.WEST,pswtext,20,SpringLayout.EAST,password);
        springLayout.putConstraint(SpringLayout.NORTH,pswtext,0,SpringLayout.NORTH,password);
        //login
        springLayout.putConstraint(SpringLayout.WEST,login,-offX + 30,SpringLayout.HORIZONTAL_CENTER,jPanel);
        springLayout.putConstraint(SpringLayout.NORTH,login,-offY + 80,SpringLayout.VERTICAL_CENTER,jPanel);
        //register
        springLayout.putConstraint(SpringLayout.WEST,register,offX - 30,SpringLayout.EAST,login);
        springLayout.putConstraint(SpringLayout.NORTH,register,0,SpringLayout.NORTH,login);


        //设置窗口可见
        gsw.setVisible(true);

        //设置关闭窗口后退出
        gsw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GameStartWindow();
    }
    public void logindipose(){
        gsw.dispose();
    }
}
