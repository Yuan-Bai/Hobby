public abstract class Monster {

    static int varity = 2;
    int aggressivity;//怪物攻击力
    int hp0;
    int hp;//怪物血量
    int speed;//怪物速度
    String name;//怪物名字
    int cardqtity;//怪物卡牌初始携带量
    int attackcard;
    int curecard;
    int armorcard;
    int armor;
    int exp;

    public abstract void action(Character c);
    public abstract void printinfor ();
    public abstract void privarity();
    public abstract void Card();
    public abstract void Cardsort();
    public abstract void remove(int i);
    public abstract void initialization();
    public abstract String getName();
    public abstract int getCardqtity();
    public abstract int getCurecard();
    public abstract int getAggressivity();
    public abstract int getAttackcard();
    public abstract int getArmorcard();
    public abstract int getExp();
    public abstract int getArmor();
    public abstract int getHp();
    public abstract int getHp0();
    public abstract int getSpeed();

    public abstract void setName(String name);
    public abstract void setCardqtity(int i);
    public abstract void setCurecard(int i);
    public abstract void setAggressivity(int i);
    public abstract void setAttackcard(int i);
    public abstract void setArmorcard(int i);
    public abstract void setExp(int i);
    public abstract void setArmor(int i);
    public abstract void setHp(int i);
    public abstract void setHp0(int i);
    public abstract void setSpeed(int i);
}
