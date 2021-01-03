package per.bai.greedysnake.function;

import per.bai.greedysnake.windows.GameWindow;

import java.lang.reflect.Array;
import java.util.List;

public class AutoSnake {
    List<SnakeNode> arraySnake;

    public static boolean b = true;

    //目标坐标
    int x0;
    int y0;

    //
    int x1;
    int y1;

    //节点坐标
    int x;
    int y;
    public static int count = 0;
    int id = -1;

    Food food;
    public AutoSnake(List<SnakeNode> arraySnake,Food food){
        this.arraySnake = arraySnake;
        this.food = food;
    }

    //获取蛇头与食物最短距离转向点
    public void GetNode(){
        if (!avoid())Action3();
        if (count == 0){
            this.x0 = food.getX();
            this.y0 = food.getY();
            x1 = this.arraySnake.get(0).getX();
            y1 = this.arraySnake.get(0).getY();
        }
        if (AccessibleSX()&&b){
            x = x1;
            y = y0;
            if (count == 0){
                Action1();
                count++;
            }
            if (arraySnake.get(0).getX()==x&&arraySnake.get(0).getY()==y)Action2();
            return;
        }
        if (AccessibleSY()){
            b=false;
            x = x0;
            y = y1;
            if (count == 0){
                Action1();
                count++;
            }
            if (arraySnake.get(0).getX()==x&&arraySnake.get(0).getY()==y){
                Action2();
            }
            return;
        }
    }


    public boolean AccessibleSX(){
        for (int i = 0;i < arraySnake.size() - 2;i++){
            if (y0 > arraySnake.get(0).getY()) {
                if (arraySnake.get(0).getX() == arraySnake.get(i + 1).getX() && arraySnake.get(i + 1).getY() <= y0 && arraySnake.get(i + 1).getY() > arraySnake.get(0).getY()){
                    return false;
                }
            }else if (y0 < arraySnake.get(0).getY()){
                if (arraySnake.get(0).getX() == arraySnake.get(i + 1).getX() && arraySnake.get(i + 1).getY() >= y0 && arraySnake.get(i + 1).getY() < arraySnake.get(0).getY()){
                    return false;
                }
            }
        }
        return AccessibleFY();
    }

    public boolean AccessibleSY(){
        for (int i = 0;i < arraySnake.size() - 2;i++){
            if (x0 > arraySnake.get(0).getX()){
                if (arraySnake.get(0).getY() == arraySnake.get(i + 1).getY() && arraySnake.get(i + 1).getX() <= x0 && arraySnake.get(i + 1).getX() > arraySnake.get(0).getX()){
                    return false;
                }
            }else if (x0 < arraySnake.get(0).getX()){
                if (arraySnake.get(0).getY() == arraySnake.get(i + 1).getY() && arraySnake.get(i + 1).getX() >= x0 && arraySnake.get(i + 1).getX() < arraySnake.get(0).getX()){
                    return false;
                }
            }
        }
        return AccessibleFX();
    }

    public boolean AccessibleFY(){
        for (int i = 0;i < arraySnake.size() - 2;i++){
            if (x0 > arraySnake.get(0).getX()) {
                if (y0 == arraySnake.get(i + 1).getY()&&arraySnake.get(i+1).getX() < x0&&arraySnake.get(i+1).getX() > arraySnake.get(0).getX()){
                    return false;
                }
            }else if (x0 < arraySnake.get(0).getX()){
                if (y0 == arraySnake.get(i + 1).getY()&&arraySnake.get(i+1).getX() > x0&&arraySnake.get(i+1).getX() < arraySnake.get(0).getX()){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean AccessibleFX(){
        for (int i = 0;i < arraySnake.size() - 2;i++){
            if (y0 > arraySnake.get(0).getY()) {
                if (x0 == arraySnake.get(i + 1).getX()&&arraySnake.get(i+1).getY() < y0&&arraySnake.get(i+1).getY() > arraySnake.get(0).getY()){
                    return false;
                }
            }else if (y0 < arraySnake.get(0).getY()){
                if (x0 == arraySnake.get(i + 1).getX()&&arraySnake.get(i+1).getY() > y0&&arraySnake.get(i+1).getY() < arraySnake.get(0).getY()){
                    return false;
                }
            }
        }
        return true;
    }

    public void Action1(){
        if (x > arraySnake.get(0).getX()){
            arraySnake.get(0).setDirection(1);
        }else if (x < arraySnake.get(0).getX()){
            arraySnake.get(0).setDirection(3);
        }else if (y > arraySnake.get(0).getY()){
            arraySnake.get(0).setDirection(2);
        }else if (y < arraySnake.get(0).getY()){
            arraySnake.get(0).setDirection(0);
        }
    }

    public void Action2(){
        if (food.getX() > arraySnake.get(0).getX()){
            arraySnake.get(0).setDirection(1);
        }else if (food.getX() < arraySnake.get(0).getX()){
            arraySnake.get(0).setDirection(3);
        }else if (food.getY() > arraySnake.get(0).getY()){
            arraySnake.get(0).setDirection(2);
        }else if (food.getY() < arraySnake.get(0).getY()){
            arraySnake.get(0).setDirection(0);
        }
    }

    int[] t = new int[2];
    int temp;
    int j = 0;
    int k = 0;
    public void Action3(){
        if (arraySnake.get(0).getDirection()==1||arraySnake.get(0).getDirection()==3){
            for(int i = 2;i < arraySnake.size();i++){
                if (arraySnake.get(i).getX()==arraySnake.get(0).getX()){
                    temp = absoluteValue(arraySnake.get(i).getY(),arraySnake.get(0).getY());
                    if (j<2){
                        t[0] = temp;
                        this.ascSort();
                        if (i > id&&temp!=1)id = i;
                        if (j==0)id = i;
                        j++;
                    }else {
                        if (temp>=t[1]&&t[0]!=1&&pn[0]!=pn[1])continue;
                        if (i > id&&temp!=1&&pn[2]!=pn[0])
                        {
                            id = i;
                            t[1]=temp;
                            this.ascSort();
                            pn[0]=!pn[0];
                        }
                    }
                }
            }
        }else {
            for(int i = 2;i < arraySnake.size();i++){
                if (arraySnake.get(i).getY()==arraySnake.get(0).getY()){
                    temp = absoluteValue(arraySnake.get(i).getX(),arraySnake.get(0).getX());
                    if (j<2){
                        t[0] = temp;
                        this.ascSort();
                        if (i > id&&temp!=1)id = i;
                        if (j==0)id = i;
                        j++;
                    }else {
                        if (temp>=t[1]&&t[0]!=1&&pn[0]!=pn[1])continue;
                        if (i > id&&temp!=1&&pn[2]!=pn[0])
                        {
                            id = i;
                            t[1]=temp;
                            this.ascSort();
                            pn[0]=!pn[0];
                        }
                    }
                }
            }
        }
        if (j>=2&&pn[0]!=pn[1]){
            if (arraySnake.get(0).getDirection()==1||arraySnake.get(0).getDirection()==3) {
                if (arraySnake.get(id).getY()>arraySnake.get(0).getY())arraySnake.get(0).setDirection(2);
                else arraySnake.get(0).setDirection(0);
            }else {
                if (arraySnake.get(id).getX()>arraySnake.get(0).getX())arraySnake.get(0).setDirection(1);
                else arraySnake.get(0).setDirection(3);
            }
        }else if (j==1||pn[0]==pn[1]){
            if (arraySnake.get(0).getDirection()==1||arraySnake.get(0).getDirection()==3) {
                if (arraySnake.get(id).getY()>arraySnake.get(0).getY())arraySnake.get(0).setDirection(0);
                else arraySnake.get(0).setDirection(2);
            }else {
                if (arraySnake.get(id).getX()>arraySnake.get(0).getX())arraySnake.get(0).setDirection(3);
                else arraySnake.get(0).setDirection(1);
            }
        }else {
            if (arraySnake.get(0).getDirection()==1||arraySnake.get(0).getDirection()==3) {
                if (food.getY()>arraySnake.get(0).getY())arraySnake.get(0).setDirection(2);
                else arraySnake.get(0).setDirection(0);
            }else {
                if (food.getX()>arraySnake.get(0).getX())arraySnake.get(0).setDirection(1);
                else arraySnake.get(0).setDirection(3);
            }
        }


        j = 0;
        t[0] = 0;
        t[1] = 0;
        id = 0;
    }



    int ax;
    int ay;
    public boolean avoid(){
        ax = arraySnake.get(0).getX();
        ay = arraySnake.get(0).getY();
        if (arraySnake.get(0).getDirection()==0) {
            ay--;
        }else if (arraySnake.get(0).getDirection()==1){
            ax++;
        }else if (arraySnake.get(0).getDirection()==2){
            ay++;
        }else if (arraySnake.get(0).getDirection()==3){
            ax--;
        }
        if (ax==-1)ax=32;
        if (ax==33)ax=0;
        if (ay==-1)ay=26;
        if (ay==27)ay=0;
        return ergodic();
    }


    public boolean ergodic(){
        for (int i = 2; i < arraySnake.size(); i++) {
            if (arraySnake.get(i).getX()==ax&&arraySnake.get(i).getY()==ay)return false;
        }
        return true;
    }

    private boolean[] pn = new boolean[3];
    public int absoluteValue(int a,int b){
        if (a>b){
            pn[j] = true;
            return a-b;
        }
        else{
            pn[j] = false;
            return b-a;
        }
    }

    public void ascSort(){
        int atemp;
        if (t[0]>t[1]){
            atemp=t[0];
            t[0]=t[1];
            t[1]=atemp;
        }
    }
}
