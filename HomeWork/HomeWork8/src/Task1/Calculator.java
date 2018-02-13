package Task1;

public class Calculator {
    private double a;
    private double b;

    public Calculator(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double summ(){
        return a + b;
    }
    public double minus(){
        return a - b;
    }
    public double division()throws MyExceptionZero{
        if (b == 0){
            throw new MyExceptionZero();
        }
        return a / b;
    }
    public double multiple(){
        return a * b;
    }

//    @Override
//    public String toString() {
//        return "Calculator{" +
//                "a=" + a +
//                ", b=" + b +
//                '}';
//    }
}
