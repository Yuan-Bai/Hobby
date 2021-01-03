package per.bai.greedysnake.function;

public class SnakeNode {
    public static int length = 3;
    private int x;
    private int y;
    //0:向上
    //1:向右
    //2:向下
    //3:向左
    private int direction;
    public SnakeNode(int x,int y,int direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

}
