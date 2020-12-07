package per.bai.greedysnake;

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
    JLabel name;

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
        name = new JLabel("贪吃蛇小游戏",JLabel.CENTER);

        name.setFont(new Font("行楷",Font.PLAIN,30));
        begin.setSize(bWidth,bHeight);

        jPanel.add(begin);
        container.add(name,BorderLayout.NORTH);
        container.add(jPanel);

        //界面布局
        SpringLayout.Constraints nameC = springLayout.getConstraints(begin);
        nameC.setX(Spring.constant((wWidth-bWidth)/2-15));
        nameC.setY(Spring.constant((wHeight-bHeight)/2-60));

        //设置窗口可见
        gsw.setVisible(true);

        //设置关闭窗口后退出
        gsw.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new GameStartWindow();
    }
}
