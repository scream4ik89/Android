package Task3;

public class Triangle extends Shape {
    private double a;
    private double b;
    private double angle;

    public Triangle(double a, double b, double angle) {
        this.a = a;
        this.b = b;
        this.angle = angle;    }

    void area(){
        System.out.println("Площадь треугольника = " + 0.5 * a * b * Math.sin(angle));
    }
}
