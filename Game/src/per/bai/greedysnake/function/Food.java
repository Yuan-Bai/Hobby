package per.bai.greedysnake.function;

import java.util.List;
import java.util.Random;

public class Food {
    List<SnakeNode> arraySnake;
    private int x;
    private int y;
    Random randomx = new Random();
    Random randomy = new Random();
    public Food(List<SnakeNode> arraySnake){
        this.arraySnake = arraySnake;
        this.CreateFood();
    }
    public boolean Blank(){
        for (SnakeNode snakeNode : arraySnake){
            if (snakeNode.getX() == x && snakeNode.getY() == y)return false;
        }
        return true;
    }
    public void CreateFood(){
        do {
            this.x = randomx.nextInt(32);
            this.y = randomy.nextInt(26);
        }while (!Blank());
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
