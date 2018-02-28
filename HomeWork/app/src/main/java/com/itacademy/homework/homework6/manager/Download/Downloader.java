package com.itacademy.homework.homework6.manager.Download;

import com.itacademy.homework.homework6.manager.Manager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/*
    класс для скачивания xml или json файла
     */
public class Downloader implements Runnable{
    String url;
    public Downloader(String url) {
        this.url = url;
    }

    public synchronized void download(String urlAdress) {

        try {
            URL url = new URL(urlAdress);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                File file;
                if (urlAdress.contains(".json")) {
                    file = new File( "pub.json");
                } else {
                    file = new File("pub.xml");
                }

                try (InputStream streamIn = connection.getInputStream();
                     FileOutputStream streamOut = new FileOutputStream(file)) {

                    byte[] buffer = new byte[2048];
                    int read;
                    while ((read = streamIn.read(buffer)) != -1) {
                        streamOut.write(buffer, 0, read);
                    }
                    streamOut.close();
                }
                Manager.getInstance().setFile(file);
            } else {
                return;
            }
        } catch (IOException e) {
            System.out.println("Отсутствует соеденение с интернетом, попробуйте позже" + e.getMessage());
            return;
        }
    }

    @Override
    public void run() {
        download(url);
    }
}
