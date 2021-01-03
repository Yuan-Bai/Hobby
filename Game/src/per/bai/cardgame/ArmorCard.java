package per.bai.cardgame;

public class ArmorCard extends Card{

    int armorvalue = 4;//护甲值
    static int number = 1;//卡牌序号
    String type = "物理类";//卡牌类型
    String name = "护甲牌";//卡牌名称
    @Override
    public void Effect(Character c) {
    }
}
