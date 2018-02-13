package Task1;

public class MyExceptionZero extends Exception {
    public MyExceptionZero(){
        super("Division on zero");
    }
    public String getRussianMessage(){
     return "Деление на 0";
    }
}
