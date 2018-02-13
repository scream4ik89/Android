package Task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] arg)throws MyExceptionInput, MyExceptionZero{
        int key = 0;
        double a = 0;
        double b = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число");
        a = sc.nextDouble();
        System.out.println("Введите второе число");
        b = sc.nextDouble();
        System.out.println("Выбор функций калькулятора: \n" + "1 - сложение \n" +
                            "2 - вычитание\n" +"3 - деление\n" + "4 - умножение");
        Calculator calculator = new Calculator(a,b);
            try {
            if (sc.hasNextInt()) {
                key = sc.nextInt();
            }            else                 throw new MyExceptionInput();
        } catch (MyExceptionInput e){

           System.out.println(e.getRussianMessage());
        }


        switch (key){
            case 1:
                System.out.println(a + " + " + b + " = " + calculator.summ());
                break;
            case 2:
                calculator.minus();
                System.out.println(a + " - " + b + " = " + calculator.minus());
                break;
            case 3:
                try {
                    calculator.division();
                    System.out.println(a + " / " + b + " = " + calculator.division());
                }
                catch (MyExceptionZero e){
                    System.out.println(e.getRussianMessage());
                }
                break;
            case 4:
                calculator.multiple();
                System.out.println(a + " * " + b + " = " + calculator.multiple());
                break;
        }

    }
}
