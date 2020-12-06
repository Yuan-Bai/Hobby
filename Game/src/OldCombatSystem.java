import java.util.Random;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class OldCombatSystem {
    int cardqtity;
    int mcardqtity;
    Card[] cc;
    Card[] mc;
    public void whichare(Monster monster) {
        if (monster instanceof  Slimer) {
            Slimer slimer = (Slimer)monster;
            mc = new Card[slimer.cardqtity];
            this.mcardqtity = cardqtity;
        }
    }

    public void whichis(Character character) {
        if (character instanceof YuanBai) {
            YuanBai yuanBai = (YuanBai) character;
            cc = new Card[yuanBai.cardqtity];
            this.cardqtity = yuanBai.cardqtity;
        }

    }

    //卡牌种类
    int[] varity;
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

    //获得卡牌
    public void Gain(YuanBai y) {
        y.cardqtity++;
        Random r = new Random();
        int number = r.nextInt(Card.varity);
        varity[number]++;
        switch (number){
            case  0 :
                System.out.println("获得一张攻击卡牌");
            case 1 :
                System.out.println("获得一张护甲卡牌");
            case 2 :
                System.out.println("获得一张治疗卡牌");
        }

    }

    //卡牌随机排序
    int[] i;
    public void Cardsort(){
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

    //与上段代码共同完成卡牌随机排序
    public void Card() {
        for (int k = 0;k < i.length;k++){
            if (k < varity[0]) {
                cc[i[k]] = new AttackCard();
            }else if(k < varity[0] + varity[1]){
                cc[i[k]] = new ArmorCard();
            }
        }
    }

    //
    public void remove (int i){
        for (;i < cc.length - 1;i++){
            cc[i] = cc[i + 1];
        }
        cc[cc.length - 1] = null;
    }

    //打印卡牌信息
    public void printCard (int count){
        int i = 1;
        for (int k = 0; k < count; k++) {
            System.out.print("序列:" + i);
            i++;
            if (cc[0] == null){
                System.out.println("!!!!!!!!!!!!!!!!!!!卡牌库已空!!!!!!!!!!!!!!!!!!!!!!!");
                return;
            }
            if (cc[k] instanceof AttackCard) {
                AttackCard attackCard = (AttackCard) cc[k];
                System.out.print(attackCard.name + "  ");
                System.out.print("护甲值：" + attackCard.armorvalue + "  ");
                System.out.println("攻击力：" + attackCard.aggressivity);
            } else if (cc[k] instanceof ArmorCard) {
                ArmorCard armorCard = (ArmorCard) cc[k];
                System.out.print(armorCard.name + "  ");
                System.out.print("护甲值：" + armorCard.armorvalue + "  ");
                System.out.println("攻击力：" + armorCard.aggressivity);
            }
        }
    }

    //打印怪物信息
    public static void printMonster (Monster monster){
        if (monster instanceof Slimer) {
            Slimer s = (Slimer)monster;
            System.out.println("怪物名字:" + s.name);
            System.out.println("血量:" + s.hp);
            System.out.println("护甲值:" + s.armor);
            System.out.println("攻击力:" + s.aggressivity);
            System.out.println("速度:" + s.speed);
        }
    }

    //打印人物信息
    public void printCharacter (Character c){
        if (c instanceof YuanBai) {
            YuanBai y = (YuanBai)c;
            System.out.println("\n人物名:" + y.name);
            System.out.println("血量:" + y.hp);
            System.out.println("护甲值:" + y.armor);
            System.out.println("攻击力:" + y.aggressivity);
            System.out.println("速度:" + y.speed);
        }
    }

    public Card getcardform (int i){
        switch (i - 1){
            case 0 : return cc[0];
            case 1 : return cc[1];
            case 2 : return cc[2];
            case 3 : return cc[3];
            default: return cc[0];
        }
    }

    //掉落系统
    public void lost (Slimer s,Character c){
        if (c instanceof YuanBai) {
            YuanBai y = (YuanBai) c;
            if (s.hp == 0) {
                Gain(y);
            }
        }
    }

    //系统入口
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CombatSystem combatSystem = new CombatSystem();
        CombatSystem combatSystem1 = new CombatSystem();
        boolean b = true;
        System.out.println("输入【1】开始游戏   输入【2】退出游戏");
        if(1 == sc.nextInt()){
            b = true;
        }else{
            b = false;
        }
        System.out.println("请选择人物：【1】圆柏，【2】暂时无此人物");
        if (1 == sc.nextInt()) {
            while (b) {
                YuanBai y = new YuanBai();
                Monster m;
                combatSystem.whichis(y);
                combatSystem.Cardsort();
                combatSystem.privarity(Card.varity, y);
                combatSystem.Card();
                //combatSystem1.whichare(new Slimer());
                //combatSystem1.Cardsort();
                //combatSystem1.privarity(Card.varity, new Slimer());
                //combatSystem1.Card();
                Random r = new Random();
                int  choosemonster = r.nextInt(5);
                switch (choosemonster){
                    case 1 :
                        m = new Slimer();
                    default:
                        m = new Slimer();
                }
                int count = 4;
                int t;
                if (m instanceof Slimer) {
                    Slimer s = (Slimer) m;
                    while (true) {
                        while (true) {
                            System.out.println("====================================================================");
                            System.out.println("====================================================================");
                            CombatSystem.printMonster(m);

                            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                            System.out.println("玩家卡牌");
                            combatSystem.printCard(count);
                            combatSystem.printCharacter(y);
                            if (y.hp <= 0) {
                                System.out.println("血量为零，游戏失败");
                                return;
                            }
                            System.out.println("\n请输入你要打出的牌的序列，每次只能输入一张，可多次输入,输入0进入下一回合");
                            System.out.println("输入错误则自动打出第一张牌");
                            if (count <= 0) System.out.println("!!!!!!!!!!!!!!!!!!!!!现在手牌已空!!!!!!!!!!!!!!!!!!!!!!!!");
                            t = sc.nextInt();
                            if (t > 4 || t < 0) {
                                System.out.println("输入错误,请重新输入");
                                count++;
                            }
                            switch (t) {
                                case 1:
                                    y.Action(combatSystem.getcardform(1), s);
                                    combatSystem.remove(t - 1);
                                    break;
                                case 2:
                                    y.Action(combatSystem.getcardform(2), s);
                                    combatSystem.remove(t - 1);
                                    break;
                                case 3:
                                    y.Action(combatSystem.getcardform(3), s);
                                    combatSystem.remove(t - 1);
                                    break;
                                case 4:
                                    y.Action(combatSystem.getcardform(4), s);
                                    combatSystem.remove(t - 1);
                                    break;
                                case 0:
                                    count = 5;
                                    break;
                            }
                            count--;
                            if (s.hp <= 0) {
                                System.out.println("游戏胜利");
                                y.upgrade(s.exp);
                                return;
                            }
                            if (t == 0) break;
                        }
                        s.action(y);
                    }
                }
            }
        }
    }*/
}