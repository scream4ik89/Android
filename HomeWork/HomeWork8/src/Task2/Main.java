package Task2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void searchByName(ArrayList<Pacient> array, String name) {
        int n = 0;
        for (int i = 0; i < array.size(); i++) {
            if (name.equals(array.get(i).getName())) {
                System.out.println(array.get(i));
                n++;
            }
        }
        if (n == 0)
            System.out.println("Пациент не найден");
    }

    public static void searchBySorname(ArrayList<Pacient> array, String sorname) {
        int n = 0;
        for (int i = 0; i < array.size(); i++) {
            if (sorname.equals(array.get(i).getSorname())) {
                System.out.println(array.get(i));
                n++;
            }
        }
        if (n == 0)
            System.out.println("Пациент не найден");
    }

    public static void searchByLastname(ArrayList<Pacient> array, String lastname) {
        int n = 0;
        for (int i = 0; i < array.size(); i++) {
            if (lastname.equals(array.get(i).getLastname())) {
                System.out.println(array.get(i));
                n++;
            }
        }
        if (n == 0)
            System.out.println("Пациент не найден");
    }

    public static void searchByAge(ArrayList<Pacient> array, int age) {
        int n = 0;
        for (int i = 0; i < array.size(); i++) {
            if (age == array.get(i).getAge())
                System.out.println(array.get(i));
            n++;
        }
        if (n == 0)
            System.out.println("Пациент не найден");
    }

    public static void searchByGender(ArrayList<Pacient> array, String gender) {
        int n = 0;
        for (int i = 0; i < array.size(); i++) {
            if (gender == array.get(i).getGender())
                System.out.println(array.get(i));
            n++;
        }
        if (n == 0)
            System.out.println("Пациент не найден");
    }

    public static void searchByHeals(ArrayList<Pacient> array, boolean heals) {
        int n = 0;
        for (int i = 0; i < array.size(); i++) {
            if (heals == array.get(i).getHeals())
                System.out.println(array.get(i));
            n++;
        }
        if (n == 0)
            System.out.println("Пациент не найден");
    }

    public static Pacient input() {
        String name;
        int age;
        String gender;
        boolean heals;
        String sorname;
        String lastname;
        Scanner inputs = new Scanner(System.in);
        System.out.println("Введите данные пациента");
        System.out.println("Введите имя пациента:");
        name = inputs.next();
        System.out.println("Введите фамилию пациента:");
        sorname = inputs.next();
        System.out.println("Введите отчество пациента:");
        lastname = inputs.next();
        System.out.println("Введите возраст пациента:");
        age = inputs.nextInt();
        System.out.println("Введите пол пациента:");
        gender = inputs.next();
        System.out.println("Введите состояние пациента: false - не выписан, true - выписан");
        heals = inputs.hasNextBoolean();
        return new Pacient(name, age, heals, gender, sorname, lastname);
    }

    public static void Writer(List<Pacient> pacients) throws IOException {
        try (FileWriter writer = new FileWriter("E:\\Repository\\java-android\\HomeWork\\HomeWork8\\src\\Task2\\text.txt", true)) {
            for (int i = 0; i < pacients.size(); i++){
                String text = pacients.get(i).getName() + "; " + pacients.get(i).getAge() + "; " + pacients.get(i).getHeals() + "; "
                        + pacients.get(i).getGender() + "; " + pacients.get(i).getSorname() + "; " + pacients.get(i).getLastname() + "; " + "\n";
                writer.write(text);
                writer.flush();            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static boolean check(File file) throws Exception{
        boolean state = true;
        try {
            if ( file.exists()) {

            }}catch (Exception e){
            state = false;
            throw new Exception(e.getMessage());

        }
        return state;
}
public static Pacient parse(String[] text) throws Exception{
    if (text.length != 6)
        throw new Exception("Неверное число параметров");
     String name;
     int age;
     boolean heals;
     String gender;
     String sorname;
     String lastname;
    try {
        name = String.valueOf(text[0]);
        age = Integer.valueOf(text[1]);
        heals = Boolean.valueOf(text[2]);
        gender = String.valueOf(text[3]);
        sorname = String.valueOf(text[4]);
        lastname = String.valueOf(text[5]);
        return new Pacient(name,age, heals, gender, sorname, lastname);
    } catch (NumberFormatException e) {
        throw new Exception("Ошибка парсинга: " + e.getMessage());
    }
}
    public static void main(String[] arg) throws Exception {
        int key;
        Scanner output = new Scanner(System.in);
        ArrayList<Pacient> pacients = new ArrayList<>();
        System.out.println("Для чтения из файла нажмите 1, для записи данных нажмите 2");
        key = output.nextInt();
        switch (key){
            case 1:
                List<String> text = new ArrayList<String>();
                File file = new File("E:\\Repository\\java-android\\HomeWork\\HomeWork8\\src\\Task2\\text.txt");
                if (check(file)){
                    System.out.println("Файл найден");
                    text.addAll(Files.readAllLines(Paths.get("E:\\Repository\\java-android\\HomeWork\\HomeWork8\\src\\Task2\\text.txt"), StandardCharsets.UTF_8));
                    for(int i = 0; i < text.size(); i++){
                        String[] v = text.get(i).split(";");
                        pacients.add(parse(v));
                    }}
                else{  System.out.println("Файл не найден");}
            case 2:
                for (int i = 0; i <= 1; i++)
                    pacients.add(input());
                Writer(pacients);
        }

        for (int i = 0; i < pacients.size(); i++)
            System.out.println("Пациент №" + (i + 1) + " " + pacients.get(i));

        System.out.println("Введите данные для поиска пациентов: ");
        System.out.println("1 - поиск по имени, 2 - поиск по фамилии");
        System.out.println("3 - поиск по отчеству, 4 - поиск по возрасту");
        System.out.println("5 - поиск по полу, 6 - поиск по статусу пациента");
        key = output.nextInt();
        switch (key) {
            case 1:
                System.out.println("Введите имя пациента:");
                searchByName(pacients, output.next());
                break;
            case 2:
                System.out.println("Введите фамилию пациента:");
                searchBySorname(pacients, output.next());
                break;
            case 3:
                System.out.println("Введите отчество пациента:");
                searchByLastname(pacients, output.next());
                break;
            case 4:
                System.out.println("Введите возраст пациента:");
                searchByAge(pacients, output.nextInt());
                break;
            case 5:
                System.out.println("Введите пол пациента:");
                searchByGender(pacients, output.next());
                break;
            case 6:
                System.out.println("Введите состояние пациента: false - не выписан, true - выписан");
                searchByHeals(pacients, output.hasNextBoolean());
                break;
        }
    }
}