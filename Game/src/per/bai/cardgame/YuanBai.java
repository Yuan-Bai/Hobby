package per.bai.cardgame;

import java.util.Random;

public class YuanBai implements Character{

    //构造方法
    public YuanBai() {

    }
    public YuanBai(Object o) {

    }

    //人物属性。
    String name = "圆柏";
    boolean gender = true;//性别
    int speed = 5;//速度
    int hp0 = 10;
    int hp = 10;//血量
    int aggressivity = 1;//攻击力
    int cardqtity = 15;//初始卡牌携带量
    int attackcard = 9;//
    int armorcard = 6;//
    int curecard = 0;
    int armor = 0;
    int exp = 0;
    int exexp = 5;
    int grade = 1;


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

    public Card[] getCardArray (){
        return cc;
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

    //打印人物信息
    public void printinfor (){
        System.out.print("人物名字：" + name);
        System.out.print("     性别：");
        System.out.println(gender ? "男" : "女");
        System.out.println("血量：" + hp);
        System.out.print("攻击力：" + aggressivity);
        System.out.println("      护甲值：" + armor);;
        System.out.println("速度值：" + speed);
        System.out.println("      等级：" + grade);
        System.out.println("经验值：" + exp);
        System.out.println("      升级应达到经验值" + exexp);
    }

    //升级程序
    public void upgrade (int exp){
        int oldgrade = grade;
        int sum = exp + this.exp;
        for (int count = 0;count <= 0;) {
            if (sum >= exexp) {
                grade++;
                sum = sum - exexp;
                exexp = (int)((double) exexp * 1.1 + 0.5);
                if (sum < exexp) count++;
            }else {
                this.exp += exp;
                count++;
            }
        }
        if (grade > oldgrade) System.out.println("!!!!!!!!!!!经验已满，升" + (grade - oldgrade) + "级!!!!!!!!!!!!");
        for (;oldgrade < grade;oldgrade++) {
            hp0 += 5;
            hp += 5;
            speed += 1;
            armor += 2;
            aggressivity += 2;
        }
    }


    //人物动作。
    /*public void Action(per.bai.cardgame.Card a,per.bai.cardgame.Slimer s) {
        if (a instanceof per.bai.cardgame.AttackCard){
            per.bai.cardgame.AttackCard attackCard = (per.bai.cardgame.AttackCard)a;
            if (s.armor >= 0){
                int sum = s.hp + s.armor;
                int d = sum - attackCard.aggressivity - aggressivity;
                if (d > per.bai.cardgame.Slimer.hp0){
                    s.armor = d - per.bai.cardgame.Slimer.hp0;
                }else {
                    s.hp  = d;
                    s.armor = 0;
                }
            }else {
                s.hp -= attackCard.aggressivity - aggressivity;
            }
            if (s.hp <= 0)s.hp = 0;
            System.out.println("你发动了攻击");
        }else if (a instanceof per.bai.cardgame.ArmorCard){
            per.bai.cardgame.ArmorCard armorCard = (per.bai.cardgame.ArmorCard)a;
            this.armor += armorCard.armorvalue;
            System.out.println("你使用了护甲牌");
        }else if (a instanceof per.bai.cardgame.CureCard){
            per.bai.cardgame.CureCard cureCard = (per.bai.cardgame.CureCard)a;
            this.hp += cureCard.curevalue;
            System.out.println("你治疗了自己");
        }
    }
    */
    Card[] cc;

    int[] varity;
    public void privarity(){
        varity = new int[Card.varity];
        varity[AttackCard.number] = attackcard;
        varity[ArmorCard.number] = armorcard;
        varity[CureCard.number] = curecard;

    }

    //后期加卡要修改
    public void Card() {
        for (int k = 0;k < i.length;k++){
            if (k < varity[0]) {
                cc[i[k]] = new AttackCard();
            }else if(k < varity[0] + varity[1]){
                cc[i[k]] = new ArmorCard();
            }else if (k < varity[0] + varity[1] + varity[2]){
                cc[i[k]] = new CureCard();
            }
        }
    }

    int[] i;
    public void Cardsort(){
        cc = new Card[cardqtity];
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
        for (;i < cc.length - 1;i++){
            cc[i] = cc[i + 1];
        }
        cc[cc.length - 1] = null;
    }

    //初始化人物
    public void initialization (){
        this.Cardsort();
        this.privarity();
        this.Card();
    }

    @Override
    public void action (Monster m,int w){
        if(hp <= 0)return;
        if (cc[0] == null){
            System.out.println("手牌已无");
            return;
        }
        if (cc[w] instanceof ArmorCard){
            ArmorCard armorCard = (ArmorCard)cc[w];
            this.armor += armorCard.armorvalue;
            System.out.println("你使用了护甲牌,增加了" + armorCard.armorvalue + "点护甲值");
        }else if (cc[w] instanceof AttackCard){
            AttackCard attackCard = (AttackCard)cc[w];
            if (m.getArmor() >= 0){
                int sum = m.getHp() + m.getArmor();
                int d = sum - attackCard.aggressivity - aggressivity;
                if (d > m.getHp0()){
                    //s.armor = d - per.bai.cardgame.YuanBai.hp0;
                    m.setArmor(d - m.getHp0());
                }else {
                    //s.hp  = d;
                    m.setHp(d);
                    //s.armor = 0;
                    m.setArmor(0);
                }
            }else {
                //s.hp -= attackCard.aggressivity - aggressivity;
                m.setHp(m.getHp() - attackCard.aggressivity - aggressivity);
            }
            //if (s.hp <= 0)s.hp = 0;
            if (m.getHp() <= 0)m.setHp(0);
            System.out.println("你发动了攻击,并造成" + (attackCard.aggressivity + aggressivity) + "点伤害");
        }else if (cc[w] instanceof CureCard){
            CureCard c = (CureCard)cc[w];
            int oldhp = this.hp;
            this.hp += c.curevalue;
            if (this.hp > hp0)this.hp = hp0;
            System.out.println("你治疗了自己，并增加了" + (this.hp - oldhp) + "点血量");
        }
        remove(w);
        //cardqtity--;
    }
}
