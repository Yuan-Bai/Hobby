import java.util.Random;

public class CombatSystem {
    //卡牌种类
    /*int[] varity;
    public void privarity(Object o){
        varity = new int[Card.varity];
        if (o instanceof YuanBai){
            YuanBai y = (YuanBai)o;
            varity[AttackCard.number] = y.attackcard;
            varity[ArmorCard.number] = y.armorcard;
            varity[CureCard.number] = y.curecard;
        }else if (o instanceof Slimer){
            Slimer s = (Slimer)o;
            varity[AttackCard.number] = s.attackcard;
            varity[ArmorCard.number] = s.armorcard;
            varity[CureCard.number] = s.curecard;
        }
    }
     */


    public void select(int w,Character c,Monster m){
        c.action(m, w-1);
    }

    public void printCard (Card[] cc,int count){
        int i = 1;
        for (int k = 0; k < count; k++) {
            System.out.print("序列:" + i);
            i++;
            if (null == cc[0]){
                System.out.println("!!!!!!!!!!!!!!!!!!!卡牌库已空!!!!!!!!!!!!!!!!!!!!!!!");
                return;
            }
            if (null == cc[k]){
                return;
            }
            if (cc[k] instanceof AttackCard) {
                AttackCard attackCard = (AttackCard) cc[k];
                System.out.print(attackCard.name + "  ");
                System.out.print("护甲值：" + attackCard.armorvalue + "  ");
                System.out.print("攻击力：" + attackCard.aggressivity + "  ");
                System.out.println("治愈值：" + attackCard.curevalue + "  ");
            } else if (cc[k] instanceof ArmorCard) {
                ArmorCard armorCard = (ArmorCard) cc[k];
                System.out.print(armorCard.name + "  ");
                System.out.print("护甲值：" + armorCard.armorvalue + "  ");
                System.out.print("攻击力：" + armorCard.aggressivity + "  ");
                System.out.println("治愈值：" + armorCard.curevalue + "  ");
            } else if (cc[k] instanceof CureCard) {
                CureCard cureCard = (CureCard) cc[k];
                System.out.print(cureCard.name + "  ");
                System.out.print("护甲值：" + cureCard.armorvalue + "  ");
                System.out.print("攻击力：" + cureCard.aggressivity + "  ");
                System.out.println("治愈值：" + cureCard.curevalue + "  ");
            }
        }
    }

    //
    public Monster randomMonster (){
        Random r = new Random();
        int i = r.nextInt(Monster.varity);
        switch (i){
            case 0 :
                return new Slimer();
            case 1 :
                return new Goblin();
            default:
                return new Slimer();
        }
    }

    //掉落系统
    public void lost (Monster m,Character c){
        if (m.getHp() == 0) {
            Gain(c);
        }
    }

    //击杀奖励系统
    public void Gain(Character c) {
        //y.cardqtity++;
        c.setCardqtity(c.getCardqtity() + 1);
        Random r = new Random();
        int number = r.nextInt(Card.varity);
        //varity[number]++;
        switch (number){
            case  0 :
                c.setAttackcard(c.getAttackcard() + 1);
                System.out.println("获得一张攻击卡牌");
                break;
            case 1 :
                c.setArmorcard(c.getArmorcard() + 1);
                System.out.println("获得一张护甲卡牌");
                break;
            case 2 :
                c.setCurecard(c.getCurecard() + 1);
                System.out.println("获得一张治疗卡牌");
                break;
        }
    }
}
