import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, TransformerException, ParserConfigurationException {
        FindTheSame findTheSame = new FindTheSame();
        findTheSame.process(args);
    }
}
