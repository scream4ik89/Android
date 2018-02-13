package Task3;

public class Circle extends Shape{
    private double r;

    public Circle(double r) {        this.r = r;    }

    void area(){
        System.out.println("Площадь круга = " + Math.PI * r * r);
    }
}
