import Threads.Downloads;
import Threads.Parsers;

public class Main {
    private static final Object object = new Object();
    public static void main(String[] arg){

        Parsers parsers = new Parsers();
        Downloads downloads = new Downloads();

        downloads.setObject(object);
        parsers.setObject(object);

        downloads.start();
        parsers.start();
    }

}

