package Task2.Exception;

public class SpaceUsageTooMuchException extends Exception{
    public SpaceUsageTooMuchException(){
        super("Превышен лимит площади в 70%");
    }
}
