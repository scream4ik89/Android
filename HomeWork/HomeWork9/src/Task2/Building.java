package Task2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String nameBuilding;
    private List<Room> roomList = new ArrayList<>();
    public void addRoom(Room room){
        roomList.add(room);
    }
    public List<Room> getRoomList() {
        return roomList;
    }

    public String getNameBuilding() {
        return nameBuilding;
    }

    public Building(String nameBuilding){
        this.nameBuilding = nameBuilding;
    }
    @Override
    public String toString() {
        String buff = "";
        for (int i = 0; i < roomList.size(); i++){
            buff += "      Комната " + (i + 1);
            buff += roomList.get(i);
        }
        return  "Здание - " + nameBuilding + '\n' +
                buff;
    }
}