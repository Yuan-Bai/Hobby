import java.util.Random;

public class Goblin extends Monster{
    int aggressivity = 3;//怪物攻击力
    static int hp0 = 20;
    int hp = 20;//怪物血量
    int speed = 6;//怪物速度
    String name = "哥布林";//怪物名字
    int cardqtity = 8;//怪物卡牌初始携带量
    int attackcard = 5;
    int curecard = 0;
    int armorcard = 4;
    int armor = 8;
    int exp = 15;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getCardqtity() {
        return cardqtity;
    }

    @Override
    public int getCurecard() {
        return curecard;
    }

    @Override
    public int getAggressivity() {
        return aggressivity;
    }

    @Override
    public int getAttackcard() {
        return attackcard;
    }

    @Override
    public int getArmorcard() {
        return armorcard;
    }

    @Override
    public int getExp() {
        return exp;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getHp0() {
        return hp0;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCardqtity(int i) {
        this.cardqtity = i;
    }

    @Override
    public void setCurecard(int i) {
        this.curecard = i;
    }

    @Override
    public void setAggressivity(int i) {
        this.aggressivity = i;
    }

    @Override
    public void setAttackcard(int i) {
        this.attackcard = i;
    }

    @Override
    public void setArmorcard(int i) {
        this.armorcard = i;
    }

    @Override
    public void setExp(int i) {
        this.exp = i;
    }

    @Override
    public void setArmor(int i) {
        this.armor = i;
    }

    @Override
    public void setHp(int i) {
        this.hp = i;
    }

    @Override
    public void setHp0(int i) {
        this.hp0 = i;
    }

    @Override
    public void setSpeed(int i) {
        this.speed = i;
    }

    public void initialization (){
        this.Cardsort();
        this.privarity();
        this.Card();
    }

    public void printinfor (){
        System.out.print("怪物名字：" + name);
        System.out.println("     性别：无");
        System.out.println("血量：" + hp);
        System.out.print("攻击力：" + aggressivity);
        System.out.println("      护甲值：" + armor);;
        System.out.println("速度值：" + speed);
        //System.out.println("      等级：" + grade);
        System.out.println("经验值：" + exp + '\n');
        //System.out.println("      升级应达到经验值" + exexp);
    }

    public void action (Character c){
        if(hp <= 0)return;
        if (mc[0] == null){
            System.out.println(name + "企图逃跑了");
            return;
        }
        if (mc[0] instanceof ArmorCard){
            ArmorCard a = (ArmorCard)mc[0];
            this.armor += a.armorvalue;
            System.out.println(name + "使用了护甲牌,增加了" + a.armorvalue + "点护甲值");
        }else if (mc[0] instanceof AttackCard){
            AttackCard attackCard = (AttackCard)mc[0];
            if (c.getArmor() >= 0){
                //int sum = y.hp + y.armor;
                int sum = c.getHp() + c.getArmor();
                int d = sum - attackCard.aggressivity - aggressivity;
                if (d > c.getHp0()){
                    //y.armor = d - YuanBai.hp0;
                    c.setArmor(d - c.getHp0());
                }else {
                    //y.hp  = d;
                    c.setHp(d);
                    //y.armor = 0;
                    c.setArmor(0);
                }
            }else {
                //y.hp -= attackCard.aggressivity - aggressivity;
                c.setHp(c.getHp() - attackCard.aggressivity - aggressivity);
            }
            //if (y.hp <= 0)y.hp = 0;
            if (c.getHp() <= 0)c.setHp(0);
            System.out.println(name + "发动了攻击,并造成" + (attackCard.aggressivity + aggressivity) + "点伤害");
        }else if (mc[0] instanceof CureCard){
            int oldhp = this.hp;
            CureCard cureCard = (CureCard)mc[0];
            this.hp += cureCard.curevalue;
            System.out.println(name + "治疗了自己，并增加了" + (this.hp - oldhp) + "点血量");
        }
        remove(0);
        //cardqtity--;
    }

    Card[] mc;

    int[] varity;
    public void privarity(){
        varity = new int[Card.varity];
        varity[AttackCard.number] = attackcard;
        varity[ArmorCard.number] = armorcard;
        varity[CureCard.number] = curecard;

    }

    public void Card() {
        for (int k = 0;k < i.length;k++){
            if (k < varity[0]) {
                mc[i[k]] = new AttackCard();
            }else if(k < varity[0] + varity[1]){
                mc[i[k]] = new ArmorCard();
            }
        }
    }

    int[] i;
    public void Cardsort(){
        mc = new Card[cardqtity];
        i = new int[cardqtity];
        Random r = new Random();
        for (int k = 0;k < i.length;k++){
            i[k] = r.nextInt(cardqtity);
            if(k > 0){
                for(int j = k - 1;j >= 0;j--){
                    if(i[k] == i[j]) {
                        k--;
                        break;
                    }
                }
            }
        }
    }

    public void remove (int i){
        for (;i < mc.length - 1;i++){
            mc[i] = mc[i + 1];
        }
        mc[mc.length - 1] = null;
    }
}
