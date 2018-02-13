package Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String... args) {
        System.out.println("Исходный текст: " + "HeeeeelooooWoooorldddd");
        System.out.println("Результат: " + zipper("HeeeeelooooWoooorldddd"));
    }

    private static String zipper(String data) {
        String result = "";

        Pattern pattern = Pattern.compile("(.)\\1{0,}");

        Matcher matcher = pattern.matcher(data);

        while (matcher.find()) {
            result += matcher.group(1);
            int length = matcher.group().length();
            if (length > 1)
                result += length;
        }
        return result;
    }
}
