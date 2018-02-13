import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<File> files = new ArrayList<>(); // хранилка для мп3 файлов

    public static void main(String[] args) {
        File directoryOfMp3 = new File("E:\\Downloads\\Music\\Christmassy Car Songs");
        directory(directoryOfMp3);
        Map<String, Map<String, List<File>>> mapMap = new HashMap<>();
        for (File f : files) {
            Map<String, List<File>> map = new HashMap<>();
            List<File> list = new ArrayList<>();
            try {
                Mp3File mp3File = new Mp3File(f.getAbsolutePath());
                if (mp3File.hasId3v1Tag()) {
                    ID3v1 id3v1Tag = mp3File.getId3v1Tag();
                    if (mapMap.containsKey(id3v1Tag.getArtist())) {
                        map = mapMap.get(id3v1Tag.getArtist());
                        if (map.containsKey(id3v1Tag.getAlbum())) {
                            list = map.get(id3v1Tag.getAlbum());
                            list.add(f);
                            map.replace(id3v1Tag.getAlbum(), list);
                            mapMap.replace(id3v1Tag.getArtist(), map);
                        } else {
                            list.add(f);
                            map.put(id3v1Tag.getAlbum(), list);
                            mapMap.replace(id3v1Tag.getArtist(), map);
                        }
                    } else {
                        list.add(f);
                        map.put(id3v1Tag.getAlbum(), list);
                        mapMap.put(id3v1Tag.getArtist(), map);
                    }
                }
            } catch (IOException e) {  e.printStackTrace();}
            catch (UnsupportedTagException e) {                e.printStackTrace();            }
            catch (InvalidDataException e) {                e.printStackTrace();            }
        }

        //распечатка результата
        Set<String> keyset = mapMap.keySet();
        String[] keys = keyset.toArray(new String[0]);
        for (String s : keys) {
            System.out.println("Исполнтель: " + s);
            Map<String, List<File>> map = mapMap.get(s);
            Set<String> keyset2 = map.keySet();
            String[] keys2 = keyset2.toArray(new String[0]);
            for (String s2 : keys2) {
                System.out.println("\tАльбом: " + s2);
                List<File> files = map.get(s2);
                if (files != null) {
                    for (File file : files) {
                        Mp3File mp3File = null;
                        try {
                            mp3File = new Mp3File(file.getAbsolutePath());
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (UnsupportedTagException e) {
                            e.printStackTrace();
                        } catch (InvalidDataException e) {
                            e.printStackTrace();
                        }
                        if (mp3File.hasId3v1Tag()) {
                            ID3v1 id3v1Tag = mp3File.getId3v1Tag();
                            System.out.print("Трек: ");
                            if (id3v1Tag.getTitle() != null) {
                                System.out.print(id3v1Tag.getTitle());
                            } else {
                                System.out.print("нет названия");
                            }
                            System.out.println(", длительность : " + mp3File.getLengthInSeconds() / 60 + ":" + mp3File.getLengthInSeconds() % 60 +
                                    file.getAbsolutePath());
                        }  }  }   }  }   }
    public static void directory(File file) { // сканер файлов
        if (file.isDirectory()) {
            File[] arrFiles = file.listFiles();
            for (File a : arrFiles) {
                if (a.isFile()) {
                    String p = "(^[\\d|\\s|\\w|.|\\W]*)(.mp3$)";
                    Pattern pattern = Pattern.compile(p);
                    Matcher m = pattern.matcher(a.getName());
                    if (m.matches()) {
                        files.add(a);
                    }
                } else if (a.isDirectory()) {
                    directory(a);
                }
            }
        }
    }
}
