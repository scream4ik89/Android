package Parse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Pub;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Json {

    public static synchronized Pub parseJson() {
        Pub pub = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("work.json")))) {
            GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DataGsonConverter());
            Gson gson = builder.create();
            pub = gson.fromJson(bufferedReader, Pub.class);
        } catch (IOException e) {
            e.getMessage();
            return pub;
        }

        return pub;
    }
}

