package Task2;

abstract public class  Furniture {
    private String Name;
    private double Area;
    private String type;
    public Furniture(String name, double area) {
        Name = name;
        Area = area;
    }

    public String getName() {
        return Name;
    }

    public double getArea() {
        return Area;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  type + " " +
                "Название " + Name +
                ", Площадь " + Area + " м2 ";
    }
}