package Task1;

public class Alfa_bank extends defaultATM implements NameATM, ProducerATM, Cash{
    private int count_20; private int count_50; private int count_100; private String producerATM;
    private int cash; private String name; private int money_count;

public Alfa_bank(){
    this.count_20 = 0;
    this.count_50 = 0;
    this.count_100 = 0;
}
    @Override
    public String getName(){
        return name;   }
    public void setName(String name){
        this.name = name;
    }
    @Override
    public String getProducerATM() {
        return producerATM;
    }
    public void setProducerATM(String producerATM){
        this.producerATM = producerATM;
    }
    @Override
    public void addMoney(int money_count) {
        while (money_count >= 0) {
            if (money_count - 100 >= 0) {
                count_100++;
                money_count -= 100;
                continue;
            }
            if ((money_count - 50) >= 0) {
                count_50++;
                money_count -= 50;
                continue;
            }
            if ((money_count - 20) >= 0) {
                count_20++;
                money_count -= 20;
                continue;
            } else {
                System.out.println("Осталось нераспределенных рублей - " + money_count);
                break;
            }
        }
        System.out.println("Вы внесли " + count_100 + " по 100р");
        System.out.println("Вы внесли " + count_50 + " по 50р");
        System.out.println("Вы внесли " + count_20 + " по 20р");
    }
    public void outputMoney(int money_count) {
        while (money_count >= 0) {
            if (money_count - 100 >= 0) {
                count_100++;
                money_count -= 100;
                continue;
            }
            if ((money_count - 50) >= 0) {
                count_50++;
                money_count -= 50;
                continue;
            }
            if ((money_count - 20) >= 0) {
                count_20++;
                money_count -= 20;
                continue;
            } else {
                System.out.println("Осталось " + money_count + " рублей");
                break;
            }
        }
        System.out.println("Вы получили " + count_100 + " по 100р");
        System.out.println("Вы получили " + count_50 + " по 50р");
        System.out.println("Вы получили " + count_20 + " по 20р");
    }
    @Override
    public int getCash() {
        return count_20 *20 + count_50 * 50 + count_100 * 100;
    }
    }



