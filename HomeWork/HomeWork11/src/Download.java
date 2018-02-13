import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;

public class Download {
    public static File download(String DATA) throws ParseException {
        File file = null;
        try {
            URL url = new URL(DATA);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                file = new File("testSax.xml");
                try (InputStream streamIn = connection.getInputStream();
                     FileOutputStream streamOut = new FileOutputStream(file))
                {
                    byte[] buffer = new byte[2048];
                    int read;
                    while ((read = streamIn.read(buffer)) != -1) {
                        streamOut.write(buffer, 0, read);
                    }
                }
            } else {
                System.out.println("Невозможно прочитать файл.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return file;
    }
}
