package manager.Search;

import model.entity.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Класс для поиска по определенному запросу
    с помщью сравнения введенной информации с регулярным выражением
     */

public class SearchByCountry {

    public static void search(List<Beer> beers) throws IOException {
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String str = reader.readLine().toUpperCase();
                Pattern p = Pattern.compile("[A-Z]{2}");
                Matcher m = p.matcher(str);
                if (!m.matches()) {
                    throw new Exception();
                } else {
                    int countName = 0;
                    for (Beer goods : beers) {
                        if (goods.getCountry().toUpperCase().contains(str)) {
                            System.out.println(goods.toString());
                            countName++;
                        }
                    }
                    if (countName == 0) {
                        System.out.println("Поиск не дал результатов. Совпадений не найдено");
                        break;
                    }
                    break;
                }
            }catch (Exception e){
                System.out.println("Неверный ввод данных используйте, используй 2 " +
                        "буквы латинского алфавита");
            }
        } while (true);
    }
}

