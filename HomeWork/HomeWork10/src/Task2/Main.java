package Task2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] arg){
        List<People> man = new ArrayList<>();
        man.add(new People("Петров Иван Сидорович"));
        man.add(new People("Васидльев Петр Иванович"));

        List<People> woman = new ArrayList<>();
        woman.add(new People("Иванова Лиза Владимировна"));
        woman.add(new People("Контимирова Анна Дмитриевна"));

        Map<String, ArrayList<People>> map = new HashMap<>();
        map.put("man", (ArrayList<People>) man);
        map.put("woman", (ArrayList<People>) woman);

        System.out.println("Для поиска мужчин, наберите 'man'" + "\n" + "Для поиска женщинб наберите 'woman'");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String key = reader.readLine();
            for (People h : map.get(key)) {
            }
            System.out.println(map.get(key).get(new Random().nextInt(map.get(key).size())).getFIO());
        }
        catch (Exception e){
            System.out.println("Неверные данные" + e.getMessage());
        }




    }



}
