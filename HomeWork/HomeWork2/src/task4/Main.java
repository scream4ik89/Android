package task4;

import java.util.Scanner;

public class Main {
public static void check(String num) {
    for (int q = 0; q < num.length(); ++q) {
        if (num.charAt(q) < '0' || num.charAt(q) > '9') {
            System.out.println("Ошибочные данные, повторите ввод ");
            return;
            } else if (q > 0 && num.charAt(q) <= num.charAt(q-1)) {
        System.out.println(num + " - данная последовательность не является возрастающей");
        return;
    }
}
    System.out.println(num + " - данная последовательность возрастающая");
}
    public static void main (String[] args){
        System.out.println("Введите число");
        for (Scanner scanner = new Scanner(System.in); scanner.hasNextLine(); ) {
            check(scanner.nextLine());
        }
    }
}