package Task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] arg){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите сторону A, для расчета площади квадрата");
        Shape square = new Square(input.nextDouble());
        square.area();
        System.out.println("Введите сторону A и В, для расчета площади прямоугольника");
        Shape rectangle = new Rectangle(input.nextDouble(), input.nextDouble());
        rectangle.area();
        System.out.println("Введите сторону A, В и угол в градусах для расчета площади треугольника");
        Shape triangle = new Triangle(input.nextDouble(),input.nextDouble(), input.nextDouble());
        triangle.area();
        System.out.println("Введите радиус R, для расчета площади круга");
        Shape circle = new Circle(input.nextDouble());
        circle.area();
    }
}
