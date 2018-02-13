package Task3;

public class Square extends Shape{
    private double a;

    public Square(double a) {        this.a = a;    }

    void area(){        System.out.println("Площадь квадрата = " + a*a);    }
}

