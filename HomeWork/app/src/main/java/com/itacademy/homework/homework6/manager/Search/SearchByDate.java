package manager.Search;


import model.entity.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Класс для поиска по определенному запросу
    с помщью сравнения введенной информации с регулярным выражением
     */

public class SearchByDate{

    public static void search(List<Beer> list) throws IOException {
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = reader.readLine().toLowerCase();
                Pattern p = Pattern.compile("\\d{2,4}([-])\\d{1,2}\\1\\d{1,2}$");
                Matcher m = p.matcher(str);
                if (!m.matches()) {

                    throw new Exception();

                } else {
                    int countName = 0;
                    for (Beer goods : list) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        String year = sdf.format(goods.getYear());
                        if (str.equals(year)) {
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
                System.out.println("Неверный ввод данных используйте формат даты yyyy-MM-dd");
            }
        } while (true);
    }
}
