package com.itacademy.homework.homework6.manager.Parse;

import java.io.File;
/*
    Класс в который приходит значение переменной file(xml или json)
    в зависимости от выбранного варианта и выбирается нужный парсер
     */

public class ParseFactory {
    public static AbstractParser getParser(File file){
        if(file.getName().endsWith(".json")){
            return new Json();
        } else {
            return new Xml();
        }
    }

}
