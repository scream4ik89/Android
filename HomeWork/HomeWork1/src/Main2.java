import sun.text.normalizer.Replaceable;

public class Main2 {
       public static void main(String[] arg){
        String text = ("Первое занятие в парке высоких технологий!"); // 1. задание
        int size = text.length();
        String text2 = text.substring(0, text.length() / 2);
        System.out.println("1. задание:  " + text2);
        String text3 = text.substring( text.length() / 2, text.length());
        System.out.println("             " + text3);
        int f = 1027; // 2. задание
        if (f % 10 == 7){
                System.out.println("2. задание:  " + "есть цифра 7");
        }
        else {
            System.out.println("2. задание:  " + "нет цифры 7");
        }
        int a = 4; // 3. задание
        int b = 6;
        int r = 5;
        if (((a + b) * 2) < (3.14 * r * r)) {
            System.out.println("3. задание:  " + "закроет");
        }
        else {
            System.out.println("3. задание:  " + "не закроет");
        }
        int rub = 270;   // 4. задание
        if (rub % 10 == 1){
            System.out.println("4. задание:  " + (rub + " рубль"));
        }
        if (rub % 10 == 2 || rub % 10 == 3 || rub % 10 == 4){
            System.out.println("4. задание:  " + (rub + " рубля"));
        }
        if (rub % 10 == 5 || rub % 10 == 6 || rub % 10 == 7 || rub % 10 == 8 || rub % 10 == 9 || rub % 10 == 0){
            System.out.println("4. задание:  " + (rub + " рублей"));
        }
        String symb = "m?am#a m?la #ra?mu";   // 5. задание
        System.out.println("5. задание:  " + ("Исходное выражение:  " + symb));
        String symb2 = symb.replace("?", "HELLO");
        System.out.println("             " + "Результат замены:    " + symb2.replace("#", ""));
        double x = 10; double s = 2; double t = 2; // 6. задание
        double y = Math.pow(Math.sin(Math.pow(x, t)), 2) / Math.sqrt(1 + Math.pow(x , t)); //sin в радианах
        System.out.println("6. задание:  y=" + y);

    }
}



