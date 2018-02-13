package Task3;

public class Rectangle extends Shape {
    private double a;
    private double b;

    public Rectangle(double a, double b) {        this.a = a;        this.b = b;    }

    void area(){        System.out.println("Площадь прямоугольника = " + a * b);    }
}
