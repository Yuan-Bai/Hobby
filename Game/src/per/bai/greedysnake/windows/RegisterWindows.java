package per.bai.greedysnake.windows;

import javax.swing.*;
import java.awt.*;

public class RegisterWindows extends JFrame {
    SpringLayout springLayout = new SpringLayout();
    JPanel jPanel = new JPanel(springLayout);

    JButton register;
    JLabel username;
    JLabel password;
    JLabel password1;
    JTextField nametext;
    JTextField pswtext;
    JTextField pswtext1;
    AllHandler ah = new AllHandler(this);
    public RegisterWindows(){
        super.setSize(600,400);
        super.setLocationRelativeTo(null);
        super.setResizable(false);
        Image image = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource("per/bai/greedysnake/toutou.jpg").getPath()).getImage();
        super.setIconImage(image);
        this.Rlayout();
        jPanel.add(register);
        jPanel.add(username);
        jPanel.add(password);
        jPanel.add(password1);
        jPanel.add(nametext);
        jPanel.add(pswtext);
        jPanel.add(pswtext1);
        super.add(jPanel);
        register.addMouseListener(ah);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    public void Rlayout(){
        register = new JButton("注册");
        username = new JLabel("用户名");
        password = new JLabel("密码");
        password1 = new JLabel("再次输入密码");
        nametext = new JTextField();
        pswtext = new JTextField();
        pswtext1 = new JTextField();

        username.setSize(new Dimension(60,25));
        nametext.setPreferredSize(new Dimension(200,25));
        password.setSize(new Dimension(60,25));
        password1.setSize(new Dimension(60,25));
        pswtext.setPreferredSize(new Dimension(200,25));
        pswtext1.setPreferredSize(new Dimension(200,25));
        register.setSize(new Dimension(60,20));

        Font font = new Font("行楷",Font.PLAIN,15);
        username.setFont(font);
        nametext.setFont(font);
        password.setFont(font);
        pswtext1.setFont(font);
        pswtext.setFont(font);
        password1.setFont(font);

        int offX = (username.getWidth() + 200 + 20)/2;
        int offY = (username.getHeight() + password.getHeight()*2 + register.getHeight() + 80)/2;
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
        //password1
        springLayout.putConstraint(SpringLayout.EAST,password1,0,SpringLayout.EAST,password);
        springLayout.putConstraint(SpringLayout.NORTH,password1,20,SpringLayout.SOUTH,password);
        //pswtext1
        springLayout.putConstraint(SpringLayout.WEST,pswtext1,20,SpringLayout.EAST,password1);
        springLayout.putConstraint(SpringLayout.NORTH,pswtext1,0,SpringLayout.NORTH,password1);
        //register
        springLayout.putConstraint(SpringLayout.WEST,register,offX - 30,SpringLayout.EAST,password1);
        springLayout.putConstraint(SpringLayout.NORTH,register,20,SpringLayout.SOUTH,password1);
    }
}
