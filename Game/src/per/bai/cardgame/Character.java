package per.bai.cardgame;

public interface Character {
    //人物属性。
    String name = null;//名字
    boolean gender = true;//性别
    int hp = 10;//血量
    int speed = 10;//速度
    int aggressivity = 0;//攻击力
    int attackcard = 0;
    int armorcard = 0;


    //人物动作。
    public void action(Monster m,int w);
    public void printinfor ();
    public void upgrade (int exp);
    public void privarity ();
    public void Card ();
    public void Cardsort ();
    public void remove (int i);
    public void initialization ();


    public String getName();
    public int getCardqtity();
    public int getCurecard();
    public int getAggressivity();
    public int getAttackcard();
    public int getArmorcard();
    public int getExp();
    public int getArmor();
    public int getHp();
    public int getHp0();
    public int getSpeed();
    public Card[] getCardArray ();

    public void setName(String name);
    public void setCardqtity(int i);
    public void setCurecard(int i);
    public void setAggressivity(int i);
    public void setAttackcard(int i);
    public void setArmorcard(int i);
    public void setExp(int i);
    public void setArmor(int i);
    public void setHp(int i);
    public void setHp0(int i);
    public void setSpeed(int i);

    //public void Action(per.bai.cardgame.Card a,per.bai.cardgame.Slimer s);
}
