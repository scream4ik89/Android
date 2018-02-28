package manager.Search;

import model.entity.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/*
    Класс для поиска по определенному запросу
    с помщью сравнения введенной информации с регулярным выражением
     */

public class SearchByName{

    public static void search(List<Beer> list) throws IOException {
        do {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            try {
                String str = capitalize(reader.readLine());

                    int countName = 0;
                    for (Beer goods : list) {
                        if (goods.getName().contains(str)) {
                            System.out.println(goods.toString());
                            countName++;
                        }
                    }
                    if (countName == 0) {
                        System.out.println("Поиск не дал результатов. Совпадений не найдено");
                        break;
                    }
                    break;

            }catch (Exception e){
                System.out.println("Неверный ввод данных используйте буквы латинского алфавита");
            }
        } while (true);
    }

    /*
    Метод для того чтобы регистр для пользователя был не важен
     */

    public static String capitalize (String text)
    {

        String text11 = "";

        text11 += Character.toString(text.charAt(0)).toUpperCase();

        for (int i = 1; i < text.length(); i++)
        {

            if (Character.toString(text.charAt(i-1)).equals(" "))
            {
                text11 += Character.toString(text.charAt(i)).toUpperCase();
            }
            else
                text11 += Character.toString(text.charAt(i));

        }
        return text11;
    }

}



