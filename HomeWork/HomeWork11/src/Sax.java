import Entity.People;
import Entity.Root;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class Sax extends DefaultHandler {

    public Root getRoot() {
        return root;
    }

    private Root root = new Root();
    private List<People> peoples = new ArrayList<>();
    private String element = "";
    private boolean isFirstElement = true;
    private People people = null;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start pars doc");

    }

    @Override
    public void startElement(String namespace, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equals("people")) {
            isFirstElement = false;
        }
        if (qName.equals("element")) {
            people = new People();
        }
        element = qName;

    }

    @Override
    public void endElement(String namespace, String localName, String qName) throws SAXException {
        element = "";
        if (qName.equals("element")) {
            peoples.add(people);
        }

    }

    @Override
    public void characters(char[] ch, int start, int end) throws SAXException {


        if (element.equals("name") && isFirstElement) {
            root.setName(String.valueOf(ch, start, end));
            return;
        }

        if (element.equals("name") && !isFirstElement) {
            people.setName(String.valueOf(ch, start, end));
            return;
        }
        if (element.equals("age")) {
            people.setAge(Integer.valueOf(String.valueOf(ch, start, end)));
            return;
        }
        if (element.equals("id")) {
            people.setId(Integer.valueOf(String.valueOf(ch, start, end)));
            return;
        }
        if (element.equals("isDegree")) {
            people.setisDegree(Boolean.parseBoolean(String.valueOf(ch, start, end)));
            return;
        }
        if (element.equals("surname")) {
            people.setSorname(String.valueOf(ch, start, end));
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
        root.setPeople(peoples);
    }

}
