
import Entity.Root;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class Main {
    private static final String DATA = "http://kiparo.ru/t/test.xml";
    public static void main(String[] args) throws Exception {

        File file = Download.download(DATA);
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        Sax mySAX = new Sax();
        parser.parse(file, mySAX);
        Root root = mySAX.getRoot();
        System.out.println(root.toString());
    }
}
