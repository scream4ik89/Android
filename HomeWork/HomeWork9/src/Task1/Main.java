package Task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word = "";
        System.out.println("Заполните массив даннымии. Для прекращения наберите 'S'");
        while (!word.equals("S")) {
            try {
                word = reader.readLine();
                list.add(word);
            } catch (IOException e) {
                System.out.println("Неверные данные" + e.getMessage());
            }
        }
        list.remove(list.size() - 1);
        System.out.println("Данные юез символа 'a'");
        for (String s : list)
            System.out.println(s.replace("a", "") + " ");
    }
}