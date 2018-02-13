package Task1;

public class MyExceptionInput extends Exception{
    public MyExceptionInput(){
        super("Wrong input data");
    }
    public String getRussianMessage(){
        return "Неправильный формат данных";
    }
}
