package per.bai.greedysnake.windows;


import per.bai.greedysnake.Gutil.GetAdmin;
import per.bai.greedysnake.Gutil.GetScore;
import per.bai.greedysnake.serviceImp.AdminServiceImp;
import per.bai.greedysnake.serviceInterface.AdminService;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AllHandler implements MouseListener {
    private GameStartWindow gsw;
    private Paintpanel pp;
    private GameWindow gw;
    private RegisterWindows rw;
    private AdmInformation aif;
    private GetScore getScore;

    GetAdmin getAdmin;

    public AllHandler(GameStartWindow gsw){
        this.gsw = gsw;
    }
    public AllHandler(Paintpanel pp,GameWindow gw){
        this.pp = pp;
        this.gw = gw;
    }
    public AllHandler(RegisterWindows rw){
        this.rw = rw;
    }
    public AllHandler(AdmInformation aif,GetScore getScore){this.aif = aif;this.getScore = getScore;}

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton jButton = (JButton)e.getSource();
        //***********注意按钮是否加上return****************
        if(e.getClickCount()==1&&"登录".equals(jButton.getText())){
            String username = gsw.nametext.getText();
            String password = gsw.pswtext.getText();
            if (null == username || "".equals(username.trim()) || null == password || "".equals(password.trim())){
                JOptionPane.showMessageDialog(gsw.gsw,"用户名和密码必填，且不能用空格代替");
                return;
            }
            getAdmin = new GetAdmin();
            getAdmin.setUsername(username);
            getAdmin.setPassword(password);
            AdminService adminService = new AdminServiceImp();
            if (adminService.login(getAdmin)){
                gsw.logindipose();
                new GameWindow(getAdmin);
            }else {
                JOptionPane.showMessageDialog(gsw.gsw,"用户名或密码错误");
            }
        }
        if (e.getClickCount()==1&&"注册".equals(jButton.getText())&&null != rw){
            String username = rw.nametext.getText();
            String password = rw.pswtext.getText();
            String password1 = rw.pswtext1.getText();
            if (!password.equals(password1)){
                JOptionPane.showMessageDialog(rw,"密码不一致");
                return;
            }
            if (null == username || "".equals(username.trim()) || null == password || "".equals(password.trim())){
                JOptionPane.showMessageDialog(rw,"用户名和密码必填，且不能用空格代替");
                return;
            }
            if (password.length() != 8){
                JOptionPane.showMessageDialog(rw,"密码必须是8位有效字符，且不能用空格代替");
                return;
            }
            GetAdmin getAdmin = new GetAdmin();
            getAdmin.setUsername(username);
            getAdmin.setPassword(password);
            AdminService adminService = new AdminServiceImp();
            if (!adminService.register(getAdmin)){
                JOptionPane.showMessageDialog(rw,"用户名重复");
                return;
            }
            JOptionPane.showMessageDialog(rw,"注册成功");
            rw.dispose();
            new GameStartWindow();
            return;
        }
        if (e.getClickCount()==1&&"注册".equals(jButton.getText())&&null != gsw){
            gsw.logindipose();
            new RegisterWindows();
            return;
        }
        if(e.getClickCount()==1&&"开始游戏".equals(jButton.getText())){
            pp.requestFocusInWindow();
            Paintpanel.start = !Paintpanel.start;
            return;
        }
        if (e.getClickCount()==1&&"智能模式".equals(jButton.getText())){
            pp.requestFocusInWindow();
            pp.Auto();
            return;
        }
        if (e.getClickCount()==1&&"排名".equals(jButton.getText())){
            pp.requestFocusInWindow();
            Paintpanel.start = false;

            new AdmInformation();
            return;
        }
        if (e.getClickCount()==1&&"返回".equals(jButton.getText())){
            aif.dispose();
        }
        if (e.getClickCount()==1&&"下一页".equals(jButton.getText())){
            if (getScore.getPageNow()>=getScore.getTotalPage()){
                JOptionPane.showMessageDialog(rw,"已经到最后一页");
                return;
            }
            getScore.setPageNow(getScore.getPageNow()+1);
            aif.update();
        }
        if (e.getClickCount()==1&&"上一页".equals(jButton.getText())){
            if (getScore.getPageNow()<=1){
                JOptionPane.showMessageDialog(rw,"已经到第一页");
                return;
            }
            getScore.setPageNow(getScore.getPageNow()-1);
            aif.update();
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
