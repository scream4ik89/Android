package Task2.Exception;

public class IlluminanceTooMuchException extends Exception {
    public IlluminanceTooMuchException(){
        super("Превышен лимита освещённости в 4000лк");
    }
}
