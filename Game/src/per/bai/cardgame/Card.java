package per.bai.cardgame;

public abstract class Card {
    static int varity = 3;
    int aggressivity = 0;//攻击力
    int armorvalue = 0;//护甲值
    int curevalue = 0;
    int number = 1;//卡牌序号
    String type = null;//卡牌类型
    String name = null;
    public void Effect(Character c){
    }
}
