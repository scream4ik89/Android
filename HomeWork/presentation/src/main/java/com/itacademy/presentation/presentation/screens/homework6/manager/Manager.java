package com.itacademy.presentation.presentation.screens.homework6.manager;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.itacademy.presentation.presentation.screens.homework6.HomeWork6Activity;
import com.itacademy.presentation.presentation.screens.homework6.model.Download.Downloader;
import com.itacademy.presentation.presentation.screens.homework6.model.Parse.Json;
import com.itacademy.presentation.presentation.screens.homework6.model.entity.Beer;
import com.itacademy.presentation.presentation.screens.homework6.model.entity.Pub;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;


public class Manager  {
private static Manager instance;
    private final String LINK = "http://kiparo.ru/t/pub.json";
    private LocalBroadcastManager mLocalBroadcastManager;
    private ArrayList<Beer> findedBeers = new ArrayList<>();
    private String nameOfFile;
    private Pub pub;

    public void setNameOfFile(String nameOfFile){
        this.nameOfFile = nameOfFile;
    }

    public ArrayList<Beer> getFinded(){
        return findedBeers;
    }


    public static synchronized Manager getInstance(LocalBroadcastManager localBroadcastManager) { // Singleton
        if (instance == null) {
            instance = new Manager(localBroadcastManager);
        }
        return instance;
    }

    private Manager(LocalBroadcastManager localBroadcastManager){
        this.mLocalBroadcastManager = localBroadcastManager;
    }
    public void connect() throws ParserConfigurationException,
            IOException, ParseException, SAXException {
        Downloader url = new Downloader(nameOfFile);
        try {
            url.downloadFile(LINK);
            Json parser = new Json();
            pub = parser.parse(nameOfFile);
        } catch (MalformedInputException e) {
        }
    }

    public void getData(){
        Thread downloadAndParse = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    connect();
                    findedBeers = pub.getGoods();
                    sendNotify();
                }catch (Exception e){
                    Log.e("Hw 6", e.getLocalizedMessage());
                }
            }
        });
        downloadAndParse.start();
    }



    public void searchBeerByName(String name){
        ArrayList<Beer> searched = new ArrayList<>();
        Pattern pattern = Pattern.compile(name.toLowerCase());
        for(Beer beer : pub.getGoods()){
            Matcher matcher = pattern.matcher(beer.getName().toLowerCase());
            Matcher matcher2 = pattern.matcher(beer.getCountry().toLowerCase());
            Matcher matcher3 = pattern.matcher(String.valueOf(beer.getId()).toLowerCase());
            Matcher matcher4 = pattern.matcher(String.valueOf(beer.getPrice()).toLowerCase());
            Matcher matcher5= pattern.matcher(String.valueOf(beer.getYear()).toLowerCase());
            Matcher matcher6 = pattern.matcher(String.valueOf(beer.isVisible()).toLowerCase());

            if (matcher.find() || matcher2.find() || matcher3.find()
                    || matcher4.find() || matcher5.find() || matcher6.find()){
                searched.add(beer);
            }
        }
        findedBeers = searched;
        sendNotify();
    }
    private void sendNotify(){
        mLocalBroadcastManager.sendBroadcast(new Intent(HomeWork6Activity.PARSINGISDONE));
    }

}
