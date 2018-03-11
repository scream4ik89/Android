package com.itacademy.homework.homework6.manager.Parse;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itacademy.homework.homework6.model.entity.Pub;

import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.xml.parsers.ParserConfigurationException;

/*
    метод для парсинга json файла по средством Gson парсера
     */
public class Json{
    public Pub parse(String nameOfFile)throws ParserConfigurationException,
            IOException, ParseException, SAXException {
        //GsonBuilder builder = new GsonBuilder().registerTypeAdapter(Date.class, new DataGsonConverter());
        Gson gson = new Gson();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(nameOfFile));
        Pub Pub = gson.fromJson(bufferedReader, Pub.class);
        if (Pub == null){
            throw new SAXException("Не удалось расшифровать файл");
        }
        return Pub;
    }
}
