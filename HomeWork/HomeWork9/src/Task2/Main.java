package Task2;

import Task2.Furnitures.Bed;
import Task2.Furnitures.CofeTable;
import Task2.Furnitures.Table;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] arg) throws Exception {
        int idQuery = 0;
        boolean state = true;
        String name;
        double s;
        int light;
        int i;
        Building building = new Building("Titan");
        building.addRoom(new Room("kitchen", 10, 1));
        building.addRoom(new Room("bedroom", 20, 2));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            System.out.println("Введите номер комнаты или нажмите 0 для выхода");
            i = Integer.parseInt(reader.readLine());
            if (i > building.getRoomList().size()) {
                System.out.println("Введен не существующий номер комнаты, повторите попытку");
                continue;
            } else if (i == 0) break;
            state = true;
            while (state) {
                System.out.println("Если хотите добавить кровать нажмите - 1\nЕсли стол - 2\nЕсли журнальный столик - 3\n" +
                        "Для добавления лампы - 4 \nДля выхода из комнта нажмите - 5");
                idQuery = Integer.parseInt(reader.readLine());
                switch (idQuery) {
                    case 1:
                        System.out.println("Введите название кровати:");
                        name = reader.readLine();
                        System.out.println("Введите площадь кровати");
                        s = Double.parseDouble(reader.readLine());
                        building.getRoomList().get(i - 1).addFurniture(new Bed(name, s));
                        break;
                    case 2:
                        System.out.println("Введите название стола:");
                        name = reader.readLine();
                        System.out.println("Введите площадь стола");
                        s = Double.parseDouble(reader.readLine());
                        building.getRoomList().get(i - 1).addFurniture(new Table(name, s));
                        break;
                    case 3:
                        System.out.println("Введите название журнального столика:");
                        name = reader.readLine();
                        System.out.println("Введите журнального столика");
                        s = Double.parseDouble(reader.readLine());
                        building.getRoomList().get(i - 1).addFurniture(new CofeTable(name, s));
                        break;
                    case 4:
                        System.out.println("Введите мощность лампы:");
                        light = Integer.parseInt(reader.readLine());
                        building.getRoomList().get(i - 1).addLamp(new Lamp(light));
                        break;
                    case 5:
                        state = false;
                        break;
                    default:
                        System.out.println("Вы ввели не правильный номер, повторите ввод");
                }
            }
        }
        System.out.println(building);
    }
}
