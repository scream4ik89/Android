package Threads;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Downloader {
    public static synchronized void download(String urlAdress) {

        try {
            URL url = new URL(urlAdress);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                File file;
                if (urlAdress.contains(".json")) {
                    file = new File( "work.json");
                } else {
                    file = new File("work.xml");
                }

                try (InputStream streamIn = connection.getInputStream();
                     FileOutputStream streamOut = new FileOutputStream(file)) {

                    byte[] buffer = new byte[2048];
                    int read;
                    while ((read = streamIn.read(buffer)) != -1) {
                        streamOut.write(buffer, 0, read);
                    }
                }
            } else {
                return;
            }
        } catch (IOException e) {
            e.getMessage();
            return;
        }
    }
}
