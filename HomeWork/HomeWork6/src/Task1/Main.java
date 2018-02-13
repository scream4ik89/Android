package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        int key;
        Scanner scanner = new Scanner(System.in);
        Alfa_bank atm = new Alfa_bank();
        atm.setName("Банкомат - ATM");
        System.out.println(atm.getName());
        atm.setProducerATM("Фирма - IBA");
        System.out.println(atm.getProducerATM());
        System.out.println("Для добавления денег нажмите - 1");
        System.out.println("Для снятия денег нажмите - 2");
        key = scanner.nextInt();
        switch (key) {
            case 1:
                System.out.println("Вставте деньги в купюроприемник");
                atm.addMoney(scanner.nextInt());
                break;
            case 2:
                System.out.println("Какую сумму желаете снять?");
                atm.outputMoney(scanner.nextInt());
        }
        System.out.println("Итого потрачено/добавлено денег - " + atm.getCash());
    }
}
