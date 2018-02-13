package Task3;

public class Atm {
    private int count_20;
    private int count_50;
    private int count_100;
    private int money_count;

    public int getCount_20() {
        return count_20;
    }

    public int getCount_50() {
        return count_50;
    }

    public int getCount_100() {
        return count_100;
    }

    public void addMoney(int money_count){
        while (money_count >= 0){
            if (money_count - 100 >= 0){
                count_100++;
                money_count -= 100;
                continue;    }
            if ((money_count - 50) >= 0){
                count_50++;
                money_count -= 50;
                continue;    }
            if ((money_count - 20) >= 0){
                count_20++;
                money_count -= 20;
                continue;    }
            else {System.out.println("Осталось нераспределенных рублей - " + money_count); break;}

        }
        System.out.println("Вы внесли " + count_100 + " по 100р");
        System.out.println("Вы внесли " + count_50 + " по 50р");
        System.out.println("Вы внесли " + count_20 + " по 20р");
    }
    public void getMoney(int money_count){
        while (money_count >= 0){
            if (money_count - 100 >= 0){
                count_100++;
                money_count -= 100;
                continue;        }
            if ((money_count - 50) >= 0){
                count_50++;
                money_count -= 50;
                continue;        }
            if ((money_count - 20) >= 0){
                count_20++;
                money_count -= 20;
                continue;        }
            else {System.out.println("Осталось " + money_count + " рублей" ); break;}

        }
        System.out.println("Вы получили " + count_100 + " по 100р");
        System.out.println("Вы получили " + count_50 + " по 50р");
        System.out.println("Вы получили " + count_20 + " по 20р");
    }
}
