package Task2;

import Task2.Exception.IlluminanceTooMuchException;
import Task2.Exception.SpaceUsageTooMuchException;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private String nameRoom;
    public static final int maxPercent = 70; //максимальное заполнение площади мебелью
    private double area;  // площадь и сколько свободно площади осталось
    public static final int window = 700;
    private int countWindow;
    private List<Lamp> lampList = new ArrayList<>();
    private List<Furniture> furnitureList = new ArrayList<>();

    public Room(String nameRoom, double area, int countWindow) {
        this.nameRoom = nameRoom;
        this.area = area;
        this.countWindow = countWindow;
    }

    public int getLampIllum(){    //общая освещенность всех ламп
        int count = 0;
        for (int i = 0; i < lampList.size(); i++){
            count+=lampList.get(i).getLight();
        }
        return count;
    }
    public void addLamp(Lamp lamp) throws Exception{

        if ((getLampIllum() + countWindow * window) + lamp.getLight() <= 4000 )
            lampList.add(lamp);
        else
            throw new IlluminanceTooMuchException();
        return;
        //проверка на пределы допустимого освещения
    }
    public double getAreaFurn(){
        double count = 0;
        for (int i = 0; i < furnitureList.size(); i++){
            count += furnitureList.get(i).getArea();
        }
        return count;
    }
    public void addFurniture(Furniture furniture) throws Exception{

        //должно быть исключение, если места уже нет для мебели
        if ((getAreaFurn() + furniture.getArea()) / area * 100 < maxPercent){
            furnitureList.add(furniture);
        }
        else throw new SpaceUsageTooMuchException();
        return;
    }

    public int getCountWindow() {
        return countWindow;
    }

    public double getArea() {
        return area;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public List<Furniture> getFurnitureList() {
        return furnitureList;
    }

    @Override
    public String toString() {
        String buff1 = "";
        int buff2 = 0;
        if(furnitureList.size() != 0)
        for (int i = 0; i < furnitureList.size(); i++) {
            buff1 += furnitureList.get(i);
            buff1 += "\n";
        }
        else buff1 = "отсутствует";
        for (int i = 0; i < lampList.size(); i++)
            buff2 += lampList.get(i).getLight();
        return   "\n" + "Название комнаты - " + nameRoom  +
                ", площадь = " + area +
                ", свободная площадь = " + (area - getAreaFurn()) + " м2 " +
                ", или " + Math.floor((70 - ( getAreaFurn() / 70 * 100) )) + " % " + "\n" +
                "Количество окон " + countWindow +
                ", освещенность окон " + countWindow * window +
                ", количество ламп " + lampList.size() +
                ", освещенность всех ламп " + buff2 + "\n" +
                "мебель " + buff1 + "\n";
    }
}