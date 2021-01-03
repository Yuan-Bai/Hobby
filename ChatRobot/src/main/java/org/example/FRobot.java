package org.example;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import org.example.Rcontectsql.ExpSource;
import org.example.Robbotil.GetTextfromQQ;

import javax.swing.*;

import static org.example.Robbotil.GetTextfromQQ.*;


public class FRobot
{
    StartWindows sw;
    ExpSource expSource = new ExpSource();

    public FRobot(StartWindows sw){
        this.sw = sw;
        try {
            this.getWindows();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String WinName = "永远到不齐的饥荒群";

    public void getWindows() throws Exception {
        WinDef.HWND QQhwnd = User32.INSTANCE.FindWindow("TXGuiFoundation", WinName);
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow("SunAwtFrame","XiaoYuan");
        if (QQhwnd == null){
            JOptionPane.showMessageDialog(sw,WinName + "未打开");
            return;
        }

        String answer = "0";
        String precontent = null;
        String content = "";
        WinDef.RECT rect = new WinDef.RECT();
        WinDef.RECT rect0 = new WinDef.RECT();
        org.example.User32.INSTANCE.GetWindowRect(QQhwnd,rect);
        org.example.User32.INSTANCE.GetWindowRect(hwnd,rect0);

        int i = 0;
        int c = 0;
        int time = 2000;
        setSysClipboardText(null);
        org.example.User32.INSTANCE.SetCursorPos(rect.left + 140,rect.top + 400);
        org.example.User32.INSTANCE.mouse_event(0x0002,0,0,0,0);
        org.example.User32.INSTANCE.mouse_event(0x0004,0,0,0,0);
        while (i<100){
            i++;
            if (i!=1){
                org.example.User32.INSTANCE.SetCursorPos(rect.left + 140,rect.top + 400);
                org.example.User32.INSTANCE.mouse_event(0x0002,0,0,0,0);
                org.example.User32.INSTANCE.mouse_event(0x0004,0,0,0,0);
            }
            Thread.sleep(500);
            org.example.User32.INSTANCE.mouse_event(0x0008,0,0,0,0);
            org.example.User32.INSTANCE.mouse_event(0x0010,0,0,0,0);
            Thread.sleep(75);
            org.example.User32.INSTANCE.keybd_event(67,0,0,0);
            Thread.sleep(50);
            org.example.User32.INSTANCE.keybd_event(67,0,0x0002,0);
            org.example.User32.INSTANCE.mouse_event(0x0002,0,0,0,0);
            org.example.User32.INSTANCE.mouse_event(0x0004,0,0,0,0);
            content = getSysClipboardText();
            if (content == null){
                c++;
                if (c==300){
                    sendMessage("小圆进入休眠状态,下次反应会比较慢");
                    time = 5000;
                }
                Thread.sleep(time);
                continue;
            }
            int length = content.length();
            content = content.substring(0,length-1);
            if (content.equals(precontent)){
                c++;
                if (c==300){
                    sendMessage("小圆进入休眠状态,下次反应会比较慢");
                    time = 5000;
                }
                Thread.sleep(time);
                continue;
            }
            if (c>=300){
                time=2000;
                c=0;
            }
            if (length >=12&&"@小圆 \\insert".equals(content.substring(0,11))){
                int b1 = content.indexOf("receive",11) + 8;
                int e1 = content.indexOf("\n",b1);
                String re = "@小圆 " + content.substring(b1,e1);
                String an = content.substring(e1+8);
                insert(re,an);
            }
            precontent = content;
            if ((answer = expSource.dialog(content)) != null){
                sendMessage(answer);
                if ("@小圆 \\stop".equals(content)){
                    break;
                }
            }
        }
    }

    public void insert(String receive,String answer) throws InterruptedException {
        expSource.insertDialog(receive,answer);
        sendMessage("添加成功");
    }

    public void sendMessage(String message) throws InterruptedException {
        setSysClipboardText(message);
        org.example.User32.INSTANCE.keybd_event(17,0,0,0);
        org.example.User32.INSTANCE.keybd_event(86,0,0,0);
        org.example.User32.INSTANCE.keybd_event(17,0,0x0002,0);
        org.example.User32.INSTANCE.keybd_event(86,0,0x0002,0);
        org.example.User32.INSTANCE.keybd_event(13,0,0,0);
        org.example.User32.INSTANCE.keybd_event(13,0,0x0002,0);
        Thread.sleep(1000);
    }
}


