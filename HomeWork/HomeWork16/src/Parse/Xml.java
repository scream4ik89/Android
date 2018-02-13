package Parse;

import entity.Beer;
import entity.Pub;
import org.w3c.dom.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



public class Xml {
    public static synchronized Pub parseXML() throws ParseException {

        Document document;

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            document = builder.parse(new File("work.xml"));
        } catch (ParserConfigurationException | IOException | SAXException e) {
            System.out.println("Невозможно открыть XML " + e.getMessage());
            return null;
        }

        //наш объект, который мы будем заполнять данными из xml

        Pub pub = new Pub();

        List<String> emailsList = new ArrayList<>();

        Element rootElement = document.getDocumentElement();

        NodeList namePub = rootElement.getElementsByTagName("name");
        NodeList locationPub = rootElement.getElementsByTagName("location");
        NodeList emailPub = rootElement.getElementsByTagName("emails");

        pub.setName(namePub.item(0).getTextContent());
        pub.setLocation(locationPub.item(0).getTextContent());
        for (int j = 0; j < emailPub.getLength(); j++) {
            Node tmp = emailPub.item(j);
            if (tmp.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            emailsList.add(tmp.getTextContent());
        }
        pub.setEmails((ArrayList<String>) emailsList);

        ArrayList<Beer> beerList = new ArrayList<>();

        NodeList goodsNodes = rootElement.getElementsByTagName("goods");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        for (int i = 0; i < goodsNodes.getLength(); i++) {

            Beer beer = new Beer();

            Element elementBeer = (Element) goodsNodes.item(i);

            NodeList idBeer = elementBeer.getElementsByTagName("id");
            NodeList nameBeer = elementBeer.getElementsByTagName("name");
            NodeList countryBeer = elementBeer.getElementsByTagName("country");
            NodeList yearOfBeer = elementBeer.getElementsByTagName("year");
            NodeList priceofBeer = elementBeer.getElementsByTagName("price");
            NodeList visibleBeer = elementBeer.getElementsByTagName("visible");

            beer.setId(Integer.valueOf(idBeer.item(0).getTextContent()));
            beer.setName(nameBeer.item(0).getTextContent());
            beer.setCountry(countryBeer.item(0).getTextContent());
            beer.setYear(format.parse(yearOfBeer.item(0).getTextContent()));
            beer.setPrice(Integer.valueOf(priceofBeer.item(0).getTextContent()));
            beer.setVisible(Boolean.parseBoolean(visibleBeer.item(0).getTextContent()));
            beerList.add(beer);
        }
        pub.setGoods(beerList);
        return pub;
    }
}
