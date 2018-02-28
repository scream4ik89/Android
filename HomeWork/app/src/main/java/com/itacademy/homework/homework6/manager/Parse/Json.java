package manager.Parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.entity.Pub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/*
    метод для парсинга json файла по средством Gson парсера
     */
public class Json extends AbstractParser implements Runnable{
    public void parse() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("pub.json")))) {
            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DataGsonConverter());
            Gson gson = builder.create();
            Pub pub = gson.fromJson(bufferedReader, Pub.class);
            System.out.println(pub.toString());
            setPub(pub);
        } catch (IOException e) {
            e.getMessage();
        }


    }

}

