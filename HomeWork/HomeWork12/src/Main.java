import java.io.IOException;
import java.net.URL;
import Entity.Root;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {
    private static String data = "http://kiparo.ru/t/test.json";
    public static void main(String[] arg) {
        try {
            Root root = new ObjectMapper().readValue(new URL(data), Root.class);
            System.out.println(root.toString());
        } catch (IOException e) {
            System.out.println("Ошибка парсинга \n" + e.getMessage());
        }

    }
}
