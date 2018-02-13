import java.util.ArrayList;
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

    public static void main(String[] arg) {
        int key;
        ArrayList<Pacient> pacients = new ArrayList<>();
        for (int i = 0; i <= 1; i++)
            pacients.add(input());
        for (int i = 0; i < pacients.size(); i++)
            System.out.println("Пациент №" + (i + 1) + " " + pacients.get(i));
        Scanner output = new Scanner(System.in);
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

