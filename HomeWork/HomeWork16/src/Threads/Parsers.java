package Threads;

import entity.Pub;
import Parse.Json;
import Parse.Xml;
import java.text.ParseException;


public class Parsers extends Thread {

    public  void setObject(Object object) {
        this.object = object;
    }
    private Object object;

    @Override
    public void run() {
        try {
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Pub company = Xml.parseXML();
            System.out.println(company.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        synchronized (object){
            object.notify();}
        try {
            synchronized (object) {
                object.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Pub company1 =  Json.parseJson();
        System.out.println(company1.toString());
    }
}