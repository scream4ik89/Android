package Task2;

import java.io.*;
import java.util.ArrayList;

public class WorkWithFiles {
    public static void writeData(ArrayList<Pacient> pacients, File file) {
        if (pacients != null) {
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                out.writeObject(pacients);
                System.out.println("Запись произведена успешно");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static ArrayList<Pacient> readData(File file) {
        ArrayList<Pacient> patients = new ArrayList<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            patients = (ArrayList<Pacient>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Чтение произведено успешно");
        return patients;
    }
}
