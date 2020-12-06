import java.util.Scanner;

public class Begain {
    static Scanner sc = new Scanner(System.in);
    static Character c;
    public static void main(String[] args) {
        CombatSystem  combatSystem = new CombatSystem();
        boolean b = true;
        System.out.println("输入【1】开始游戏   输入【2】退出游戏");
        int enter1 = sc.nextInt();
        if(1 == enter1){
            b = true;
        }else{
            b = false;
        }
        start();
        to : while (b) {

            //
            Monster m = combatSystem.randomMonster();
            m.initialization();
            //
            c.initialization();
            int count = 4;
            if (c.getSpeed() >= m.getSpeed()) {
                System.out.println("遭遇怪物" + m.getName());
            }


            //遭遇比自己速度慢的怪物
            while (c.getSpeed() >= m.getSpeed()) {
                to1:for (int k = 1; k <= 5; k++) {
                    System.out.println("================================================================================");
                    m.printinfor();
                    combatSystem.printCard(c.getCardArray(), count);
                    c.printinfor();
                    System.out.println("================================================================================");
                    if (count <= 0){
                        System.out.println("!!!!!!!!!!手牌已空!!!!!!!!!!!!");
                        System.out.println("自动进入下一回合");
                        System.out.println("-------------------------------------------------------------------------------");
                        count = 4;
                        break;
                    }
                    System.out.println("请输入对应卡牌序列，输入【0】进入下一回合");
                    int which = sc.nextInt();
                    if (which > count || which < 0) {
                        System.out.println("输入错误,请重新输入");
                        k--;
                        continue to1;
                    } else if (which == 0) {
                        count = 4;
                        break;
                    }
                    combatSystem.select(which, c, m);
                    count--;
                    if (m.getHp() <= 0) {
                        System.out.println("游戏胜利");
                        //y.upgrade(s.exp);
                        c.upgrade(m.getExp());
                        combatSystem.lost(m,c);
                        continue to;
                    }
                }
                m.action(c);
                if (c.getHp() <= 0){
                    System.out.println("血量为零，游戏失败");
                    return;
                }
            }

            //
            if (c.getSpeed() < m.getSpeed()) {
                System.out.println("遭遇怪物" + m.getName());
            }


            //遭遇比自己快的怪物
            while (c.getSpeed() < m.getSpeed()) {
                m.action(c);
                if (c.getHp() <= 0) {
                    System.out.println("血量为零，游戏失败");
                    return;
                }
                to1:
                for (int k = 1; k <= 5; k++) {
                    System.out.println("================================================================================");
                    m.printinfor();
                    combatSystem.printCard(c.getCardArray(), count);
                    c.printinfor();
                    System.out.println("================================================================================");
                    if (count <= 0){
                        System.out.println("!!!!!!!!!!手牌已空!!!!!!!!!!!!");
                        System.out.println("自动进入下一回合");
                        System.out.println("-------------------------------------------------------------------------------");
                        count = 4;
                        break;
                    }
                    System.out.println("请输入对应卡牌序列，输入【0】进入下一回合");
                    int which = sc.nextInt();
                    if (which > count || which < 0) {
                        System.out.println("输入错误,请重新输入");
                        k--;
                        continue to1;
                    } else if (which == 0) {
                        count = 4;
                        break;
                    }
                    combatSystem.select(which, c, m);
                    count--;
                    if (m.getHp() <= 0) {
                        System.out.println("游戏胜利");
                        //y.upgrade(s.exp);
                        c.upgrade(m.getExp());
                        combatSystem.lost(m,c);
                        continue to;
                    }
                }
            }



        }
    }

    //开始界面
    public static void start (){
        System.out.println("请选择人物：【1】圆柏，【2】暂时无此人物");
        int enter2 = sc.nextInt();
        if(1 == enter2){
            c = new YuanBai();
            System.out.println("你选择人物为" + c.getName());
        }else if(2 == enter2){
            System.out.println("暂时无此人物");
        }else {
            System.out.print("\n输入错误\n请重新");
            start();
        }
    }
}
